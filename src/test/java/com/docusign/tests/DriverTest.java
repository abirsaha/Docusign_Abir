package com.docusign.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.factory.DresserFactory;
import com.parser.InputHandler;

import com.pojo.Dresser;

import com.util.DocusignUtil;

public class DriverTest {
	static DocusignUtil util = DocusignUtil.getInstance();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

	}

	@Before
	public void setUp() throws Exception {

	}

	@Test
	public void test1() {
		String[] inputCommands = { "HOT", "8", "6", "4", "2", "1", "7" };
		String expected = "Removing PJs, shorts, t-shirt, sun visor, sandals, leaving house";
		Dresser dresser = DresserFactory.getDresser(inputCommands[0]);
		InputHandler parser = new InputHandler();
		ArrayList<String> responseList = parser.processCommands(inputCommands, dresser);
		String response = String.join(", ", responseList);
		assertEquals(expected, response);
	}

	@Test
	public void test2() {
		String input = "COLD 8, 6, 3, 4, 2, 5, 1, 7";
		String[] inputCommands = input.split(",\\s*|\\s*,\\s*|,|\\s+");
		String expected = "Removing PJs, pants, socks, shirt, hat, jacket, boots, leaving house";
		Dresser dresser = DresserFactory.getDresser(inputCommands[0]);
		InputHandler parser = new InputHandler();
		ArrayList<String> responseList = parser.processCommands(inputCommands, dresser);
		String response = String.join(", ", responseList);
		assertEquals(expected, response);
	}

	@Test
	public void test3() {
		String input = "HOT 8, 6, 6";
		String[] inputCommands = input.split(",\\s*|\\s*,\\s*|,|\\s+");
		String expected = "Removing PJs, shorts, fail";
		Dresser dresser = DresserFactory.getDresser(inputCommands[0]);
		InputHandler parser = new InputHandler();
		ArrayList<String> responseList = parser.processCommands(inputCommands, dresser);
		String response = String.join(", ", responseList);
		assertEquals(expected, response);
	}

	@Test
	public void test4() {
		String input = "HOT 8, 6, 3";
		String[] inputCommands = input.split(",\\s*|\\s*,\\s*|,|\\s+");
		String expected = "Removing PJs, shorts, fail";
		Dresser dresser = DresserFactory.getDresser(inputCommands[0]);
		InputHandler parser = new InputHandler();
		ArrayList<String> responseList = parser.processCommands(inputCommands, dresser);
		String response = String.join(", ", responseList);
		assertEquals(expected, response);
	}

	@Test
	public void test5() {
		String input = "COLD 8, 6, 3, 4, 2, 5, 7";
		String[] inputCommands = input.split(",\\s*|\\s*,\\s*|,|\\s+");
		String expected = "Removing PJs, pants, socks, shirt, hat, jacket, fail";
		Dresser dresser = DresserFactory.getDresser(inputCommands[0]);
		InputHandler parser = new InputHandler();
		ArrayList<String> responseList = parser.processCommands(inputCommands, dresser);
		String response = String.join(", ", responseList);
		assertEquals(expected, response);
	}

	@Test
	public void test6() {
		String input = "COLD 6";
		String[] inputCommands = input.split(",\\s*|\\s*,\\s*|,|\\s+");
		String expected = "fail";
		Dresser dresser = DresserFactory.getDresser(inputCommands[0]);
		InputHandler parser = new InputHandler();
		ArrayList<String> responseList = parser.processCommands(inputCommands, dresser);
		String response = String.join(", ", responseList);
		assertEquals(expected, response);
	}

	@Test()
	public void test7() {
		String input = "MILD 6,7,8";
		String[] inputCommands = input.split(",\\s*|\\s*,\\s*|,|\\s+");
		Dresser dresser = DresserFactory.getDresser(inputCommands[0]);
		assertNull(dresser);
	}

	@Test
	public void test8() {
		String input = "HOT 8";
		String[] inputCommands = input.split(",\\s*|\\s*,\\s*|,|\\s+");
		String expected = "Removing PJs";
		Dresser dresser = DresserFactory.getDresser(inputCommands[0]);
		InputHandler parser = new InputHandler();
		ArrayList<String> responseList = parser.processCommands(inputCommands, dresser);
		String response = String.join(", ", responseList);
		assertEquals(expected, response);
	}

}
