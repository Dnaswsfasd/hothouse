package cn.moriaty.hothouse.controller;

import cn.moriaty.hothouse.service.ImportDataService;
import cn.moriaty.hothouse.utils.AllConstant;
import cn.moriaty.hothouse.utils.HttpUtil;
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
 * @date 2019/6/19 22:33
 * @Description TODO
 * 导入数据接口 Controller
 */
@RestController
public class ImportDataController {
    @Autowired
    ImportDataService service;

    @PostMapping(value = "importData")
    public String importData(HttpServletRequest request) {
        String result = "";
        try {
            HashMap<String, String> params = JsonUtil.getRequestParams(request);
            result = HttpUtil.checkParams(params, new String[]{"ID", "temperature", "CO2", "humidity", "soil", "light"});
            if (!"".equals(result.trim())) {
                return result;
            }
            Integer is = service.importData(params.get("ID"), params.get("temperature"), params.get("CO2"), params.get("humidity"), params.get("soil"), params.get("light"));
            if (is > 0) {
                result = JsonUtil.jsonResponse(null, AllConstant.CODE_SUCCESS, "导入成功");
            } else {
                result = JsonUtil.jsonResponse(null, AllConstant.CODE_ERROR, "导入失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = JsonUtil.jsonResponse(null, AllConstant.CODE_ERROR, AllConstant.MSG_ERROR);
        }
        return result;
    }
}
