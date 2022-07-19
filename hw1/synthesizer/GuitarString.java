//package <package name>;
package synthesizer;

import java.util.ArrayList;

//Make sure this class is public
public class GuitarString {
    /** Constants. Do not change. In case you're curious, the keyword final means
     * the values cannot be changed at runtime. We'll discuss this and other topics
     * in lecture on Friday. */
    private static final int SR = 44100;      // Sampling Rate
    private static final double DECAY = .996; // energy decay factor

    /* Buffer for storing sound data. */
    private BoundedQueue<Double> buffer;

    /* Create a guitar string of the given frequency.  */
    public GuitarString(double frequency) {
        //       cast the result of this divsion operation into an int. For better
        //       accuracy, use the Math.round() function before casting.
        //       Your buffer should be initially filled with zeros.
        buffer = new ArrayRingBuffer<>((int) Math.round(SR / frequency));
        while (!buffer.isFull()) {
            buffer.enqueue(.0);
        }
    }


    /* Pluck the guitar string by replacing the buffer with white noise. */
    public void pluck() {
        //       between -0.5 and 0.5. You can get such a number by using:
        //       double r = Math.random() - 0.5;
        //
        //       Make sure that your random numbers are different from each other.
        while (!buffer.isEmpty()) {
            buffer.dequeue();
        }

        ArrayList<Double> als = new ArrayList<>(buffer.capacity());
        while (!buffer.isFull()) {
            double r = Math.random() - .5;
            if (!als.contains(r)) {
                als.add(r);
                buffer.enqueue(r);
            }
        }
    }

    /* Advance the simulation one time step by performing one iteration of
     * the Karplus-Strong algorithm. 
     */
    public void tic() {
        //       the average of the two multiplied by the DECAY factor.
        //       Do not call StdAudio.play().
        double f = buffer.dequeue();
        double n = buffer.peek();

        // guitar
        buffer.enqueue((f + n) * DECAY / 2);
        // harp
        //buffer.enqueue(-(f + n) * DECAY / 2);
        // drums
        //buffer.enqueue((f + n) / 2 * (Math.random() < 0.5 ? -1 : 1));
    }

    /* Return the double at the front of the buffer. */
    public double sample() {
        return buffer.peek();
    }
}
