package com.learning.fred.design.project.com.xzg.ratelimite.rule;

/**
 * @author fred
 * @date 2021/1/21 14:00
 * @description todo
 */
public class RateLimitRule {

    private RuleConfig ruleConfig;

    public RateLimitRule(RuleConfig ruleConfig) {
        this.ruleConfig = ruleConfig;
    }

    public ApiLimit getLimit(String appId, String api) {
        //
        return null;
    }
}
