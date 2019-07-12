package cn.moriaty.hothouse.controller;

import cn.moriaty.hothouse.bean.Hothouse;
import cn.moriaty.hothouse.service.GetGhouseInfoByIDService;
import cn.moriaty.hothouse.utils.AllConstant;
import cn.moriaty.hothouse.utils.HttpUtil;
import cn.moriaty.hothouse.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * @author 16计算机 Moriaty
 * @version 1.0
 * @copyright ：Moriaty 版权所有 © 2019
 * @date 2019/6/20 11:52
 * @Description TODO
 * 获取一个温室所有时间的统计信息接口 Controller
 */
@RestController
public class GetGhouseInfoByIDController {

    @Autowired
    GetGhouseInfoByIDService service;

    @GetMapping(value = "getGhouseInfoByID")
    public String getGhouseInfoByID(HttpServletRequest request) {
        String result = "";
        try {
            HashMap<String, String> params = JsonUtil.getRequestParams(request);
            result = HttpUtil.checkParams(params, new String[]{"ID"});
            if (!"".equals(result.trim())) {
                return result;
            }
            Hothouse hothouse = service.getHothouse(params.get("ID"));
            if(hothouse == null || hothouse.getData() == null){
                result = JsonUtil.jsonResponse(null, AllConstant.CODE_ERROR, "没有数据");
            }else{
                result = JsonUtil.jsonResponse(hothouse, AllConstant.CODE_SUCCESS, "获取成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = JsonUtil.jsonResponse(null, AllConstant.CODE_ERROR, AllConstant.MSG_ERROR);
        }
        return result;
    }
}
