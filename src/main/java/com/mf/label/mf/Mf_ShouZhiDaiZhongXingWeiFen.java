package com.mf.label.mf;

import com.mf.label.Label;
import com.mf.util.DateUtil;
import com.mf.util.PmmlUtil;
import org.jpmml.evaluator.Evaluator;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.InputStream;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

@Component
public class Mf_ShouZhiDaiZhongXingWeiFen extends Label {

    @Override
    public String getLabelId() {
        return "LV1B1004";
    }

    @Override
    protected Evaluator loadPmmlFile() throws Exception {
        InputStream is = Mf_ShouZhiDaiZhongXingWeiFen.class.getResourceAsStream("/other/xgboost_pipeline_20210130_222944_new.pmml");
        Evaluator evaluator = PmmlUtil.getEvaluator(is);
//        File file = new File(System.getProperty("user.dir") + "/target/classes/other/xgboost_pipeline_20210130_222944_new.pmml");
//        if (file.delete()){
//            System.out.println("delete success!");
//        }
        return evaluator;
    }

    @Override
    protected Map<String, String> doSetBasicVariables() {
        Map<String, String> basicVariables = new HashMap<>();
        basicVariables.put("Pro06152", "unknown");
        basicVariables.put("Pro06178", "unknown");
        basicVariables.put("Pro06173", "unknown");
        basicVariables.put("Pro06174", "unknown");
        basicVariables.put("Pro06035", "unknown");
        basicVariables.put("Pro06037", "unknown");
        basicVariables.put("Pro06099", "unknown");
        basicVariables.put("Pro06065", "unknown");
        basicVariables.put("Pro06236", "unknown");
        basicVariables.put("Pro06235", "unknown");
        basicVariables.put("Pro05569", "unknown");
        basicVariables.put("Pro05343", "unknown");
        basicVariables.put("Pro05318", "unknown");
        basicVariables.put("Pro05315", "unknown");
        basicVariables.put("Pro04890", "unknown");
        basicVariables.put("Pro04994", "unknown");
        basicVariables.put("Pro05070", "unknown");
        basicVariables.put("Pro05282", "unknown");
        basicVariables.put("Pro05665", "unknown");
        basicVariables.put("Pro05636", "unknown");
        basicVariables.put("Pro05512", "unknown");
        basicVariables.put("Pro05516", "unknown");
        basicVariables.put("Pro05463", "unknown");
        basicVariables.put("Pro05776", "unknown");
        basicVariables.put("Pro05401", "unknown");
        basicVariables.put("Pro05711", "unknown");
        basicVariables.put("Pro05556", "unknown");
        basicVariables.put("Pro05603", "unknown");
        basicVariables.put("Pro05631", "unknown");
        basicVariables.put("Pro05380", "unknown");
        basicVariables.put("Pro06197", "unknown");
        basicVariables.put("Pro06198", "unknown");
        basicVariables.put("Pro06344", "unknown");
        basicVariables.put("Pro03347", "unknown");
        basicVariables.put("Pro03340", "unknown");
        basicVariables.put("Pro02690", "unknown");
        basicVariables.put("Pro02798", "unknown");
        basicVariables.put("Pro02653", "unknown");
        basicVariables.put("Pro02672", "unknown");
        basicVariables.put("Pro02461", "unknown");
        basicVariables.put("Pro02528", "unknown");
        basicVariables.put("Pro02394", "unknown");
        basicVariables.put("Pro02448", "unknown");
        basicVariables.put("Pro02478", "unknown");
        basicVariables.put("Pro02192", "unknown");
        basicVariables.put("Pro02201", "unknown");
        basicVariables.put("Pro03274", "unknown");
        basicVariables.put("Pro03140", "unknown");
        basicVariables.put("Pro03334", "unknown");
        basicVariables.put("Pro03164", "unknown");
        basicVariables.put("Pro03239", "unknown");
        basicVariables.put("Pro03210", "unknown");
        basicVariables.put("Pro04684", "unknown");
        basicVariables.put("Pro04846", "unknown");
        basicVariables.put("Pro04795", "unknown");
        basicVariables.put("Pro04865", "unknown");
        basicVariables.put("Pro04587", "unknown");
        basicVariables.put("Pro04825", "unknown");
        basicVariables.put("Pro04583", "unknown");
        basicVariables.put("Pro02869", "unknown");
        basicVariables.put("Pro02900", "unknown");
        basicVariables.put("Pro02901", "unknown");
        basicVariables.put("Pro02844", "unknown");
        basicVariables.put("Pro02830", "unknown");
        basicVariables.put("Pro02896", "unknown");
        basicVariables.put("Pro02874", "unknown");
        basicVariables.put("Pro04402", "unknown");
        basicVariables.put("Pro04331", "unknown");
        basicVariables.put("Pro04307", "unknown");
        basicVariables.put("Pro04469", "unknown");
        basicVariables.put("Pro02180", "unknown");
        basicVariables.put("Pro04080", "unknown");
        basicVariables.put("Pro04194", "unknown");
        basicVariables.put("Pro04284", "unknown");
        basicVariables.put("Pro04181", "unknown");
        basicVariables.put("Pro04055", "unknown");
        basicVariables.put("Pro04165", "unknown");
        basicVariables.put("Pro04099", "unknown");
        basicVariables.put("Pro04088", "unknown");
        basicVariables.put("Pro04108", "unknown");
        basicVariables.put("Pro02043", "unknown");
        basicVariables.put("Pro02167", "unknown");
        basicVariables.put("Pro02169", "unknown");
        basicVariables.put("Pro04009", "unknown");
        basicVariables.put("Pro03811", "unknown");
        basicVariables.put("Pro03840", "unknown");
        basicVariables.put("Pro03773", "unknown");
        basicVariables.put("Pro02033", "unknown");
        basicVariables.put("Pro03414", "unknown");
        basicVariables.put("Pro03663", "unknown");
        basicVariables.put("Pro03665", "unknown");
        basicVariables.put("Pro03664", "unknown");
        basicVariables.put("Pro03627", "unknown");
        basicVariables.put("Pro03451", "unknown");
        basicVariables.put("Pro03652", "unknown");
        basicVariables.put("Pro03603", "unknown");
        basicVariables.put("Pro03651", "unknown");
        basicVariables.put("Pro03438", "unknown");
        return basicVariables;
    }


    @Override
    protected void doFixBasicVariables(Map<String, String> basicVariables) {
        // 标签值为unknown的填充为-9999
        for (Map.Entry<String, String> entry : basicVariables.entrySet()) {
            if ("unknown".equals(entry.getValue())) {
                entry.setValue("-9999");
            }
        }
        basicVariables.put("Pro06152_1", basicVariables.get("Pro06152"));
        basicVariables.put("Pro06178_1", basicVariables.get("Pro06178"));
        basicVariables.put("Pro06173_1", basicVariables.get("Pro06173"));
        basicVariables.put("Pro06174_1", basicVariables.get("Pro06174"));
        basicVariables.put("Pro06035_1", basicVariables.get("Pro06035"));
        basicVariables.put("Pro06037_1", basicVariables.get("Pro06037"));
        basicVariables.put("Pro06099_1", basicVariables.get("Pro06099"));
        basicVariables.put("Pro06065_1", basicVariables.get("Pro06065"));
        basicVariables.put("Pro06236_1", basicVariables.get("Pro06236"));
        basicVariables.put("Pro06235_1", basicVariables.get("Pro06235"));
        basicVariables.put("Pro06197_1_dif", calculateDateVariable(basicVariables.get("Pro06197")));
        basicVariables.put("Pro06198_1_dif", calculateDateVariable(basicVariables.get("Pro06198")));
        basicVariables.put("Pro06344_1", basicVariables.get("Pro06344"));
    }

    @Override
    protected String doCalculateLabelValue(Map<String, String> basicVariables) {
        double p1 = Double.parseDouble(PmmlUtil.getPmmlResult(evaluator, basicVariables));
        double labelValue = Math.round(-20 * Math.log(1 - p1));
        if (labelValue > 100) {
            labelValue = 100;
        }
        if (labelValue < 0) {
            labelValue = 0;
        }
        return labelValue + "";
    }

    private String calculateDateVariable(String variableValue) {
        if ("-9999".equals(variableValue)) {
            return variableValue;
        }
        try {
            int year = DateUtil.getYearBy_yyyyMM(variableValue);
            int month = DateUtil.getMonthBy_yyyyMM(variableValue);
            return (DateUtil.getNowYear() - year) * 12 + (DateUtil.getNowMonth() - month) + "";
        } catch (ParseException e) {
            e.printStackTrace();
            return "-9999";
        }
    }

}
