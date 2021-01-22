package com.learning.fred.design.project.com.xzg.ratelimite.rule.parser;

import com.learning.fred.design.project.com.xzg.ratelimite.rule.RuleConfig;

import java.io.InputStream;

/**
 * @author fred
 * @date 2021/1/22 16:44
 * @description 抽象接口
 */
public interface RuleConfigParser {

    RuleConfig parse(String configText);
    RuleConfig parse(InputStream in);
}
