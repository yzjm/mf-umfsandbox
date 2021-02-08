package com.mf.label.mf;

import com.mf.label.Label;
import com.mf.util.DateUtil;
import com.mf.util.PmmlUtil;
import org.jpmml.evaluator.Evaluator;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    protected List<String> getBasicVariablesList() {
        List<String> basicVariables = new ArrayList<>(99);
        // 申请日期，yyyyMMdd
        basicVariables.add("queryDate");
        basicVariables.add("Pro06152");
        basicVariables.add("Pro06178");
        basicVariables.add("Pro06173");
        basicVariables.add("Pro06174");
        basicVariables.add("Pro06035");
        basicVariables.add("Pro06037");
        basicVariables.add("Pro06099");
        basicVariables.add("Pro06065");
        basicVariables.add("Pro06236");
        basicVariables.add("Pro06235");
        basicVariables.add("Pro05569");
        basicVariables.add("Pro05343");
        basicVariables.add("Pro05318");
        basicVariables.add("Pro05315");
        basicVariables.add("Pro04890");
        basicVariables.add("Pro04994");
        basicVariables.add("Pro05070");
        basicVariables.add("Pro05282");
        basicVariables.add("Pro05665");
        basicVariables.add("Pro05636");
        basicVariables.add("Pro05512");
        basicVariables.add("Pro05516");
        basicVariables.add("Pro05463");
        basicVariables.add("Pro05776");
        basicVariables.add("Pro05401");
        basicVariables.add("Pro05711");
        basicVariables.add("Pro05556");
        basicVariables.add("Pro05603");
        basicVariables.add("Pro05631");
        basicVariables.add("Pro05380");
        basicVariables.add("Pro06197");
        basicVariables.add("Pro06198");
        basicVariables.add("Pro06344");
        basicVariables.add("Pro03347");
        basicVariables.add("Pro03340");
        basicVariables.add("Pro02690");
        basicVariables.add("Pro02798");
        basicVariables.add("Pro02653");
        basicVariables.add("Pro02672");
        basicVariables.add("Pro02461");
        basicVariables.add("Pro02528");
        basicVariables.add("Pro02394");
        basicVariables.add("Pro02448");
        basicVariables.add("Pro02478");
        basicVariables.add("Pro02192");
        basicVariables.add("Pro02201");
        basicVariables.add("Pro03274");
        basicVariables.add("Pro03140");
        basicVariables.add("Pro03334");
        basicVariables.add("Pro03164");
        basicVariables.add("Pro03239");
        basicVariables.add("Pro03210");
        basicVariables.add("Pro04684");
        basicVariables.add("Pro04846");
        basicVariables.add("Pro04795");
        basicVariables.add("Pro04865");
        basicVariables.add("Pro04587");
        basicVariables.add("Pro04825");
        basicVariables.add("Pro04583");
        basicVariables.add("Pro02869");
        basicVariables.add("Pro02900");
        basicVariables.add("Pro02901");
        basicVariables.add("Pro02844");
        basicVariables.add("Pro02830");
        basicVariables.add("Pro02896");
        basicVariables.add("Pro02874");
        basicVariables.add("Pro04402");
        basicVariables.add("Pro04331");
        basicVariables.add("Pro04307");
        basicVariables.add("Pro04469");
        basicVariables.add("Pro02180");
        basicVariables.add("Pro04080");
        basicVariables.add("Pro04194");
        basicVariables.add("Pro04284");
        basicVariables.add("Pro04181");
        basicVariables.add("Pro04055");
        basicVariables.add("Pro04165");
        basicVariables.add("Pro04099");
        basicVariables.add("Pro04088");
        basicVariables.add("Pro04108");
        basicVariables.add("Pro02043");
        basicVariables.add("Pro02167");
        basicVariables.add("Pro02169");
        basicVariables.add("Pro04009");
        basicVariables.add("Pro03811");
        basicVariables.add("Pro03840");
        basicVariables.add("Pro03773");
        basicVariables.add("Pro02033");
        basicVariables.add("Pro03414");
        basicVariables.add("Pro03663");
        basicVariables.add("Pro03665");
        basicVariables.add("Pro03664");
        basicVariables.add("Pro03627");
        basicVariables.add("Pro03451");
        basicVariables.add("Pro03652");
        basicVariables.add("Pro03603");
        basicVariables.add("Pro03651");
        basicVariables.add("Pro03438");
        return basicVariables;
    }


    @Override
    protected void doFixBasicVariables(Map<String, String> basicVariables) throws Exception {
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
        basicVariables.put("Pro06197_1_dif", calculateDateVariable(basicVariables.get("Pro06197"), basicVariables.get("queryDate")));
        basicVariables.put("Pro06198_1_dif", calculateDateVariable(basicVariables.get("Pro06198"), basicVariables.get("queryDate")));
        basicVariables.put("Pro06344_1", basicVariables.get("Pro06344"));
    }

    @Override
    protected String doCalculateLabelValue(Map<String, String> basicVariables) {
        System.out.println(basicVariables);
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

    private String calculateDateVariable(String variableValue, String queryDate) throws ParseException {
        String value = "-9999";
        if (!"-9999".equals(variableValue)) {
            int queryYear = DateUtil.getNowYear();
            int queryMonth = DateUtil.getNowMonth();
            if (!"-9999".equals(queryDate)) {
                queryYear = DateUtil.getYearBy_yyyyMMdd(queryDate);
                queryMonth = DateUtil.getMonthBy_yyyyMMdd(queryDate);
            }
            int year = DateUtil.getYearBy_yyyyMM(variableValue);
            int month = DateUtil.getMonthBy_yyyyMM(variableValue);
            value = (queryYear - year) * 12 + (queryMonth - month) + "";
        }
        return value;
    }

}
