package com.hmall.item.es;

import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
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

import java.io.IOException;
import java.util.Map;

/**
 * 索引库测试
 * @author lixuan
 * @Date 2024/9/5 10:28
 */
//@SpringBootTest
public class ElasticTest {

    private RestHighLevelClient restHighLevelClient;

    /**
     * 测试连接
     */
    @Test
    void testConnection() {
        System.out.println("restHighLevelClient ===> "+restHighLevelClient);
    }

    //--------------------------------------索引库--------------------------------------------------

    /**
     * 创建索引库
     */
    @Test
    void testCreateIndex() throws IOException {
        // 1.准备Request对象
        CreateIndexRequest createIndexRequest = new CreateIndexRequest("items");
        // 2.准备请求参数
        createIndexRequest.source(MAPPING_TEMPLATE, XContentType.JSON);
        // 3.发送请求
        restHighLevelClient.indices().create(createIndexRequest, RequestOptions.DEFAULT);
    }

    /**
     * 查询索引库
     */
    @Test
    void testGetIndex() throws IOException {
        // 1.准备Request对象
        GetIndexRequest getIndexRequest = new GetIndexRequest("items");
        // 2.发送请求
        boolean exists = restHighLevelClient.indices().exists(getIndexRequest, RequestOptions.DEFAULT);
        System.out.println("索引库是否存在===>"+exists);

        // 如果不存在，直接返回
        if (!exists) {
            return;
        }

        GetIndexResponse getIndexResponse = restHighLevelClient.indices().get(getIndexRequest, RequestOptions.DEFAULT);
        String[] indexNames = getIndexResponse.getIndices();
        // 解析getIndexResponse
        for (String index : indexNames) {
            Map<String, Object> indexMappings = getIndexResponse.getMappings().get(index).sourceAsMap();
            System.out.println("Mappings for index ===> " + index + ": " + indexMappings);
        }

    }

    /**
     * 删除索引库
     */
    @Test
    void testDeleteIndex() throws IOException {
        // 1.准备Request对象
        DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest("items");
        // 2.发送请求
        restHighLevelClient.indices().delete(deleteIndexRequest, RequestOptions.DEFAULT);
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

    static final String MAPPING_TEMPLATE = "{\n" +
            "  \"mappings\": {\n" +
            "    \"properties\": {\n" +
            "      \"id\": {\n" +
            "        \"type\": \"keyword\"\n" +
            "      },\n" +
            "      \"name\":{\n" +
            "        \"type\": \"text\",\n" +
            "        \"analyzer\": \"ik_max_word\"\n" +
            "      },\n" +
            "      \"price\":{\n" +
            "        \"type\": \"integer\"\n" +
            "      },\n" +
            "      \"stock\":{\n" +
            "        \"type\": \"integer\"\n" +
            "      },\n" +
            "      \"image\":{\n" +
            "        \"type\": \"keyword\",\n" +
            "        \"index\": false\n" +
            "      },\n" +
            "      \"category\":{\n" +
            "        \"type\": \"keyword\"\n" +
            "      },\n" +
            "      \"brand\":{\n" +
            "        \"type\": \"keyword\"\n" +
            "      },\n" +
            "      \"sold\":{\n" +
            "        \"type\": \"integer\"\n" +
            "      },\n" +
            "      \"commentCount\":{\n" +
            "        \"type\": \"integer\"\n" +
            "      },\n" +
            "      \"isAD\":{\n" +
            "        \"type\": \"boolean\"\n" +
            "      },\n" +
            "      \"updateTime\":{\n" +
            "        \"type\": \"date\"\n" +
            "      }\n" +
            "    }\n" +
            "  }\n" +
            "}";
}
