package com.learning.fred.design.principle.pattern.action.menmeto.v2;

import java.util.Stack;

/**
 * @author fred
 * @date 2021/1/5 14:05
 * @description todo
 */
public class SnapshotHolder {

    private Stack<Snapshot> snapshots = new Stack<>();
    public Snapshot popSnapshot() {
        return snapshots.pop();
    }
    public void pushSnapshot(Snapshot snapshot) {
        snapshots.push(snapshot);
    }
}
