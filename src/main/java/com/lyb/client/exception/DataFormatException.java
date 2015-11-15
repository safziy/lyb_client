package com.lyb.client.exception;

public class DataFormatException extends RuntimeException {

    

	/**
	 * 
	 */
	private static final long serialVersionUID = -2252785951855212441L;

	public DataFormatException(String message) {
        super(message);
    }

    public DataFormatException(String message, Throwable cause) {
        super(message, cause);
    }
}
