package cn.moriaty.hothouse.mapper;

import cn.moriaty.hothouse.bean.User;
import org.apache.ibatis.annotations.Select;

/**
 * @copyright ：Moriaty 版权所有 © 2019
 * @author 16计算机 Moriaty
 * @version 1.0
 * @date 2019/6/18 22:16
 * @Description TODO
 *   获取个人信息接口 Mapper
 */
public interface GetUserInfoMapper {

    // 获取个人信息
    @Select("SELECT * FROM user WHERE account = #{account}")
    public User getUserInfo(String account);
}
