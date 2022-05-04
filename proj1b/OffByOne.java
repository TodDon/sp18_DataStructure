/**
 * Created by Administrator on 2022/4/21.
 */
public class OffByOne implements CharacterComparator {
    @Override
    public boolean equalChars(char x, char y) {

        return Math.abs(x - y) == 1;
    }
}
