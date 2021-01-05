package com.learning.fred.design.principle.pattern.factory;

import com.learning.fred.design.principle.pattern.factory.parser.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fred
 * @date 2020/12/16 19:17
 * @description 简单工厂
 */
public class RuleConfigParserFactory {

    private static final Map<String, RuleConfigParser> cachedParsers = new HashMap<>();

    static {
        cachedParsers.put("json", new JsonRuleConfigParser());
        cachedParsers.put("xml", new XmlRuleConfigParser());
        cachedParsers.put("yaml", new YamlRuleConfigParser());
        cachedParsers.put("properties", new PropertiesRuleConfigParser());
    }

    public static RuleConfigParser createParser(String configFormat) {
        if (configFormat == null || configFormat.isEmpty()) {
            return null;//返回null还是IllegalArgumentException全凭你自己说了算 }
        }

        RuleConfigParser parser = cachedParsers.get(configFormat.toLowerCase());
        return parser;

    }


    // 根据 后缀 创建

}
