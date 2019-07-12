package cn.moriaty.hothouse.mapper;

import org.apache.ibatis.annotations.Delete;

/**
 * @author 16计算机 Moriaty
 * @version 1.0
 * @copyright ：Moriaty 版权所有 © 2019
 * @date 2019/6/19 21:50
 * @Description TODO
 * 删除我的温室 Mapper
 */
public interface DeleteMyGhouseMapper {

    // 删除温室
    @Delete("DELETE FROM hothouse WHERE ID = #{ID} AND `user` = #{account}")
    public Integer deleteGhouse(String ID, String account);
}
