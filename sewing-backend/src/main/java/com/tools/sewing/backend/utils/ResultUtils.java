package com.tools.sewing.backend.utils;

import com.tools.sewing.backend.common.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.MessageFormat;
import java.util.Properties;

public class ResultUtils {

	private final static Logger logger = LoggerFactory.getLogger(ResultUtils.class);
	private final static Properties pros;

	static {
		InputStream inputStream = ResultUtils.class.getClassLoader().getResourceAsStream("response-info.properties");
		pros = new Properties();
		try {
			pros.load(new BufferedReader(new InputStreamReader(inputStream, "utf-8")));
		} catch (IOException e1) {
			logger.error("ResultInfo load resource", e1);
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					logger.error("get exception", e);
				}
			}
		}
	}

	private static String getMessage(int statusCode, String key, Object... params) {
		String rawMsg = pros.getProperty("" + statusCode);
		String msg;
		if (rawMsg == null || rawMsg.isEmpty()) {
			if (params != null && params.length > 0) {
				msg = (String) params[0];
			} else {
				logger.error("get statusCode as " + key + " but detailed msg is not defined!");
				msg = "";
			}
		} else {
			msg = MessageFormat.format(rawMsg, params);
		}
		return msg;
	}

	public static Result getInstance(boolean success, int statusCode, String key) {

		return new Result(success, getMessage(statusCode, key), statusCode, key);
	}

	public static Result getInstance(boolean success, int statusCode, String key, Object content) {

		return new Result(success, getMessage(statusCode, key), statusCode, key, content);
	}

	public static Result getInstance(boolean success, int statusCode, String key, Object... params) {

		return new Result(success, getMessage(statusCode, key, params), statusCode, key);
	}

	public static Result getInstance(boolean success, int statusCode, String key, Object content, Object... params) {

		return new Result(success, getMessage(statusCode, key, params), statusCode, key, content);
	}


}
