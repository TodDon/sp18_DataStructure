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
}
