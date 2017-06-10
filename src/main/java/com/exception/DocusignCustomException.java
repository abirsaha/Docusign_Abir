package com.exception;

import org.apache.log4j.Logger;

public class DocusignCustomException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8621717223686841623L;
	final static Logger logger = Logger.getLogger(DocusignCustomException.class);
	public DocusignCustomException(String message){
		super(message);
	}
}
