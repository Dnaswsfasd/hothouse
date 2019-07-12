package cn.moriaty.hothouse.controller;

import cn.moriaty.hothouse.utils.AllConstant;
import cn.moriaty.hothouse.utils.JWTUtil;
import cn.moriaty.hothouse.utils.JsonUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @copyright ：Moriaty 版权所有 © 2019
 * @author 16计算机 Moriaty
 * @version 1.0
 * @date 2019/6/18 21:06
 * @Description TODO
 *   注销接口 Controller
 */
@RestController
public class LogoutController {

    @GetMapping(value = "logout")
    public String logout(HttpServletRequest request, HttpServletResponse response){
        response = JWTUtil.removeCookies(request,response);
        return JsonUtil.jsonResponse(null, AllConstant.CODE_SUCCESS, "注销成功");
    }
}
