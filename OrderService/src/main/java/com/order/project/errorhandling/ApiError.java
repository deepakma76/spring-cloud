package com.order.project.errorhandling;

import org.springframework.http.HttpStatus;

public class ApiError {
	private HttpStatus httpStatus;
	private String exceptionMsg;

	public ApiError() {
	}

	public ApiError(HttpStatus httpStatus, String exceptionMsg) {
		this.httpStatus = httpStatus;
		this.exceptionMsg = exceptionMsg;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public String getExceptionMsg() {
		return exceptionMsg;
	}

	public void setExceptionMsg(String exceptionMsg) {
		this.exceptionMsg = exceptionMsg;
	}

}
