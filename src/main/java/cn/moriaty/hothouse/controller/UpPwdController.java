package cn.moriaty.hothouse.controller;

import cn.moriaty.hothouse.service.UpPwdService;
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
 * @date 2019/6/19 15:34
 * @Description TODO
 * 修改密码接口 Controller
 */
@RestController
public class UpPwdController {
    @Autowired
    UpPwdService service;

    @PostMapping(value = "upPwd")
    public String upPwd(HttpServletRequest request) {
        String result = "";
        try {
            HashMap<String, String> params = JsonUtil.getRequestParams(request);
            result = HttpUtil.checkParams(params, new String[]{"oldPwd", "newPwd"});
            if (!"".equals(result.trim())) {
                return result;
            }
            Integer is = service.upPwd(JWTUtil.getPlaintextMap(request).get("account").toString(), params.get("oldPwd"), params.get("newPwd"));
            if (is > 0) {
                result = JsonUtil.jsonResponse(null, AllConstant.CODE_SUCCESS, "修改成功");
            } else {
                result = JsonUtil.jsonResponse(null, AllConstant.CODE_ERROR, "修改失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = JsonUtil.jsonResponse(null, AllConstant.CODE_ERROR, AllConstant.MSG_ERROR);
        }
        return result;
    }
}
