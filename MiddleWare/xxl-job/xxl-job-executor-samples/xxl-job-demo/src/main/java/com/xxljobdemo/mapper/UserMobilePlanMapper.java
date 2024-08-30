package com.xxljobdemo.mapper;

import com.xxljobdemo.domain.UserMobilePlan;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author lixuan
 * @Date 2024/7/17 21:19
 */
@Mapper
public interface UserMobilePlanMapper {
    /**
     * 根据id查询
     * @param shardingTotal
     * @param shardingIndex
     * @return
     */
    @Select("select * from t_user_mobile_plan where mod(id,#{shardingTotal})=#{shardingIndex}")
    List<UserMobilePlan> selectByMod(@Param("shardingIndex") Integer shardingIndex, @Param("shardingTotal")Integer shardingTotal);
    /**
     * 查询所有数据
     * @return
     */
    @Select("select * from t_user_mobile_plan")
    List<UserMobilePlan> selectAll();
}