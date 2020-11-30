package com.learning.fred.design.principle.lsp;

import sun.net.www.http.HttpClient;

/**
 * @author fred
 * @date 2020/9/24 4:36 下午
 * @description todo
 */
public class Transporter {

    private HttpClient httpClient;

    public Transporter(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public Response sendRequest(Request request) {

        return null;
    }

}
