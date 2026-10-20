import java.util.Random;

public class Vehicle implements Runnable {
    private static final Random RANDOM_NUMBER = new Random();
    private final String name;
    private final Lanes lanes;

    public Vehicle(String name, Lanes lanes) {
        this.name = name;
        this.lanes = lanes;
    }

    @Override
    public void run() {
        try {
            int lane = lanes.occupy();
            long startTime = System.currentTimeMillis();
            System.out.printf("%s ha entrado en la pista %d.\n", name, lane + 1);
            Thread.sleep(2000 + RANDOM_NUMBER.nextInt(3000 + 1));
            double seconds = (System.currentTimeMillis() - startTime) / 1000.0;
            System.out.printf("%s completó la prueba en %.3f segundos.\n", name, seconds);
            lanes.free(lane);
            System.out.printf("%s ha salido de la pista %d.\n", name, lane + 1);
        } catch (InterruptedException exception) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(exception);
        }
    }
}
