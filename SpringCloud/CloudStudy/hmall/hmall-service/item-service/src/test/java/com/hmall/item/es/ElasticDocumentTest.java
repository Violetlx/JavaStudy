package com.hmall.item.es;

import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hmall.common.utils.BeanUtils;
import com.hmall.item.domain.po.Item;
import com.hmall.item.domain.po.ItemDoc;
import com.hmall.item.service.IItemService;
import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * 文档
 * @author lixuan
 * @Date 2024/9/5 10:28
 */
@SpringBootTest(properties = "spring.profiles.active=local")
public class ElasticDocumentTest {

    private RestHighLevelClient restHighLevelClient;
    @Resource
    private IItemService itemService;

    /**
     * 测试连接
     */
    @Test
    void testConnection() {
        System.out.println("restHighLevelClient ===> "+restHighLevelClient);
    }

    //--------------------------------------文档--------------------------------------------------

    /**
     * 新增文档/全量更新
     */
    @Test
    void testIndexDoc() throws IOException {
        // 0.准备文档数据
        // 0.1.根据id查询数据库
        Item item = itemService.getById(584382L);
        // 0.2.封装成索引库实体
        ItemDoc itemDoc = BeanUtils.copyProperties(item, ItemDoc.class);
        // 1.准备Request请求
        IndexRequest indexRequest = new IndexRequest("items").id(itemDoc.getId());
        // 2.准备请求参数
        indexRequest.source(JSONUtil.toJsonStr(itemDoc), XContentType.JSON);
        // 3.发送请求
        restHighLevelClient.index(indexRequest,RequestOptions.DEFAULT);
    }

    /**
     * 查询文档
     */
    @Test
    void testGetDoc() throws IOException {
        // 1.准备Request对象
        GetRequest request = new GetRequest("items").id("584382");
        // 2.发送请求,判断文档是否存在
        boolean exists = restHighLevelClient.exists(request, RequestOptions.DEFAULT);
        System.out.println("文档是否存在 ===> "+exists);
        // 3.处理响应
        if (!exists) {
            return;
        }
        // 4.查询文档数据
        GetResponse response = restHighLevelClient.get(request, RequestOptions.DEFAULT);
        // 5.获取响应结果中的source
        String json = response.getSourceAsString();
        ItemDoc itemDoc = JSONUtil.toBean(json, ItemDoc.class);
        System.out.println("itemDoc= " + itemDoc);
    }

    /**
     * 删除文档
     */
    @Test
    void testDeleteDoc() throws IOException {
        // 1.准备Request对象
        DeleteRequest request = new DeleteRequest("items", "584382");
        // 2.发送请求
        DeleteResponse delete = restHighLevelClient.delete(request, RequestOptions.DEFAULT);
        System.out.println("delete ===> "+delete.getId());
    }

    /**
     * 修改局部更新
     */
    @Test
    void testUpdateDoc() throws IOException {
        // 1.准备Request
        UpdateRequest updateRequest = new UpdateRequest("items", "584382");
        // 2.准备请求参数,没2个参数为一对key-value
        updateRequest.doc(
                "price", 58800,
                "commentCount", 1
        );
        // 3.发送请求
        restHighLevelClient.update(updateRequest, RequestOptions.DEFAULT);
    }

    /**
     * 批处理文档
     */
    @Test
    void testBulk() throws IOException {
        int pageNo = 1, pageSize = 500;
        while (true) {
            // 0.准备文档数据
            Page<Item> page = itemService.lambdaQuery()
                    .eq(Item::getStatus, 1)
                    .page(Page.of(pageNo, pageSize));
            List<Item> records = page.getRecords();
            if (records == null || records.isEmpty()) {
                System.out.println("没有数据");
                return;
            }
            // 1.创建Request
            BulkRequest bulkRequest = new BulkRequest();
            // 2.准备请求参数
            for (Item item : records) {
                bulkRequest.add(new IndexRequest("items")
                        .id(item.getId().toString())
                        .source(JSONUtil.toJsonStr(BeanUtils.copyProperties(item, ItemDoc.class)), XContentType.JSON));
            }
            // 3.发送请求
            restHighLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);

            //翻页
            pageNo++;
        }
    }


    @BeforeEach
    void setUp() {
        restHighLevelClient = new RestHighLevelClient(RestClient.builder(
                HttpHost.create("http://192.168.223.100:9200")
        ));
    }

    @AfterEach
    void tearDown() throws IOException {
        if (restHighLevelClient == null) {
            restHighLevelClient.close();
        }
    }
}
