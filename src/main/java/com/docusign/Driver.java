package com.docusign;

import java.util.ArrayList;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.factory.DresserFactory;
import com.parser.InputHandler;


import com.pojo.Dresser;


/* This is the entry point of the application*/
public class Driver {
	final static Logger logger = Logger.getLogger(Driver.class);

	public static void main(String[] args) {

		// scanning the input commands
		Scanner sc = new Scanner(System.in);
		
		try {
			String input = sc.nextLine();

			// splitting the input string and storing it into an array of
			// strings(commands)
			String[] inputCommands = input.split(",\\s*|\\s*,\\s*|,|\\s+");
			
			String temperature = inputCommands[0].trim().toUpperCase();
			// Implementing factory Pattern for creating Dresser Instances
			// depending on the temperature(inputCommands[0])
			Dresser dresser = DresserFactory.getDresser(temperature);

			if (dresser != null) {
				// Creating input handler class which will process all the
				// commands and generate response String
				InputHandler parser = new InputHandler();
				ArrayList<String> responseList = parser.processCommands(inputCommands, dresser);
				// Output of response to the console based on provided commands
				System.out.println(String.join(", ", responseList));
			} else {
				throw new InputMismatchException("Input Mismatch...Arguments should start with HOT/COLD");
			}

		} catch (InputMismatchException ex) {
			System.out.println(ex.getMessage());
			logger.error(ex.getMessage());
		} finally {
			sc.close();
		}

	}

}
