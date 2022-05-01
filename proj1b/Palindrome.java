/**
 * Created by Administrator on 2022/4/21.
 */
public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> wts = new LinkedListDeque<>();

        for (int i = 0; i < word.length(); i += 1) {
            wts.addLast(word.charAt(i));
        }
        return wts;
    }

    private boolean isPalindrome_r(String word, int i) {
        char first = word.charAt(i);
        char last = word.charAt(word.length() - i - 1);

        if(first == last || Math.abs(first - last) == 32) {
            if (i >= word.length() / 2) {
                return true;
            }
            return isPalindrome_r(word, i + 1);
        } else {
            return false;
        }
    }

    public boolean isPalindrome(String word) {
        return isPalindrome_r(word, 0);
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> d = wordToDeque(word);
        int i = 0;
        while (i < d.size() / 2) {
            if (cc.equalChars(d.get(i), d.get(d.size() - i - 1))) {
                i += 1;
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}