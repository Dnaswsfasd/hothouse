package cn.moriaty.hothouse.service;

import cn.moriaty.hothouse.mapper.BuildMyGhouseMapper;
import cn.moriaty.hothouse.utils.DateUtil;
import cn.moriaty.hothouse.utils.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author 16计算机 Moriaty
 * @version 1.0
 * @copyright ：Moriaty 版权所有 © 2019
 * @date 2019/6/19 15:44
 * @Description TODO
 * 新建我的温室接口 Service
 */
@Service
public class BuildMyGhouseService {
    @Autowired(required = false)
    BuildMyGhouseMapper mapper;

    // 新建温室
    public Integer buildGhouse(String account, String name, String desc) {
        return mapper.buildGhouse(account, UUIDUtil.getUUID(), name, desc, DateUtil.dateToString(new Date()));
    }
}
