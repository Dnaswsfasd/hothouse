package cn.moriaty.hothouse.service;

import cn.moriaty.hothouse.bean.Hothouse;
import cn.moriaty.hothouse.mapper.GetMyGhouseListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 16计算机 Moriaty
 * @version 1.0
 * @copyright ：Moriaty 版权所有 © 2019
 * @date 2019/6/20 9:17
 * @Description TODO
 * 获取我的温室列表 Service
 */
@Service
public class GetMyGhouseListService {
    @Autowired(required = false)
    GetMyGhouseListMapper mapper;

    public List<Hothouse> getMyGhouseList(String account) {
        return mapper.getMyGhouseList(account);
    }
}
