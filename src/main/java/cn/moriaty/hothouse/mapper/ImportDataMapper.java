package cn.moriaty.hothouse.mapper;

import org.apache.ibatis.annotations.Update;

/**
 * @author 16计算机 Moriaty
 * @version 1.0
 * @copyright ：Moriaty 版权所有 © 2019
 * @date 2019/6/19 22:19
 * @Description TODO
 * 导入数据 Mapper
 */
public interface ImportDataMapper {

    // 导入数据
    @Update("INSERT INTO hothouse_data(ID,hothouse,time,temperature,CO2,humidity,soil,light) VALUES(#{ID},#{houseID}," +
            "#{time},#{temperature},#{CO2},#{humidity},#{soil},#{light})")
    public Integer importData(String ID, String houseID, String time, String temperature, String CO2, String humidity, String soil, String light);
}
