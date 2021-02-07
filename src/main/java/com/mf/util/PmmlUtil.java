package com.mf.util;

import org.dmg.pmml.FieldName;
import org.dmg.pmml.PMML;
import org.jpmml.evaluator.Evaluator;
import org.jpmml.evaluator.ModelEvaluatorFactory;
import org.jpmml.evaluator.OutputField;
import org.jpmml.model.PMMLUtil;

import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PmmlUtil {
	/**
	 * 加载pmml文件
	 * 注:由于加载时间过长,建议程序启动时加载
	 * @param pmmlFileInputStream
	 * @return
	 * @throws Exception
	 */
	public static Evaluator getEvaluator(InputStream pmmlFileInputStream) throws Exception {
        PMML pmml = PMMLUtil.unmarshal(pmmlFileInputStream);
        ModelEvaluatorFactory modelEvaluatorFactory = ModelEvaluatorFactory.newInstance();
        Evaluator evaluator = modelEvaluatorFactory.newModelEvaluator(pmml);
        return evaluator;
    }
	/**
	 * 根据已加载的pmml文件,传入Map参数,获取最终返回结果
	 * @param evaluator
	 * @param inputPmmlMap
	 * @return
	 */
	public static String getPmmlResult(Evaluator evaluator, Map<String,String> inputPmmlMap){
		Map paramMap = new ConcurrentHashMap();
		for(String key : inputPmmlMap.keySet()){
			paramMap.put(FieldName.create(key), inputPmmlMap.get(key));
		}
		Map<FieldName, ?> resultMap = evaluator.evaluate(paramMap);
		List<OutputField> outputList = evaluator.getOutputFields();
		return resultMap.get(outputList.get(0).getName()).toString();
	}
}
