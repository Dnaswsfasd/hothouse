package cn.moriaty.hothouse.controller;

import cn.moriaty.hothouse.bean.User;
import cn.moriaty.hothouse.service.GetUserInfoService;
import cn.moriaty.hothouse.utils.AllConstant;
import cn.moriaty.hothouse.utils.JWTUtil;
import cn.moriaty.hothouse.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 16计算机 Moriaty
 * @version 1.0
 * @copyright ：Moriaty 版权所有 © 2019
 * @date 2019/6/18 22:21
 * @Description TODO
 * 获取个人信息接口 Controller
 */
@RestController
public class GetUserInfoController {

    @Autowired
    GetUserInfoService service;

    @GetMapping(value = "getUserInfo")
    public String getUserInfo(HttpServletRequest request) {
        String result = "";
        try {
            User user = service.getUserInfo(JWTUtil.getPlaintextMap(request).get("account").toString());
            if (user != null) {
                result = JsonUtil.jsonResponse(user, AllConstant.CODE_SUCCESS, "获取成功");
            } else {
                result = JsonUtil.jsonResponse(null, AllConstant.CODE_ERROR, "获取失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = JsonUtil.jsonResponse(null, AllConstant.CODE_ERROR, AllConstant.MSG_ERROR);
        }
        return result;
    }
}
