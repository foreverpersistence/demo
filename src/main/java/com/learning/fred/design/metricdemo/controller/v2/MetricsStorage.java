package com.learning.fred.design.metricdemo.controller.v2;

import java.util.List;
import java.util.Map;

public interface MetricsStorage {

    //save
    void saveRequestInfo(RequestInfo requestInfo);

    //get
    List<RequestInfo> getRequestInfos(String apiName, long startTimeInMillis, long end);

    Map<String, List<RequestInfo>> getRequestInfos(long startTimeInMillis, long end);
}
