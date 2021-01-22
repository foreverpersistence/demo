package com.learning.fred.design.principle.pattern.action.menmeto;

import java.util.Scanner;

/**
 * @author fred
 * @date 2021/1/5 13:54
 * @description todo
 */
public class ApplicationMain {

    public static void main(String[] args) {

        InputText inputText = new InputText();
        SnapshotHolder snapshotsHolder = new SnapshotHolder();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.next();
            if (input.equals(":list")) {
                System.out.println(inputText.getText().toString());
            } else if (input.equals(":undo")) {
                InputText snapshot = snapshotsHolder.popSnapshot();
                inputText.setText(snapshot.getText());
            } else {
                snapshotsHolder.pushSnapshot(inputText);
                inputText.append(input);
            }
        }

    }
}
