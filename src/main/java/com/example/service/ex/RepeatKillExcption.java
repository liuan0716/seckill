package com.example.service.ex;

public class RepeatKillExcption extends SeckillException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 189757645111824265L;

	public RepeatKillExcption() {
		super();
	}

	public RepeatKillExcption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public RepeatKillExcption(String message, Throwable cause) {
		super(message, cause);
	}

	public RepeatKillExcption(String message) {
		super(message);
	}

	public RepeatKillExcption(Throwable cause) {
		super(cause);
	}
	
	

}
