package oracle.test;

/**
 * Provides sufficient test coverage for oracle.test.PalindromeUtil class.
 */
public class PalindromeTest {

public static void main(String args[]){
	System.out.println(PalindromeUtil.isPalindrome("Madam, I'm Adam."));
	System.out.println(PalindromeUtil.isPalindrome("ABCD"));
	System.out.println(PalindromeUtil.isPalindrome("12321"));
	System.out.println(PalindromeUtil.isPalindrome("race car"));
}
}
