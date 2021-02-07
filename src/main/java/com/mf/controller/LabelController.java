package com.mf.controller;

import com.mf.common.CommonResponse;
import com.mf.service.LabelService;
import com.mf.service.LogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class LabelController {
    @Autowired
    private LabelService labelService;
    @Autowired
    private LogService logService;

    @PostMapping("/label")
    public CommonResponse labelDispatch(@RequestBody Map<String, String> basicVariables) {
        String labelId = basicVariables.get("labelId");
        logService.printLog("接收到请求[labelId:" + labelId + ",basicVariables:" + basicVariables + "]");
        String labelValue = labelService.getLabelValue(basicVariables, labelId);
        logService.printLog("响应标签结果:" + labelValue + "[labelId:" + labelId + ",basicVariables:" + basicVariables + "]");
        if (labelValue == null || "unknown".equals(labelValue)) {
            return CommonResponse.NO_FOUND;
        }
        return new CommonResponse("0000", null, labelId, labelValue);
    }
}
