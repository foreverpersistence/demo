package com.learning.fred.design.principle.pattern.action.menmeto.v2;

/**
 * @author fred
 * @date 2021/1/5 14:04
 * @description todo
 */
public class InputText {

    private StringBuilder text = new StringBuilder();

    public String getText() {
        return text.toString();
    }

    public void append(String input) {
        text.append(input);
    }

    /**
     * 创建 备份
     * @return
     */
    public Snapshot createSnapshot() {
        return new Snapshot(text.toString());
    }

    public void restoreSnapshot(Snapshot snapshot) {
        this.text.replace(0, this.text.length(), snapshot.getText());
    }
}
