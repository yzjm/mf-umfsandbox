package com.mf.label;

import com.mf.service.LabelService;
import com.mf.service.LogService;
import com.mf.util.Assert;
import org.jpmml.evaluator.Evaluator;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class Label {
    @Autowired
    private LabelService labelService;

    // pmml计算器
    protected Evaluator evaluator;

    // 由于pmml文件加载过慢，需要提前加载
    {
        try {
            this.evaluator = loadPmmlFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 注册进标签管理器
    @PostConstruct
    public void registerLabelManager() {
        labelService.register(this);
    }

    // 设置标签id
    abstract public String getLabelId();

    // 加载pmml文件
    abstract protected Evaluator loadPmmlFile() throws Exception;

    /**
     * 设置入模基础变量值
     *
     * @param realBasicVariables 外部请求传进来的入模基础变量值
     */
    private Map<String, String> setBasicVariables(Map<String, String> realBasicVariables) {
        // 将该标签需要用到的所有基础标签值（入模基础变量）存入basicVariables
        List<String> basicVariablesList = getBasicVariablesList();
        // 将传进来的入模基础变量有值设置值，无值的填充unknown
        Map<String, String> basicVariables = preHandleBasicVariables(basicVariablesList, realBasicVariables);
        return basicVariables;
    }

    // 预处理入模变量：将传进来的入模基础变量有值设置值，无值的填充unknown
    private Map<String, String> preHandleBasicVariables(List<String> basicVariablesList, Map<String, String> realBasicVariables) {
        Map<String, String> basicVariables = new HashMap<>(128);
        for (String basicVariableId : basicVariablesList) {
            basicVariables.put(basicVariableId, realBasicVariables.getOrDefault(basicVariableId, "unknown"));
        }
        return basicVariables;
    }

    // 获取需要的所有入模变量
    abstract protected List<String> getBasicVariablesList();

    private void fixBasicVariables(Map<String, String> basicVariables) throws Exception {
        doFixBasicVariables(basicVariables);
    }

    // 可能需要添加中间变量
    abstract protected void doFixBasicVariables(Map<String, String> basicVariables) throws Exception;

    // 计算标签值
    public String calculateLabelValue(Map<String, String> realBasicVariables) throws Exception {
        Map<String, String> basicVariables = setBasicVariables(realBasicVariables);
        if (validateBasicVariables(basicVariables)) {
            fixBasicVariables(basicVariables);
            return handleTypeOfLabelValue(doCalculateLabelValue(basicVariables));
        }
        return "unknown";
    }

    // 真实计算标签值逻辑
    abstract protected String doCalculateLabelValue(Map<String, String> basicVariables);

    private String handleTypeOfLabelValue(String labelValue) {
        Assert.notBlank(labelValue, "未计算出标签值");
        if (labelValue.contains(".")) {
            labelValue = (int) Double.parseDouble(labelValue) + "";
        } else {
            labelValue = (int) Long.parseLong(labelValue) + "";
        }
        return labelValue;
    }

    // 如果所有入模参数均为unknown，则不入模计算，直接返回unknown
    private boolean validateBasicVariables(Map<String, String> basicVariables) {
        for (Map.Entry<String, String> entry : basicVariables.entrySet()) {
            if ("queryDate".equals(entry.getKey())) {
                continue;
            }
            if (!"unknown".equals(entry.getValue())) {
                return true;
            }
        }
        return false;
    }
}
