import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }// Uncomment this class once you've created your Palindrome class.

    @Test
    public void testIsPalindrome() {
        assertTrue(palindrome.isPalindrome("A"));

        assertFalse(palindrome.isPalindrome("Hello"));

        assertTrue(palindrome.isPalindrome("Helleh"));

        assertTrue(palindrome.isPalindrome("alaala"));
    }

    @Test
    public void testIsPalindromeDiff() {
        CharacterComparator cc = new OffByN(25);

        assertTrue(palindrome.isPalindrome("", cc));

        assertFalse(palindrome.isPalindrome("Tzaam", cc));

        assertFalse(palindrome.isPalindrome("Helleh", cc));

        assertFalse(palindrome.isPalindrome("TzAAm", cc));
    }
}
