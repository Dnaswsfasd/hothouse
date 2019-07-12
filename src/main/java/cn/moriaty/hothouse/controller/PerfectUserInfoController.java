package cn.moriaty.hothouse.controller;

import cn.moriaty.hothouse.service.PerfectUserInfoService;
import cn.moriaty.hothouse.utils.AllConstant;
import cn.moriaty.hothouse.utils.HttpUtil;
import cn.moriaty.hothouse.utils.JWTUtil;
import cn.moriaty.hothouse.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * @author 16计算机 Moriaty
 * @version 1.0
 * @copyright ：Moriaty 版权所有 © 2019
 * @date 2019/6/18 22:07
 * @Description TODO
 * 完善个人信息接口 Controller
 */
@RestController
public class PerfectUserInfoController {

    @Autowired
    PerfectUserInfoService service;

    @PostMapping(value = "perfectUserInfo")
    public String perfectUserInfo(HttpServletRequest request) {
        String result = "";
        try {
            HashMap<String, String> params = JsonUtil.getRequestParams(request);
            result = HttpUtil.checkParams(params, new String[]{"name", "sex", "phone", "mailbox"});
            if (!"".equals(result.trim())) {
                return result;
            }
            Integer is = service.perfectUserInfo(JWTUtil.getPlaintextMap(request).get("account").toString(), params.get("name"), Integer.parseInt(params.get("sex")), params.get("phone"), params.get("mailbox"));
            if (is > 0) {
                result = JsonUtil.jsonResponse(null, AllConstant.CODE_SUCCESS, "完善成功");
            } else {
                result = JsonUtil.jsonResponse(null, AllConstant.CODE_ERROR, "完善失败");
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            result = JsonUtil.jsonResponse(null, AllConstant.CODE_ERROR, "参数类型错误");
        } catch (Exception e) {
            e.printStackTrace();
            result = JsonUtil.jsonResponse(null, AllConstant.CODE_ERROR, AllConstant.MSG_ERROR);
        }
        return result;
    }
}
