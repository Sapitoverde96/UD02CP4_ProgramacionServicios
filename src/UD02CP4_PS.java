void main() {
    Lanes lanes = new Lanes(2);

    Vehicle vehicle01 = new Vehicle("Vehículo 1", lanes);
    Vehicle vehicle02 = new Vehicle("Vehículo 2", lanes);
    Vehicle vehicle03 = new Vehicle("Vehículo 3", lanes);
    Vehicle vehicle04 = new Vehicle("Vehículo 4", lanes);

    Thread thread01 = new Thread(vehicle01);
    Thread thread02 = new Thread(vehicle02);
    Thread thread03 = new Thread(vehicle03);
    Thread thread04 = new Thread(vehicle04);

    thread01.start();
    thread02.start();
    thread03.start();
    thread04.start();

    try {
        thread01.join();
        thread02.join();
        thread03.join();
        thread04.join();
    } catch (InterruptedException exception) {
        Thread.currentThread().interrupt();
    }
}