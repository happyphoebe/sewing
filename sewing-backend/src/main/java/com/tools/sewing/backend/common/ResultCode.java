package com.tools.sewing.backend.common;

public enum ResultCode {

	SUCCESS(200), FAIL(201), EXCEPTION(202), INFO(100);

	private int code;
	
	private ResultCode(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
	
}
