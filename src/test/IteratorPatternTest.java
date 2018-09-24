package test;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.util.stream.Collectors;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import main.CustomArrayListImpl;
import main.CustomHashTableImpl;
import main.MenuPrinter;
import model.Cookie;
import model.Icecream;

public class IteratorPatternTest {

	private static MenuPrinter printer;
	private static CustomArrayListImpl customIcecreamArrayList;
	private static CustomHashTableImpl customCookieHashTable;
	private static ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private static PrintStream originalOut = System.out;
	
	@BeforeAll
	public static void setUp() {
		printer = new MenuPrinter();
		customIcecreamArrayList = new CustomArrayListImpl();
		customCookieHashTable = new CustomHashTableImpl();
		// setting system output to a printstream
		// used for capturing sysouts in the print menu
	    System.setOut(new PrintStream(outContent));
	}
	
	@AfterAll
	public static void tearDown() {
		printer = null;
		customCookieHashTable = null;
		customIcecreamArrayList = null;
		//setting back system output to original one
	    System.setOut(originalOut);
	}
	
	@Test
	public void testPrinter() {
		// adding ice cream flavors to customArray
		Icecream icecream = new Icecream();
		icecream.setName("MOOSE TRACKS");
		icecream.setDescription("Vanilla ice cream with chocolate swirl & peanut butter cups");
		customIcecreamArrayList.addFlavor(icecream);
		icecream = new Icecream();
		icecream.setName("MINT CHOCOLATE CHUNK");
		icecream.setDescription("Mint ice cream with chocolate chucks");
		customIcecreamArrayList.addFlavor(icecream);
		icecream = new Icecream();
		icecream.setName("BUTTER PECAN");
		icecream.setDescription("Smooth vanilla ice cream with a slight buttery flavor and with pecans added");
		customIcecreamArrayList.addFlavor(icecream);
		icecream = new Icecream();
		icecream.setName("CHOCOLATE");
		icecream.setDescription("Classic chocolate ice cream");
		customIcecreamArrayList.addFlavor(icecream);
		icecream = new Icecream();
		icecream.setName("VINILLA");
		icecream.setDescription("Classic vinalla ice cream");
		customIcecreamArrayList.addFlavor(icecream);
		icecream = new Icecream();
		icecream.setName("RASPBERRY RIPPLE");
		// I had this on a class trip my senior year of high school and have wish I could find it in the US
		icecream.setDescription("Raspberry syrup injected into vanilla ice cream");
		customIcecreamArrayList.addFlavor(icecream);
		
		// Adding cookie types to hashTable
		Cookie c1 = new Cookie();
		c1.setName("CHOCOLATE CHIP");
		c1.setDescription("Traditional cookie with chocolate chips baked throughout");
		customCookieHashTable.addCookie(c1);
		c1 = new Cookie();
		c1.setName("PEANUT BUTTER");
		c1.setDescription("Cookie made of and filled with peanut butter goodness");
		customCookieHashTable.addCookie(c1);
		c1 = new Cookie();
		c1.setName("OATMEAL RAISEN");
		c1.setDescription("Oatmeal cookie with raisens baked throughout");
		customCookieHashTable.addCookie(c1);
		c1 = new Cookie();
		c1.setName("FORTUNE COOKIE");
		c1.setDescription("Crisp Sugar cookies with a hidden fortune (poorly written) inside");
		customCookieHashTable.addCookie(c1);
		
		// calling printer.printMenu
		printer.printMenu(customIcecreamArrayList, customCookieHashTable);
		
		// asserting the output with expected output stored in file
		// using trim function to remove extra spaces if any and get only the string values
		
		/**
		 * I tried to compare the output to the contents on sampleMenu.txt 
		 * but the test keeps failing and I can't figure out the cause of it
		 */
		 assertEquals(outContent.toString().trim(),getFileContents("sampleMenu.txt").trim());
	}
	
	// helper function that is used to get file contents.
	private String getFileContents(String filePath) {
		StringBuilder builder = new StringBuilder();
		InputStream istream = this.getClass().getClassLoader().getResourceAsStream(filePath);
		try(BufferedReader reader = new BufferedReader(new InputStreamReader(istream, Charset.defaultCharset()))){
			builder.append(reader.lines().collect(Collectors.joining(System.lineSeparator())));
		} catch (IOException e) {
			System.out.println("Exception encountered while reading file..... " + e.getMessage());
		}
		return builder.toString();
	}
	
}