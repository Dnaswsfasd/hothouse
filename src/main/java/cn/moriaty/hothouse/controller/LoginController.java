package cn.moriaty.hothouse.controller;

import cn.moriaty.hothouse.service.LoginService;
import cn.moriaty.hothouse.utils.AllConstant;
import cn.moriaty.hothouse.utils.HttpUtil;
import cn.moriaty.hothouse.utils.JWTUtil;
import cn.moriaty.hothouse.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Set;

@RestController
public class LoginController {

    @Autowired
    private LoginService service;

    @PostMapping(value = "login")
    public String login(HttpServletRequest request, HttpServletResponse response) {
        String result = "";
        try {
            HashMap<String, String> params = JsonUtil.getRequestParams(request);
            result = HttpUtil.checkParams(params, new String[]{"account", "pwd"});
            if (!"".equals(result.trim())) {
                return result;
            }
            boolean is = service.getUser(params.get("account"), params.get("pwd"));
            if (is) {
                result = JsonUtil.jsonResponse(null, AllConstant.CODE_SUCCESS, "登陆成功");
                // 构建明文Json
                HashMap<String, Object> plaintextMap = new HashMap<String, Object>();//返回结果
                plaintextMap.put("account", params.get("account"));
                // 将明文公钥加密存储，以及明文存储到 Cookie 中
                response = JWTUtil.plaintextEncrypt(response, JWTUtil.plaintextBase64Encrypt(plaintextMap));
            } else {
                result = JsonUtil.jsonResponse(null, AllConstant.CODE_ERROR, "用户名密码错误");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = JsonUtil.jsonResponse(null, AllConstant.CODE_ERROR, AllConstant.MSG_ERROR);
        }

        return result;
    }

    @GetMapping(value = "test")
    public String test(HttpServletRequest request) {
        HashMap<String, Object> tokenMap = JWTUtil.getPlaintextMap(request);
        Set<String> keySet = tokenMap.keySet();
        for (String key : keySet) {
            System.out.println(key);
            System.out.println(tokenMap.get(key));
        }
        return "";
    }
}
