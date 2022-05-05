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
        int fx = x <= 'z' && x >= 'a' ? 0 : 1;
        int fy = y <= 'z' && y >= 'a' ? 0 : 1;

        if (fx == 1) {
            fx = x <= 'Z' && x >= 'A' ? 1 : 2;
        }

        if (fy == 1) {
            fy = y <= 'Z' && y >= 'A' ? 1 : 2;
        }

        if (fx == fy) {
            return Math.abs(x - y) == offN;
        }
        return false;
    }
}
