package cn.moriaty.hothouse.mapper;

import org.apache.ibatis.annotations.Insert;

/**
 * @author 16计算机 Moriaty
 * @version 1.0
 * @copyright ：Moriaty 版权所有 © 2019
 * @date 2019/6/19 15:41
 * @Description TODO
 * 新建我的温室接口 Mapper
 */
public interface BuildMyGhouseMapper {

    // 新建温室
    @Insert("INSERT INTO hothouse(ID,`name`,`user`,time,`desc`) VALUES(#{ID},#{name},#{account},#{time},#{desc})")
    public Integer buildGhouse(String account, String ID, String name, String desc, String time);
}
