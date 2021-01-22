package com.learning.fred.design.project.com.xzg.ratelimite;

import com.learning.fred.design.project.com.xzg.ratelimite.alg.InternalErrorException;
import com.learning.fred.design.project.com.xzg.ratelimite.alg.RateLimitAlg;
import com.learning.fred.design.project.com.xzg.ratelimite.rule.ApiLimit;
import com.learning.fred.design.project.com.xzg.ratelimite.rule.RateLimitRule;
import com.learning.fred.design.project.com.xzg.ratelimite.rule.RuleConfig;
import com.learning.fred.design.project.com.xzg.ratelimite.rule.datasource.FileRuleConfigSource;
import com.learning.fred.design.project.com.xzg.ratelimite.rule.datasource.RuleConfigSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author fred
 * @date 2021/1/21 13:57
 * @description   集成组装
 */
public class RateLimiter {

    private static final Logger LOGGER = LoggerFactory.getLogger(RateLimiter.class);

    private ConcurrentHashMap<String, RateLimitAlg> counters = new ConcurrentHashMap<String, RateLimitAlg>();

    private RateLimitRule rule;

    public RateLimiter() {
// 将限流规则配置文件ratelimiter-rule.yaml中的内容读取到RuleConfig中
//        InputStream in = null;
//        RuleConfig ruleConfig = null;
//        try {
//            in = this.getClass().getResourceAsStream("/ratelimiter-rule.yaml"); if (in != null) {
//                Yaml yaml = new Yaml();
//                ruleConfig = yaml.loadAs(in, RuleConfig.class); }
//        } finally {
//            if (in != null) {
//                try { in.close();
//                } catch (IOException e) {
//                    LOGGER.error("close file error:{}", e);
//                }
//            }
//        }

        //改动主要在这里:调用RuleConfigSource类来实现配置加载
        RuleConfigSource configSource = new FileRuleConfigSource();
        RuleConfig ruleConfig = configSource.load();
//        this.rule = new TrieRateLimitRule(ruleConfig);
// 将限流规则构建成支持快速查找的数据结构RateLimitRule
        this.rule = new RateLimitRule(ruleConfig);
    }

    public boolean limit(String appId, String url) throws InternalErrorException {
        ApiLimit apiLimit = rule.getLimit(appId, url);
        if (apiLimit == null) {
            return true;
        }
        // 获取api对应在内存中的限流计数器(rateLimitCounter)
        String counterKey = appId + ":" + apiLimit.getApi();
        RateLimitAlg rateLimitCounter = counters.get(counterKey);
        if (rateLimitCounter == null) {
            RateLimitAlg newRateLimitCounter = new RateLimitAlg(apiLimit.getLimit());
            rateLimitCounter = counters.putIfAbsent(counterKey, newRateLimitCounter);
            if (rateLimitCounter == null) {
                rateLimitCounter = newRateLimitCounter;
            }
        }
        // 判断是否限流
        return rateLimitCounter.tryAcquire(); }
}
