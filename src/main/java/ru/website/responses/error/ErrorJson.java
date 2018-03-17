package ru.website.responses.error;

import java.util.Map;

/**
 * Created by Ленар on 17.03.2018.
 */
public class ErrorJson {
    private Integer status;
    private String error;
    private String message;
    private String timeStamp;
    private String trace;

    public ErrorJson(int status, Map<String, Object> errorAttributes) {
        this.status = status;
        this.error = (String) errorAttributes.get("error");
        this.message = (String) errorAttributes.get("message");
        this.timeStamp = errorAttributes.get("timestamp").toString();
        this.trace = (String) errorAttributes.get("trace");
    }

    public Integer getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public String getTrace() {
        return trace;
    }
}
