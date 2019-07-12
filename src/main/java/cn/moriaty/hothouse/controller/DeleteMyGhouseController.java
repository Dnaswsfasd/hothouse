package cn.moriaty.hothouse.controller;

import cn.moriaty.hothouse.service.DeleteMyGhouseService;
import cn.moriaty.hothouse.utils.AllConstant;
import cn.moriaty.hothouse.utils.HttpUtil;
import cn.moriaty.hothouse.utils.JWTUtil;
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
 * @date 2019/6/19 21:57
 * @Description TODO
 * 删除我的温室 Controller
 */
@RestController
public class DeleteMyGhouseController {

    @Autowired
    DeleteMyGhouseService service;

    @GetMapping(value = "deleteMyGhouse")
    public String deleteGhouse(HttpServletRequest request) {
        String result = "";
        try {
            HashMap<String, String> params = JsonUtil.getRequestParams(request);
            result = HttpUtil.checkParams(params, new String[]{"ID"});
            if (!"".equals(result.trim())) {
                return result;
            }
            Integer is = service.deleteGhouse(JWTUtil.getPlaintextMap(request).get("account").toString(), params.get("ID"));
            if (is > 0) {
                result = JsonUtil.jsonResponse(null, AllConstant.CODE_SUCCESS, "删除成功");
            } else {
                result = JsonUtil.jsonResponse(null, AllConstant.CODE_ERROR, "删除失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = JsonUtil.jsonResponse(null, AllConstant.CODE_ERROR, AllConstant.MSG_ERROR);
        }
        return result;
    }
}
