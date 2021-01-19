package com.doodleblue.cybrilla.Bank.response;

public class CybrillaResponse {


	private boolean status;
	private Object data;
	private int statusCode;
	private String message;
	private String errorMessage;

	public static class  CybrillaResponseBuilder
	{
		private String message;
		private boolean status;
		private Object data;
		private int statusCode;
		private String errorMessage;

		public CybrillaResponseBuilder setMessage(String message) {
			this.message = message;
			return this;
		}

		public CybrillaResponseBuilder setStatus(boolean status) {
			this.status = status;
			return this;
		}

		public CybrillaResponseBuilder setData(Object data) {
			this.data = data;
			return this;
		}

		public CybrillaResponseBuilder setStatusCode(int statusCode) {
			this.statusCode = statusCode;
			return this;
		}

		public CybrillaResponse build() {
			return new CybrillaResponse(message,status,data,statusCode,errorMessage);
		}

		public CybrillaResponseBuilder setErrorMessage(String errorMessage) {
			this.errorMessage = errorMessage;
			return this;
		}

	}

	public CybrillaResponse(String message, boolean status, Object data, int statusCode, String errorMessage) {
		super();
		this.message = message;
		this.status = status;
		this.data = data;
		this.statusCode = statusCode;
		this.errorMessage=errorMessage;
	}
	public boolean isStatus() {
		return status;
	}

	public Object getData() {
		return data;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public String getMessage() {
		return message;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
}
