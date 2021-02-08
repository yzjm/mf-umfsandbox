package com.mf.service;

import com.mf.label.Label;
import com.mf.util.Assert;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LabelService {

    /**
     * 标签管理器，用于存储开发的标签
     */
    private Map<String, Label> labelManager = new HashMap<>();

    public String getLabelValue(Map<String, String> basicVariables, String labelId) throws Exception {
        Label targetLabel = labelManager.get(labelId);
        Assert.notNull(targetLabel, "未传或传入的标签值有误");
        return targetLabel.calculateLabelValue(basicVariables);
    }

    public void register(Label label) {
        labelManager.put(label.getLabelId(), label);
    }
}
