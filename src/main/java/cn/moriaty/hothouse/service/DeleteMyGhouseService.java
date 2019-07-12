package cn.moriaty.hothouse.service;

import cn.moriaty.hothouse.mapper.DeleteMyGhouseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 16计算机 Moriaty
 * @version 1.0
 * @copyright ：Moriaty 版权所有 © 2019
 * @date 2019/6/19 21:53
 * @Description TODO
 * 删除我的温室 Service
 */
@Service
public class DeleteMyGhouseService {

    @Autowired(required = false)
    DeleteMyGhouseMapper mapper;

    public Integer deleteGhouse(String account, String ID) {
        return mapper.deleteGhouse(ID, account);
    }
}
