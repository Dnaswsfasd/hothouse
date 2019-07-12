package cn.moriaty.hothouse.service;

import cn.moriaty.hothouse.bean.Hothouse;
import cn.moriaty.hothouse.bean.HothouseData;
import cn.moriaty.hothouse.mapper.GetAllGhouseInfoByTimeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

/**
 * @author 16计算机 Moriaty
 * @version 1.0
 * @copyright ：Moriaty 版权所有 © 2019
 * @date 2019/6/20 9:45
 * @Description TODO
 * 获取所有温室某个时间的统计信息接口 Service
 */
@Service
public class GetAllGhouseInfoByTimeService {
    @Autowired(required = false)
    GetAllGhouseInfoByTimeMapper mapper;

    public List<Hothouse> getAllGhouseInfoByTime(String startTime, String endTime) {

        List<Hothouse> list = mapper.getHothouseList();
        Iterator<Hothouse> ite = list.iterator();
        while (ite.hasNext()) {
            Hothouse hothouse = ite.next();
            List<HothouseData> dataList = mapper.getDataList(hothouse.getID(), startTime, endTime);
            if (dataList.isEmpty() || dataList == null) {
                ite.remove();
            } else {
                hothouse.setData(dataList);
            }
        }
        return list;
    }
}
