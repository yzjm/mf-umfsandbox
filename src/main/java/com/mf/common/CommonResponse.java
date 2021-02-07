package com.mf.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class CommonResponse {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String code;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String msg;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private LabelInfo labelInfo;

    public CommonResponse(String code, String msg, LabelInfo labelInfo) {
        this.labelInfo = labelInfo;
        this.msg = msg;
        this.code = code;
    }

    public CommonResponse(String code, String msg, String labelId, String labelValue) {
        this.labelInfo = new LabelInfo(labelId, labelValue);
        this.msg = msg;
        this.code = code;
    }

    public static final CommonResponse NO_FOUND = new CommonResponse("0501","该标签未查得",null);
}
