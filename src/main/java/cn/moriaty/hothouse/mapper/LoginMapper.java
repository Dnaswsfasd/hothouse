package cn.moriaty.hothouse.mapper;

import cn.moriaty.hothouse.bean.User;
import org.apache.ibatis.annotations.Select;

/**
 * @author 16计算机 Moriaty
 * @version 1.0
 * @copyright ：Moriaty 版权所有 © 2019
 * @date 2019/6/13 20:50
 * @Description TODO
 * 登录接口 Mapper
 */
public interface LoginMapper {

    //根据用户名和密码获取帐号存在
    @Select("SELECT * FROM user WHERE account = #{account} AND pwd = #{pwd}")
    public User getUser(String account,String pwd);
}
