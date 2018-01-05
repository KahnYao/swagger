package com.dpt.common;

public class ApiResult extends Result {

    public ApiResult(ResultConstant resultConstant, Object data) {
        super(resultConstant.getCode(), resultConstant.getMessage(), data);
    }

}
