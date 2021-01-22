package com.learning.fred.design.principle.pattern.action.menmeto;

/**
 * @author fred
 * @date 2021/1/5 13:47
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
     * 全覆盖
     * @param text
     */
    public void setText(String text) {
        this.text.replace(0, this.text.length(), text);
    }
}
