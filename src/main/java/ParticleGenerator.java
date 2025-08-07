import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

public class ParticleGenerator {

    public static void generate(int particleNumber, double gridSize, Consumer<Particle> consumer) {
        Random random = new Random();
        random.setSeed(System.currentTimeMillis());
        double x;
        double y;
        for (int i = 0; i < particleNumber; i++) {
            x = random.nextDouble() * gridSize;
            y = random.nextDouble() * gridSize;
            consumer.accept(new Particle(x, y, 0, 1));
        }
    }


}
