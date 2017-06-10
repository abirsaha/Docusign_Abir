package com.parser;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.businesslogic.CommandValidator;
import com.exception.DocusignCustomException;
import com.pojo.Command;
import com.pojo.Dresser;
import com.util.DocusignUtil;

public class InputHandler {
	final static Logger logger = Logger.getLogger(InputHandler.class);
	
	private ArrayList<Command> commandList;
	private ArrayList<String> responseList;
	private ArrayList<Integer> codeList;
	public static DocusignUtil docusignUtil = DocusignUtil.getInstance();
	

	public InputHandler() {
		commandList = new ArrayList<Command>();
		responseList = new ArrayList<String>();
		codeList = new ArrayList<Integer>();
	}

	public ArrayList<String> processCommands(String[] inputList,Dresser dresser)  {
		String temperature = inputList[0].trim().toUpperCase();
		
		try{
		for (int i = 1; i < inputList.length; i++) {
			String input = inputList[i].trim();
			Command newCommand = new Command();
			newCommand.setAction(Command.convertToEnum(Integer.parseInt(input)));
			newCommand.setCode(Integer.parseInt(input));
			newCommand.setResponse(docusignUtil.readProperty(temperature+"_"+newCommand.getAction()));
			
			if(CommandValidator.validateCommand(codeList,newCommand,dresser)){
				codeList.add(newCommand.getCode());
				commandList.add(newCommand);
				responseList.add(newCommand.getResponse());
			} 
		}} catch(DocusignCustomException dex){
			responseList.add("fail");
			logger.error("Error while validating commands---",dex);
		}
		

		return responseList;

	}

	}
