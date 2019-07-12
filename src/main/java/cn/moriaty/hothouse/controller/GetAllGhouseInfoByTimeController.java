package cn.moriaty.hothouse.controller;

import cn.moriaty.hothouse.bean.Hothouse;
import cn.moriaty.hothouse.service.GetAllGhouseInfoByTimeService;
import cn.moriaty.hothouse.utils.AllConstant;
import cn.moriaty.hothouse.utils.HttpUtil;
import cn.moriaty.hothouse.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

/**
 * @author 16计算机 Moriaty
 * @version 1.0
 * @copyright ：Moriaty 版权所有 © 2019
 * @date 2019/6/20 9:50
 * @Description TODO
 * 获取所有温室某个时间的统计信息接口 Controller
 */
@RestController
public class GetAllGhouseInfoByTimeController {

    @Autowired
    GetAllGhouseInfoByTimeService service;

    @GetMapping(value = "getAllGhouseInfoByTime")
    public String getAllGhouseInfoByTime(HttpServletRequest request) {
        String result = "";
        try {
            HashMap<String, String> params = JsonUtil.getRequestParams(request);
            result = HttpUtil.checkParams(params, new String[]{"startTime", "endTime"});
            if (!"".equals(result.trim())) {
                return result;
            }
            List<Hothouse> list = service.getAllGhouseInfoByTime(params.get("startTime"), params.get("endTime"));
            if (list == null || list.isEmpty()) {
                result = JsonUtil.jsonResponse(null, AllConstant.CODE_ERROR, "获取失败");
            } else {
                result = JsonUtil.jsonResponse(list, AllConstant.CODE_SUCCESS, "获取成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = JsonUtil.jsonResponse(null, AllConstant.CODE_ERROR, AllConstant.MSG_ERROR);
        }
        return result;
    }
}
