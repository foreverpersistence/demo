package com.learning.fred.design.principle.pattern.create.factory.parser;

import com.learning.fred.design.principle.pattern.create.factory.RuleConfig;

public interface RuleConfigParser {

    RuleConfig parse(String content);
}
