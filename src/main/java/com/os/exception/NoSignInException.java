package com.os.exception;

public class NoSignInException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoSignInException(String message){
		super(message);
	}
}
