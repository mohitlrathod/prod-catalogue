package com.sapient.exception;


public class SequenceException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private String errMsg;

	public SequenceException(String errMsg) {
		this.errMsg = errMsg;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	
	

}
