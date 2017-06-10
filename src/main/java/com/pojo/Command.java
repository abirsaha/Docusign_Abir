package com.pojo;

import org.apache.log4j.Logger;

import com.constants.GlobalConstant;
import com.exception.DocusignCustomException;
import com.util.DocusignUtil;

public class Command {
	final static Logger logger = Logger.getLogger(Command.class);
	
	private String action;
	private String response;
	private int code;
	
	public static DocusignUtil docusignUtil = DocusignUtil.getInstance();
	
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}
	
	
	public static String convertToEnum(int code) throws DocusignCustomException {
		switch (code) {

		case 1:
			return docusignUtil.readProperty(GlobalConstant.ONE.toString());

		case 2:
			return docusignUtil.readProperty(GlobalConstant.TWO.toString());

		case 3:
			return docusignUtil.readProperty(GlobalConstant.THREE.toString());

		case 4:
			return docusignUtil.readProperty(GlobalConstant.FOUR.toString());

		case 5:
			return docusignUtil.readProperty(GlobalConstant.FIVE.toString());

		case 6:
			return docusignUtil.readProperty(GlobalConstant.SIX.toString());

		case 7:
			return docusignUtil.readProperty(GlobalConstant.SEVEN.toString());

		case 8:
			return docusignUtil.readProperty(GlobalConstant.EIGHT.toString());

		default:
			logger.error("Command not supported-"+code+"");
			throw new DocusignCustomException("Command not supported");
			
			
		}
	}
	
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj.getClass() != getClass()) {
			return false;
		}
		Command command = (Command) obj;
		if (Integer.valueOf(this.getCode()) == Integer.valueOf(command.getCode())) {
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Integer.valueOf(code).hashCode();
	}
	
	

}
