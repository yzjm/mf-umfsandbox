package com.mf.label;

import com.mf.service.LabelService;
import com.mf.service.LogService;
import com.mf.util.Assert;
import org.jpmml.evaluator.Evaluator;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

public abstract class Label {
    @Autowired
    private LabelService labelService;

    // pmml计算器
    protected Evaluator evaluator;
    // 入模基础变量
    private Map<String, String> basicVariables = new HashMap<>();

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
    private void setBasicVariables(Map<String, String> realBasicVariables) {
        // 将该标签需要用到的所有基础标签值（入模基础变量）存入basicVariables，填充为unknown
        basicVariables.putAll(doSetBasicVariables());
        // 将传进来的入模基础变量覆盖basicVariables，即如果入模基础变量有值则会覆盖初始化值unknown
        basicVariables.putAll(realBasicVariables);
    }

    // 设置实际需要的所有入模变量，它们的值均初始化为unknown
    abstract protected Map<String, String> doSetBasicVariables();

    private void fixBasicVariables() {
        doFixBasicVariables(basicVariables);
    }

    // 可能需要添加中间变量
    abstract protected void doFixBasicVariables(Map<String, String> basicVariables);

    // 计算标签值
    public String calculateLabelValue(Map<String, String> realBasicVariables) {
        setBasicVariables(realBasicVariables);
        if (validateBasicVariables()) {
            fixBasicVariables();
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
    private boolean validateBasicVariables() {
        for (Map.Entry<String, String> entry : basicVariables.entrySet()) {
            if (!"unknown".equals(entry.getValue())) {
                return true;
            }
        }
        return false;
    }
}
