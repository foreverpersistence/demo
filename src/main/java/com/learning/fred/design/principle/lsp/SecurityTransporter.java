package com.learning.fred.design.principle.lsp;

import org.apache.commons.lang3.StringUtils;
import sun.net.www.http.HttpClient;

/**
 * @author fred
 * @date 2020/9/24 4:40 下午
 * @description todo
 */
public class SecurityTransporter extends Transporter {

    private String appid;
    private String appToken;

    public SecurityTransporter(HttpClient httpClient, String appid, String appToken) {
        super(httpClient);
        this.appid = appid;
        this.appToken = appToken;
    }

    @Override
    public Response sendRequest(Request request) {
        if (StringUtils.isNotBlank(appid) && StringUtils.isNotBlank(appToken)) {
            //todo
        }
        return super.sendRequest(request);
    }
}
