package com.learning.fred.design.principle.pattern.action.menmeto.v2;

import java.util.Scanner;

/**
 * @author fred
 * @date 2021/1/5 14:06
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
                System.out.println(inputText.toString());
            } else if (input.equals(":undo")) {
                Snapshot snapshot = snapshotsHolder.popSnapshot();
                inputText.restoreSnapshot(snapshot);
            } else {
                snapshotsHolder.pushSnapshot(inputText.createSnapshot());
                inputText.append(input);
            }
        }
    }
}
