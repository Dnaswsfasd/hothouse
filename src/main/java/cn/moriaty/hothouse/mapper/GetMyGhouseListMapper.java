package cn.moriaty.hothouse.mapper;

import cn.moriaty.hothouse.bean.Hothouse;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @copyright ：Moriaty 版权所有 © 2019
 * @author 16计算机 Moriaty
 * @version 1.0
 * @date 2019/6/20 9:15
 * @Description TODO
 *   获取我的温室列表 Mapper
 */
public interface GetMyGhouseListMapper {

    // 获取我的所有温室
    @Select("SELECT * FROM hothouse WHERE `user` = #{account}")
    public List<Hothouse> getMyGhouseList(String account);
}
