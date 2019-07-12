package cn.moriaty.hothouse.mapper;

import cn.moriaty.hothouse.bean.Hothouse;
import cn.moriaty.hothouse.bean.HothouseData;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 16计算机 Moriaty
 * @version 1.0
 * @copyright ：Moriaty 版权所有 © 2019
 * @date 2019/6/20 11:44
 * @Description TODO
 * 获取一个温室所有时间的统计信息接口 Mapper
 */
public interface GetGhouseInfoByIDMapper {
    // 获取一个温室所有的数据
    @Select("SELECT * FROM hothouse_data WHERE hothouse = #{hothouse}")
    public List<HothouseData> getDataList(String hothouse);

    // 获取温室信息
    @Select("SELECT * FROM hothouse WHERE ID = #{ID}")
    public Hothouse getHothouse(String ID);
}
