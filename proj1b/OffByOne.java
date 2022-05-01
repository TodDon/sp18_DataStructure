/**
 * Created by Administrator on 2022/4/21.
 */
public class OffByOne implements CharacterComparator {
    @Override
    public boolean equalChars(char x, char y) {
        x = x < 'Z' ? x : (char)(x - 32);
        y = y < 'Z' ? y : (char)(y - 32);

        return Math.abs(x - y) == 1;
    }
}
