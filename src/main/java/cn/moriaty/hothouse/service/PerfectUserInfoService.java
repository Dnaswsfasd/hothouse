package cn.moriaty.hothouse.service;

import cn.moriaty.hothouse.mapper.PerfectUserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * @copyright ：Moriaty 版权所有 © 2019
 * @author 16计算机 Moriaty
 * @version 1.0
 * @date 2019/6/18 22:06
 * @Description TODO
 *   完善个人信息接口 Service
 */
@Service
public class PerfectUserInfoService {

    @Autowired(required = false)
    PerfectUserInfoMapper mapper;

    public Integer perfectUserInfo(String account, String name, Integer sex, String phone, String mailbox) {
        return mapper.perfectUserInfo(account, name, sex, phone, mailbox);
    }
}
