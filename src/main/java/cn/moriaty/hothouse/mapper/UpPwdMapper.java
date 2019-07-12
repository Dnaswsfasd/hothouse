package cn.moriaty.hothouse.mapper;

import org.apache.ibatis.annotations.Update;

/**
 * @author 16计算机 Moriaty
 * @version 1.0
 * @copyright ：Moriaty 版权所有 © 2019
 * @date 2019/6/19 15:30
 * @Description TODO
 * 修改密码接口 Mapper
 */
public interface UpPwdMapper {

    // 修改密码
    @Update("UPDATE user SET pwd = #{newPwd} WHERE account = #{account} AND pwd = #{oldPwd}")
    public Integer upPwd(String account, String oldPwd, String newPwd);

}
