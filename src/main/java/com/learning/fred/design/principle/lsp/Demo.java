package com.learning.fred.design.principle.lsp;

/**
 * @author fred
 * @date 2020/9/24 4:44 下午
 * @description LSP
 */
public class Demo {

    public void demoFunction(Transporter transporter) {
        Request request = new Request();
//... 省略设置 request 中数据值的代码...
        Response response = transporter.sendRequest(request); //... 省略其他逻辑...

    }

    public static void main(String[] args) {
        Demo demo = new Demo();
        demo.demoFunction(new SecurityTransporter(null, "1", "2"));
    }
}
