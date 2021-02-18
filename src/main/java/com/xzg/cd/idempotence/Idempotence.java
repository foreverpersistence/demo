package com.xzg.cd.idempotence;

/**
 * @author fred
 * @date 2021/1/24 21:07
 * @description todo
 */
public class Idempotence {

    private IdempotenceStorage storage;

    public Idempotence(IdempotenceStorage storage) {
        this.storage = storage;
    }

    public boolean saveIfAbsent(String idempotenceId) { return storage.saveIfAbsent(idempotenceId);
    }
    public void delete(String idempotenceId) { storage.delete(idempotenceId);
    }
}
