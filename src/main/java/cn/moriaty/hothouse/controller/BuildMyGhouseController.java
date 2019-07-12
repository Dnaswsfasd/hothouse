package cn.moriaty.hothouse.controller;

import cn.moriaty.hothouse.service.BuildMyGhouseService;
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
 * @date 2019/6/19 15:47
 * @Description TODO
 * 新建我的温室接口 Controller
 */
@RestController
public class BuildMyGhouseController {
    @Autowired
    BuildMyGhouseService service;

    @PostMapping(value = "buildMyGhouse")
    public String buildGhouse(HttpServletRequest request) {
        String result = "";
        try {
            HashMap<String, String> params = JsonUtil.getRequestParams(request);
            result = HttpUtil.checkParams(params, new String[]{"name", "desc"});
            if (!"".equals(result.trim())) {
                return result;
            }
            Integer is = service.buildGhouse(JWTUtil.getPlaintextMap(request).get("account").toString(), params.get("name"), params.get("desc"));
            if (is > 0) {
                result = JsonUtil.jsonResponse(null, AllConstant.CODE_SUCCESS, "新建成功");
            } else {
                result = JsonUtil.jsonResponse(null, AllConstant.CODE_ERROR, "新建失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = JsonUtil.jsonResponse(null, AllConstant.CODE_ERROR, AllConstant.MSG_ERROR);
        }
        return result;
    }
}
