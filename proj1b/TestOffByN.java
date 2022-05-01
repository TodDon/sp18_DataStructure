import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {
    @Test
    public void isOffByN() {
        CharacterComparator cc = new OffByN(5);
        assertTrue(cc.equalChars('f', 'A'));
        assertTrue(cc.equalChars('a', 'F'));
        assertTrue(cc.equalChars('a', 'f'));
        assertFalse(cc.equalChars('a', 'a'));
    }
}
