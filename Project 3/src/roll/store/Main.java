package roll.store;

public class Main {

    public static void main(String[] args) {

        // testing rolls
        Simulation sim = new Simulation(7);
        String buffer = sim.RunSimulation();
        System.out.println(buffer);
    }
}
