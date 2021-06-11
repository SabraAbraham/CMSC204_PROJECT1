import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordCheckerUtility {

	public static void comparePasswords(String password, String passwordConfirm) throws UnmatchedException {

		if (!password.equals(passwordConfirm))
			throw new UnmatchedException();

	}

	public static boolean comparePasswordsWithReturn(String password, String passwordConfirm) {

		if (password.equals(passwordConfirm))
			return true;

		return false;
	}

	public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords) {

		ArrayList<String> invalidPasswords = new ArrayList<String>();

		for (int i = 0; i < passwords.size(); i++) {
			try {
				if (!isValidPassword(passwords.get(i)))
					invalidPasswords.add(passwords.get(i));
				
			} catch (LengthException | NoUpperAlphaException | NoLowerAlphaException | NoDigitException
					| NoSpecialCharacterException | InvalidSequenceException e) {
				invalidPasswords.add(passwords.get(i) + " -> " + e.getMessage());
			}

		}

		return invalidPasswords;

	}

	public static boolean hasBetweenSixAndNineChars(String password) {

		if (password.length() >= 6 && password.length() <= 9)
			return true;

		return false;
	}

	public static boolean hasDigit(String password) throws NoDigitException {
		int count = 0;

		for (int i = 0; i < password.length(); i++) {
			if (Character.isDigit(password.charAt(i)))
				count++;
		}
		if (count <= 0)
			throw new NoDigitException();
		return true;
	}

	public static boolean hasLowerAlpha(String password) throws NoLowerAlphaException {
		int count = 0;

		for (int i = 0; i < password.length(); i++) {
			if (Character.isLowerCase(password.charAt(i)))
				count++;
		}
		if (count <= 0)
			throw new NoLowerAlphaException();
		return true;
	}

	public static boolean hasSameCharInSequence(String password) throws InvalidSequenceException {
		char[] array = password.toCharArray();
		int count = 0;
		for (int i = 0; i < password.length(); i++) {
			for (int j = i + 1; j < password.length(); j++) {
				if (array[i] != ' ')
					if (array[i] == array[j]) {
						count++;
					}
			}
		}
			if (count > 2)
				throw new InvalidSequenceException();
				
			return true;		
	}

	/*
	 * 
	 */
	public static boolean hasSpecialChar(String password) throws NoSpecialCharacterException {
		Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
		Matcher matcher = pattern.matcher(password);

		if (matcher.matches())
			throw new NoSpecialCharacterException();
		else

			return true;

	}

	public static boolean hasUpperAlpha(java.lang.String password) throws NoUpperAlphaException {
		int count = 0;

		for (int i = 0; i < password.length(); i++) {
			if (Character.isUpperCase(password.charAt(i)))
				count++;
		}
		if (count <= 0)
			throw new NoUpperAlphaException();
		return true;
	}

	public static boolean isValidLength(java.lang.String password) throws LengthException {
		if (password.length() < 6)
			throw new LengthException();
		return true;
	}

	/*
	 * @param password - - string to be checked for validity
	 * 
	 * @return true if valid password (follows all rules from above), false if an
	 * invalid password
	 * 
	 * @throws LengthException - thrown if length is less than 6 characters
	 * NoUpperAlphaException - thrown if no uppercase alphabetic
	 * NoLowerAlphaException - thrown if no lowercase alphabetic NoDigitException -
	 * thrown if no digit NoSpecialCharacterException - thrown if does not meet
	 * SpecialCharacter requirement InvalidSequenceException - thrown if more than 2
	 * of same character.
	 */
	public static boolean isValidPassword(java.lang.String password) throws LengthException, NoUpperAlphaException,
			NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException {
//		boolean isValidPassword = true;

		// add invalid passwords to array list???
//		if (isValidLength(password))
//			isValidPassword = true;
//		else
//			throw new LengthException();
//		if (hasUpperAlpha(password))
//			isValidPassword = true;
//		else
//			throw new NoUpperAlphaException();
//		if (hasLowerAlpha(password))
//			isValidPassword = true;
//		else
//			throw new NoLowerAlphaException();
//		if (hasDigit(password))
//			isValidPassword = true;
//		else
//			throw new NoDigitException();
//		if (hasSpecialChar(password))
//			isValidPassword = true;
//		else
//			throw new NoSpecialCharacterException();
//		if (hasSameCharInSequence(password))
//			isValidPassword = true;
//		else
//			throw new InvalidSequenceException();

		//return isValidPassword;
		 return isValidLength(password) && hasDigit(password) &&
		 hasUpperAlpha(password) && hasLowerAlpha(password)
		 && hasSpecialChar(password) && hasSameCharInSequence(password);

	}

	public static boolean isWeakPassword(java.lang.String password) throws WeakPasswordException {
		if (hasBetweenSixAndNineChars(password))
			throw new WeakPasswordException();
		return false;
	}
}
