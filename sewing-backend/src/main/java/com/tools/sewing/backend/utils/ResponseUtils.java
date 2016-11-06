package com.tools.sewing.backend.utils;


import com.tools.sewing.backend.common.Result;
import com.tools.sewing.backend.common.ResultCode;

public class ResponseUtils {

	public static Result success(ResultCode code) {
		return ResultUtils.getInstance(true, code.getCode(), code.name());
	}

	public static Result success(ResultCode code, Object... strings) {
		return ResultUtils.getInstance(true, code.getCode(), code.name(), strings);
	}

	public static Result success(ResultCode code, Object content) {
		return ResultUtils.getInstance(true, code.getCode(), code.name(), content);
	}

	public static Result success(ResultCode code, Object content, Object... strings) {
		return ResultUtils.getInstance(true, code.getCode(), code.name(), content, strings);
	}
	
	public static Result fail(ResultCode code) {
		return ResultUtils.getInstance(false, code.getCode(), code.name());
	}
	
	public static Result fail(ResultCode code, Object... strings) {
		return ResultUtils.getInstance(false, code.getCode(), code.name(), strings);
	}

	public static Result fail(ResultCode code, Object content) {
		return ResultUtils.getInstance(false, code.getCode(), code.name(), content);
	}

	public static Result fail(ResultCode code, Object content, Object... strings) {
		return ResultUtils.getInstance(false, code.getCode(), code.name(), content, strings);
	}
	
	public static Result returnResult(Boolean success, ResultCode successCode, ResultCode failCode) {
		if( success ){
			return ResultUtils.getInstance(success, successCode.getCode(), successCode.name());
		}
		return ResultUtils.getInstance(success, failCode.getCode(), failCode.name());
	}
	
}
