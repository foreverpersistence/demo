package com.learning.fred.design.metricdemo.controller.v2;

/**
 * @author fred
 * @date 2020/11/9 2:13 下午
 * @description todo
 */
public class Demo {

    public static void main(String[] args) {
        MetricsStorage storage = new RedisMetricsStorage();
        ConsoleReporter consoleReporter = new ConsoleReporter(storage);
        consoleReporter.startRepeatedReport(60, 60);

        EmailSender emailSender = new EmailSender();
        EmailReport emailReport = new EmailReport(storage, emailSender);
        emailReport.addToAddress("");
        emailReport.startDailyReport();

        MetricsCollector collector = new MetricsCollector(storage);
        collector.recordRequest(new RequestInfo("register", 123, 10234));
        collector.recordRequest(new RequestInfo("register", 223, 12234));
        collector.recordRequest(new RequestInfo("register", 333, 13234));
        collector.recordRequest(new RequestInfo("login", 23, 12234));
        collector.recordRequest(new RequestInfo("login", 1223, 14234));


    }
}
