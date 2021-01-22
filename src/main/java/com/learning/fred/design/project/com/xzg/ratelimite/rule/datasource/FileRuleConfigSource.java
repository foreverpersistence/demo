package com.learning.fred.design.project.com.xzg.ratelimite.rule.datasource;

import com.learning.fred.design.project.com.xzg.ratelimite.rule.RuleConfig;
import com.learning.fred.design.project.com.xzg.ratelimite.rule.parser.JsonRuleConfigParser;
import com.learning.fred.design.project.com.xzg.ratelimite.rule.parser.RuleConfigParser;
import com.learning.fred.design.project.com.xzg.ratelimite.rule.parser.YamlRuleConfigParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @author fred
 * @date 2021/1/22 16:40
 * @description 基于本地文件的配置类, 基于类型进行解析
 */
public class FileRuleConfigSource implements RuleConfigSource {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileRuleConfigSource.class);

    public static final String API_LIMIT_CONFIG_NAME = "ratelimiter-rule";
    public static final String YAML_EXTENSION = "yaml";
    public static final String YML_EXTENSION = "yml";
    public static final String JSON_EXTENSION = "json";

    private static final String[] SUPPORT_EXTENSIONS =
            new String[] {YAML_EXTENSION, YML_EXTENSION, JSON_EXTENSION};
    private static final Map<String, RuleConfigParser> PARSER_MAP = new HashMap<>();
    static {
        PARSER_MAP.put(YAML_EXTENSION, new YamlRuleConfigParser());
        PARSER_MAP.put(YML_EXTENSION, new YamlRuleConfigParser());
        PARSER_MAP.put(JSON_EXTENSION, new JsonRuleConfigParser());
    }

    @Override
    public RuleConfig load() {

        for (String extension : SUPPORT_EXTENSIONS) {
            InputStream in = null;
            try {
                //classpath  /
                in = this.getClass().getResourceAsStream("/" + getFileNameByExt(extension));

                if (in != null) {
                    RuleConfigParser ruleConfigParser = PARSER_MAP.get(extension);
                    return ruleConfigParser.parse(in);
                }
            } catch (Exception e) {

            } finally {

            }
        }

        return null;
    }

    /**
     * 指定的 路径
     * @param extension
     * @return
     */
    private String getFileNameByExt(String extension) {

        return API_LIMIT_CONFIG_NAME + "." + extension;
    }
}
