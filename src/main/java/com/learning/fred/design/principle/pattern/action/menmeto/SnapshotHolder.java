package com.learning.fred.design.principle.pattern.action.menmeto;

import java.util.Stack;

/**
 * @author fred
 * @date 2021/1/5 13:50
 * @description 每次 保存 当前的 内容到 栈 中
 */
public class SnapshotHolder {

    private Stack<InputText> snapshots = new Stack<>();

    public InputText popSnapshot() {
        return snapshots.pop();
    }

    public void pushSnapshot(InputText inputText) {
        InputText deepClonedInputText = new InputText();
        deepClonedInputText.setText(inputText.getText());

        snapshots.push(deepClonedInputText);
    }
}
