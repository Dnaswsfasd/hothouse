package cn.moriaty.hothouse.service;

import cn.moriaty.hothouse.bean.User;
import cn.moriaty.hothouse.mapper.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 16计算机 Moriaty
 * @version 1.0
 * @copyright ：Moriaty 版权所有 © 2019
 * @date 2019/6/13 20:55
 * @Description TODO
 * 登录接口 Service
 */
@Service
public class LoginService {

    @Autowired(required = false)
    private LoginMapper mapper;

    public Boolean getUser(String account, String pwd) {
        User user = mapper.getUser(account, pwd);
        if(user != null){
            return true;
        }else{
            return false;
        }
    }
}
