/**
 * Created by Administrator on 2022/4/21.
 */
public class OffByN implements CharacterComparator {
    private int offN;

    public OffByN(int N) {
        offN = N;
    }

    @Override
    public boolean equalChars(char x, char y) {
        return Math.abs(x - y) == offN;
    }
}
