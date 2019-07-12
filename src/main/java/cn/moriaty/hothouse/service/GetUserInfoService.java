package cn.moriaty.hothouse.service;

import cn.moriaty.hothouse.bean.User;
import cn.moriaty.hothouse.mapper.GetUserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 16计算机 Moriaty
 * @version 1.0
 * @copyright ：Moriaty 版权所有 © 2019
 * @date 2019/6/18 22:19
 * @Description TODO
 * 获取个人信息接口 Service
 */
@Service
public class GetUserInfoService {

    @Autowired(required = false)
    GetUserInfoMapper mapper;

    public User getUserInfo(String account) {
        return mapper.getUserInfo(account);
    }
}
