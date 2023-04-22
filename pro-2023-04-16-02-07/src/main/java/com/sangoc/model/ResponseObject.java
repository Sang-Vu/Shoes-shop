package com.sangoc.model;

public class ResponseObject {
	private String status;
	private String message;
	private Object data;

	public ResponseObject() {
	}

	public ResponseObject(String status, String message, Object data) {
		this.setStatus(status);
		this.setMessage(message);
		this.setData(data);
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public void setData(Object data) {
		this.data = data;
	}
}
