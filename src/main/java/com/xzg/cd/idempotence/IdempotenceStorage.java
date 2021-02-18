package com.xzg.cd.idempotence;

/**
 * @author fred
 * @date 2021/1/24 21:07
 * @description 幂等号 读写
 */
public interface IdempotenceStorage {

    boolean saveIfAbsent(String idempotenceId);
    void delete(String idempotenceId);
}
