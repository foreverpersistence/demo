package com.learning.fred.design.project.com.xzg.ratelimite.rule.datasource;

import com.learning.fred.design.project.com.xzg.ratelimite.rule.RuleConfig;

/**
 * @author fred
 * @date 2021/1/22 16:40
 * @description  数据来源
 */
public interface RuleConfigSource {
    RuleConfig load();
}
