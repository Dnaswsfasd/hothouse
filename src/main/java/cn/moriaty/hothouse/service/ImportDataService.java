package cn.moriaty.hothouse.service;

import cn.moriaty.hothouse.mapper.ImportDataMapper;
import cn.moriaty.hothouse.utils.DateUtil;
import cn.moriaty.hothouse.utils.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author 16计算机 Moriaty
 * @version 1.0
 * @copyright ：Moriaty 版权所有 © 2019
 * @date 2019/6/19 22:29
 * @Description TODO
 * 导入数据接口 Service
 */
@Service
public class ImportDataService {
    @Autowired(required = false)
    ImportDataMapper mapper;

    public Integer importData(String ID, String temperature, String CO2, String humidity, String soil, String light) {
        return mapper.importData(UUIDUtil.getUUID(), ID, DateUtil.dateToString(new Date()), temperature, CO2, humidity, soil, light);
    }
}
