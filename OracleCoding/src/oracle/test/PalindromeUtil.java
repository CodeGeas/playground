package oracle.test;

/**
 * Checks if a string is a palindrome.
 *
 * Palindrome is a word, phrase or sentence that reads the same backward or
 * forward. For example, the following string is a palindrome: "Madam, I'm Adam."
 */
public class PalindromeUtil {
	/**
	 * Checks whether passed String is a palindrome or not.
	 *
	 * Requirements:
	 * - Limit the amount of additional consumed memory to O(1).
	 * - Limit complexity to O(n).
	 *
	 * @return true if passed string is palindrome, false - otherwise
	 */
	public static boolean isPalindrome(String str) {

		int i=0;
		int j=str.length()-1;
		
		while(i<j)
		{
			while(!Character.isLetter(str.charAt(i)) && !Character.isDigit(str.charAt(i))){
				i++;
			}
			while(!Character.isLetter(str.charAt(j)) && !Character.isDigit(str.charAt(j))){
				j--;
			}		
			if(Character.toLowerCase(str.charAt(i))!=Character.toLowerCase(str.charAt(j))){
				return false;
			}
			i++;
			j--;
		}
		return true;
	}
}

