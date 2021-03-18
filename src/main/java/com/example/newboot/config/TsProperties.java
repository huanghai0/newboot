package com.example.newboot.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationContextFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

@Component
public class TsProperties {
    private Map<String, String> ruleMap = new HashMap<>();
    private final static Logger logger = LoggerFactory.getLogger(TsProperties.class);
    private static String filePath = "src/main/resources/ts.properties";

    @Value("${Test.a:123}")
    private String aValue;

    @Bean("getRuleMap")
    public Map<String, String> getMap() {
        return ruleMap.isEmpty() ? getMep() : ruleMap;
    }
    
    @Bean("bMap")
    public Map<String, String> getAMap() {
        Map<String, String> map = new HashMap<>();
        map.put("A", "1");
        return map;
    }

    public Map<String, String> getMep() {

        Properties properties = new Properties();
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(filePath);
            properties.load(fileReader);
            Set<String> sets = properties.stringPropertyNames();
            for (String str : sets) {
                ruleMap.put(str, properties.getProperty(str));
            }

            logger.info("读取成功！{}", aValue);
        } catch (IOException e) {
            logger.error("读取文件错误：{}", e);
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                logger.error("关闭文件流错误：{}", e);
            }
        }
        return ruleMap;
    }

}
