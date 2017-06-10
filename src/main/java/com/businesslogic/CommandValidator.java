package com.businesslogic;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.exception.DocusignCustomException;
import com.pojo.ColdDresser;
import com.pojo.Command;
import com.pojo.Dresser;
import com.pojo.HotDresser;

public class CommandValidator {
	final static Logger logger = Logger.getLogger(CommandValidator.class);

	public static boolean validateCommand(ArrayList<Integer> processedCommands, Command command, Dresser dresser)
			throws DocusignCustomException {
		if (processedCommands.size() == 0) {
			if (!Integer.valueOf("8").equals(command.getCode())) {
				throw new DocusignCustomException("Starting command after HOT/COLD should be 8 for removing PJs");
			}
		}

		if (processedCommands.contains(command.getCode())) {
			throw new DocusignCustomException("Only 1 piece of each type of clothing may be put on");
		}

		if ((Integer.valueOf("3").equals(command.getCode())) || (Integer.valueOf("5").equals(command.getCode()))) 
		{
			if (dresser instanceof HotDresser) {
				throw new DocusignCustomException("You cannot put on socks or jacket when it is hot");
			}
		}

		else if (Integer.valueOf("1").equals(command.getCode())) {

			if (dresser instanceof HotDresser) {
				if (!processedCommands.contains(Integer.valueOf("6"))) {
					throw new DocusignCustomException("Pants must be put on before wearing shoes in hot temperature");
				}
			}

			else {
				if (!processedCommands.contains(Integer.valueOf("3"))
						|| !processedCommands.contains(Integer.valueOf("6"))) {
					throw new DocusignCustomException(
							"Socks and pants must be put on before wearing shoes in cold temperature");
				}
			}
		}

		else if (Integer.valueOf("2").equals(command.getCode()) || (Integer.valueOf("5").equals(command.getCode()))) {
			if (!processedCommands.contains(Integer.valueOf("4"))) {
				throw new DocusignCustomException("Shirt must be put on before headwear or jacket");
			}
		}

		else if (Integer.valueOf("7").equals(command.getCode())) {

			if (dresser instanceof ColdDresser) {
				if (!processedCommands.contains(Integer.valueOf("3"))
						|| !processedCommands.contains(Integer.valueOf("5"))) {
					throw new DocusignCustomException(
							"Jackets and socks should  be put on in cold temperature before leaving house");
				}
			}

			if (!processedCommands.contains(Integer.valueOf("1")) || !processedCommands.contains(Integer.valueOf("2"))
					|| !processedCommands.contains(Integer.valueOf("4"))
					|| !processedCommands.contains(Integer.valueOf("6"))
					|| !processedCommands.contains(Integer.valueOf("8"))) {
				throw new DocusignCustomException("All clothing items hsould be put on before leaving the house");
			}
		}

		// If all the conditions are satisfied, return true
		return true;
	}

}
