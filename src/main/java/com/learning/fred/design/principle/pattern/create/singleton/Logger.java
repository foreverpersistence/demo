package com.learning.fred.design.principle.pattern.create.singleton;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author fred
 * @date 2020/12/14 16:34
 * @description todo
 */
public class Logger {

    private FileWriter writer;
    private static final Logger instance = new Logger();

    private Logger() {
        File file = new File("");
        try {
            writer = new FileWriter(file, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Logger getInstance() {
        return instance;
    }

    public void log(String message) throws IOException {
        writer.write(message);
    }
}
