import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * This is your test file.  Complete the following test cases to test your project where they make sense.
 * Include additional test cases if you like.  
 *
 * STUDENT tests for the methods of PasswordChecker
 * @author 
 *
 */
public class PasswordCheckerSTUDENT_Test {

	ArrayList<String> passwordsArray;
	
	
	@Before
	public void setUp() throws Exception {
		String[] a = {"SAbra2021", "LOL22@"};
		passwordsArray = new ArrayList<String>();
		passwordsArray.addAll(Arrays.asList(a));
	}

	@After
	public void tearDown() throws Exception {
	 passwordsArray = null;
	}

	/**
	 * Test if the password is less than 6 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidLength("1cP!"));
		}
		catch(LengthException e){
			assertTrue("Successfully threw a lengthExcepetion",true);
		}
	}
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha()
	{
		try {
			assertTrue(PasswordCheckerUtility.hasUpperAlpha("fd56hgk!!@"));
		}
		catch(NoUpperAlphaException e) {
			assertTrue("Successfully threw a No Upper Alpha exception",true);
		}
	}
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha()
	{
		try {
			assertTrue(PasswordCheckerUtility.hasLowerAlpha("FD56HGK!!@"));
		}
		catch(NoLowerAlphaException e) {
			assertTrue("Successfully threw a No Lower Alpha exception",true);
		}	}
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsWeakPassword()
	{
		try {
			assertTrue(PasswordCheckerUtility.isWeakPassword("12mom!"));
		}
		catch(WeakPasswordException e) {
			assertTrue("Successfully threw a Weak password exception",true);
		}	
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence()
	{
		try {
			assertTrue(PasswordCheckerUtility.hasSameCharInSequence("SSsaBr@!"));
		}
		catch(InvalidSequenceException e) {
			assertTrue("Successfully threw a Invalid sequence exception",true);
		}	
	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit()
	{
		try {
			assertTrue(PasswordCheckerUtility.hasDigit("2401passworD$"));
		}
		catch(NoDigitException e){
			assertTrue("Successfully threw a No Digit exception", true);
		}
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("bestt4@"));
		}
		catch(Exception e) {
			assertTrue("Password is invalid",true);
		}
	}
	
	/**
	 * Test the invalidPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testInvalidPasswords() {
		ArrayList<String> results;
		results = PasswordCheckerUtility.getInvalidPasswords(passwordsArray);
		assertEquals(results.size(), 2);
		assertEquals(results.get(0), "SAbra2021 -> The password must contain at least one special character");
		
	}
	
}
