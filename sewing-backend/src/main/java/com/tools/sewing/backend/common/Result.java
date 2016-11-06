package com.tools.sewing.backend.common;

public class Result {

	private boolean success = true;
	private int code;
	private String key;
	private String message;
	private Object data;
	
	public Result() {
		super();
	}
	
	public Result(boolean success, String message, int statusCode, String key) {
		super();
		this.setSuccess(success);
		this.setMessage(message);
		this.setCode(statusCode);
		this.setKey(key);
		this.data = new String();

	}
	
	public Result(boolean success, String message, int statusCode, String key, Object resultObj) {
		super();
		this.setSuccess(success);
		this.setMessage(message);
		this.setCode(statusCode);
		this.setKey(key);
		this.data = resultObj;
	}
	
	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	@Override
	public String toString() {
		return "Result [success=" + success + ", message=" + message + ", code=" + code + ", key=" + key
				+ ", data=" + data + "]";

	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public Object getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
}
