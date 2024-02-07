package com.oracle.labs.montecarlo;

import java.util.Date;

import io.micronaut.configuration.picocli.PicocliRunner;
import io.micronaut.context.ApplicationContext;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

@Command(name = "pi", description = "...",
        mixinStandardHelpOptions = true)
public class PiCommand implements Runnable {

    @Option(names = {"-v", "--verbose"}, description = "Verbose output.")
    boolean verbose;

    @Option(names = {"-p", "--points"}, description = "Number of points to use (default = 1000).")
    private int numberOfPoints;

    public static void main(String[] args) throws Exception {
        PicocliRunner.run(PiCommand.class, args);
    }

    public void run() {
        // business logic here
        long startTime = new Date().getTime();
        Simulation s = new Simulation(numberOfPoints > 0 ? numberOfPoints : 1000);
        System.out.println(s.getTask());
        System.out.println("---------------------------------------------------------------------------");
        double pi = s.getValue();
        long endTime = new Date().getTime();
        if (verbose) {
            System.out.println("Time taken              = " + (endTime - startTime) + " milliseconds");
            System.out.println("%age delta from Math.PI = " + s.percentDelta(pi));
        }
        System.out.println("Calculated value of Pi  = " + pi);
    }
}
