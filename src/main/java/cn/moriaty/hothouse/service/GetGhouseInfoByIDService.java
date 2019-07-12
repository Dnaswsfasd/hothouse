package cn.moriaty.hothouse.service;

import cn.moriaty.hothouse.bean.Hothouse;
import cn.moriaty.hothouse.mapper.GetGhouseInfoByIDMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 16计算机 Moriaty
 * @version 1.0
 * @copyright ：Moriaty 版权所有 © 2019
 * @date 2019/6/20 11:49
 * @Description TODO
 * 获取一个温室所有时间的统计信息接口 Service
 */
@Service
public class GetGhouseInfoByIDService {
    @Autowired(required = false)
    GetGhouseInfoByIDMapper mapper;

    public Hothouse getHothouse(String ID) {
        Hothouse hothouse = mapper.getHothouse(ID);
        if (hothouse == null) {
            return null;
        } else {
            hothouse.setData(mapper.getDataList(ID));
            return hothouse;
        }
    }
}
