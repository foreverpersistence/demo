package com.learning.fred.design.principle.pattern.factory.parser;

import com.learning.fred.design.principle.pattern.factory.RuleConfig;

public interface RuleConfigParser {

    RuleConfig parse(String content);
}
