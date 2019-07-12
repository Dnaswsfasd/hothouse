package cn.moriaty.hothouse.service;

import cn.moriaty.hothouse.mapper.UpPwdMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 16计算机 Moriaty
 * @version 1.0
 * @copyright ：Moriaty 版权所有 © 2019
 * @date 2019/6/19 15:32
 * @Description TODO
 * 修改密码接口 Service
 */
@Service
public class UpPwdService {

    @Autowired(required = false)
    UpPwdMapper mapper;

    // 修改密码
    public Integer upPwd(String account, String oldPwd, String newPwd) {
        return mapper.upPwd(account, oldPwd, newPwd);
    }
}
