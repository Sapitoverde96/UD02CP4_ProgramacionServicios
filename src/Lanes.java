public class Lanes {
    private final boolean[] lanes;

    public Lanes(int totalLanes) {
        this.lanes = new boolean[totalLanes];
        for (int lane = 0; lane < totalLanes; lane++) {
            this.lanes[lane] = true;
        }
    }

    public synchronized int occupy() throws InterruptedException {
        int lane;
        while ((lane = searchEmptyLane()) == -1) {
            wait();
        }
        this.lanes[lane] = false;
        return lane;
    }

    public synchronized void free(int lane) {
        this.lanes[lane] = true;
        notify();
    }

    private int searchEmptyLane() {
        for (int lane = 0; lane < this.lanes.length; lane++) {
            if (this.lanes[lane]) {
                return lane;
            }
        }
        return -1;
    }
}
