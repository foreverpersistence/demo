package com.xzg.cd.idempotence;

import java.util.UUID;

/**
 * @author fred
 * @date 2021/1/24 21:07
 * @description 幂等号 生成类
 */
public class IdempotenceIdGenerator {

    public String generateId() {
        return UUID.randomUUID().toString();
    }


}
