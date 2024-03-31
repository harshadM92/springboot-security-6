package org.my.hakuna.exceptionhandling;

public class HakunaException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public HakunaException() {}

	public HakunaException(String message) { 
		super(message);
	}
	
}
