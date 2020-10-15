package roll.store;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        Simulation sim = new Simulation(7);
        String buffer = sim.RunSimulation();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("simulation.out"))) {
            writer.write(buffer);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
