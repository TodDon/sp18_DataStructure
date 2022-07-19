import synthesizer.GuitarString;

/**
 * Created by Administrator on 2022/7/18.
 */
public class GuitarHero {
    private static String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";

    private static GuitarString[] strings = new GuitarString[keyboard.length()];

    private static double GuitarTune(int i) {
        return 440.0 * Math.pow(2, (i - 24) / 12.0);
    }

    public static void main(String[] args) {

        for (int i = 0; i < keyboard.length(); i += 1) {
            strings[i] = new GuitarString(GuitarTune(i));
        }

        while (true) {

            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                if (keyboard.indexOf(key) != -1) {
                    strings[keyboard.indexOf(key)].pluck();
                }
            }

            double sample = 0;
            for (int i = 0; i < keyboard.length(); i += 1) {
                sample += strings[i].sample();
            }

            StdAudio.play(sample);

            for (int i = 0; i < keyboard.length(); i += 1) {
                strings[i].tic();
            }
        }
    }
}
