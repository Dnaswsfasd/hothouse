package cn.moriaty.hothouse.mapper;

import cn.moriaty.hothouse.bean.Hothouse;
import cn.moriaty.hothouse.bean.HothouseData;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 16计算机 Moriaty
 * @version 1.0
 * @copyright ：Moriaty 版权所有 © 2019
 * @date 2019/6/20 9:25
 * @Description TODO
 * 获取所有温室某个时间的统计信息接口 Mapper
 */
public interface GetAllGhouseInfoByTimeMapper {

    // 获取温室某个时间的统计信息
    @Select("SELECT * FROM hothouse_data WHERE hothouse = #{hothouse} AND time BETWEEN #{startTime} AND #{endTime}")
    public List<HothouseData> getDataList(String hothouse, String startTime, String endTime);

    // 获取所有温室
    @Select("SELECT * FROM hothouse")
    public List<Hothouse> getHothouseList();
}
