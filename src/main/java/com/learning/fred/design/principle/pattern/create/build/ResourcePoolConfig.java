package com.learning.fred.design.principle.pattern.create.build;

import org.apache.commons.lang3.StringUtils;

/**
 * @author fred
 * @date 2020/12/18 16:44
 * @description todo
 */
public class ResourcePoolConfig {
        private static final int DEFAULT_MAX_TOTAL = 8;
        private static final int DEFAULT_MAX_IDLE = 8;
        private static final int DEFAULT_MIN_IDLE = 0;


        private String name;

        private int maxTotal = DEFAULT_MAX_TOTAL;
        private int maxIdle = DEFAULT_MAX_IDLE;
        private int minIdle = DEFAULT_MIN_IDLE;


    public ResourcePoolConfig(String name, Integer maxTotal, Integer maxIdle, Integer minIdle) {
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("name should not be empty.");
        }
        this.name = name;
        if (maxTotal != null) {
            if (maxTotal < 0) {
                throw new IllegalArgumentException("maxTotal should be positive.");
            }
            this.maxTotal = maxTotal;
        }
        if (maxIdle != null) {
            if (maxIdle < 0) {
                throw new IllegalArgumentException("maxIdle should be positive.");
            }
            this.maxIdle = maxIdle;
        }
        if (minIdle != null) {
            if (minIdle < 0) {
                throw new IllegalArgumentException("minIdle should be positive.");
            }
            this.minIdle = minIdle;
        }
    }

    public ResourcePoolConfig(String name) {
        //name 必填 放在 构造函数中
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("name should not be empty.");
        }
        this.name = name;
    }

    public void setMaxTotal(int maxTotal) {
        if (maxTotal < 0) {
            throw new IllegalArgumentException("maxTotal should be positive.");
        }
        this.maxTotal = maxTotal;
    }

    public void setMaxIdle(int maxIdle) {
        if (maxIdle < 0) {
            throw new IllegalArgumentException("maxIdle should be positive.");
        }
        this.maxIdle = maxIdle;
    }

    public void setMinIdle(int minIdle) {
        if (minIdle < 0) {
            throw new IllegalArgumentException("minIdle should be positive.");
        }
        this.minIdle = minIdle;
    }


    public ResourcePoolConfig(Builder builder) {

    }


    //建造者模式
    public static class Builder {

        private static final int DEFAULT_MAX_TOTAL = 8;
        private static final int DEFAULT_MAX_IDLE = 8;
        private static final int DEFAULT_MIN_IDLE = 0;
        private String name;

        private int maxTotal = DEFAULT_MAX_TOTAL;
        private int maxIdle = DEFAULT_MAX_IDLE;
        private int minIdle = DEFAULT_MIN_IDLE;

        public ResourcePoolConfig build() {

            // 校验逻辑放到这里来做，包括必填项校验、依赖关系校验、约束条件校验等
            if (StringUtils.isBlank(name)) {
                throw new IllegalArgumentException("name should not be empty.");
            }
            if (maxTotal < maxIdle) {
                throw new IllegalArgumentException("maxTotal < maxIdle.");
            }
            //...

            return new ResourcePoolConfig(this);

        }

        public Builder setName(String name) {
            if (StringUtils.isBlank(name)) {
                throw new IllegalArgumentException("name should not be empty.");
            }

            return this;
        }


        public Builder setMaxTotal(int maxTotal) {
            if (maxTotal < 0) {
                throw new IllegalArgumentException("maxTotal should be positive.");
            }
            this.maxTotal = maxTotal;
            return this;
        }

        public Builder setMaxIdle(int maxIdle) {
            if (maxIdle < 0) {
                throw new IllegalArgumentException("maxIdle should be positive.");
            }
            this.maxIdle = maxIdle;
            return this;
        }

        public Builder setMinIdle(int minIdle) {
            if (minIdle < 0) {
                throw new IllegalArgumentException("minIdle should be positive.");
            }
            this.minIdle = minIdle;
            return this;
        }

    }
}

