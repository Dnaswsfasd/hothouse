package cn.moriaty.hothouse.mapper;

import org.apache.ibatis.annotations.Update;

/**
 * @author 16计算机 Moriaty
 * @version 1.0
 * @copyright ：Moriaty 版权所有 © 2019
 * @date 2019/6/18 21:26
 * @Description TODO
 * 完善个人信息接口 Mapper
 */
public interface PerfectUserInfoMapper {

    // 完善个人信息
    @Update("UPDATE user SET name = #{name}, sex = #{sex}, phone = #{phone}, mailbox = #{mailbox} WHERE account = #{account}")
    public Integer perfectUserInfo(String account, String name, Integer sex, String phone, String mailbox);
}
