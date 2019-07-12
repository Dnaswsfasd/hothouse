package cn.moriaty.hothouse.controller;

import cn.moriaty.hothouse.bean.Hothouse;
import cn.moriaty.hothouse.service.GetMyGhouseListService;
import cn.moriaty.hothouse.utils.AllConstant;
import cn.moriaty.hothouse.utils.JWTUtil;
import cn.moriaty.hothouse.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author 16计算机 Moriaty
 * @version 1.0
 * @copyright ：Moriaty 版权所有 © 2019
 * @date 2019/6/20 9:19
 * @Description TODO
 * 获取我的温室列表 Controller
 */
@RestController
public class GetMyGhouseListController {
    @Autowired
    GetMyGhouseListService service;

    @GetMapping(value = "getMyGhouseList")
    public String getMyGhouseList(HttpServletRequest request) {
        String result = "";
        try {
            List<Hothouse> list = service.getMyGhouseList(JWTUtil.getPlaintextMap(request).get("account").toString());
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
