package synthesizer;

import edu.princeton.cs.algs4.StdAudio;
import javafx.beans.binding.ObjectExpression;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests the ArrayRingBuffer class.
 *
 * @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        StdAudio.play(0.9);
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<>(2);
        assertEquals(2, arb.capacity);
        arb.enqueue(1);
        assertEquals(1, (int)arb.peek());
        arb.enqueue(2);
        assertEquals(1, (int)arb.dequeue());
        arb.enqueue(3);
        assertTrue(arb.isFull());
        assertEquals(2, (int)arb.peek());
        arb.dequeue();
        arb.dequeue();
        assertTrue(arb.isEmpty());
    }

    /**
     * Calls tests for ArrayRingBuffer.
     */
//    public static void main(String[] args) {
//        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
//    }
} 
