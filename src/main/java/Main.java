import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    private final static String STATIC_FILE = "static";
    private final static String DYNAMIC_FILE = "dynamic";
    private final static String GENERATE_PARTICLES = "generate";
    private final static String GENERATE_INPUT_FILES = "generate-input-files";
    private final static String N = "N";
    private final static String L = "L";
    private final static String M = "M";
    private final static String ID = "ID";
    private final static String PARTICLE_RADIUS = "r";
    private final static String NEIGHBOR_RADIUS = "rc";
    private final static String BOUND_PERIODICITY = "bound-periodicity";
    private final static String FIXED_RADIUS = "fixed";

    public static void main(String[] args) {
        boolean generateParticles = Boolean.parseBoolean(System.getProperty(GENERATE_PARTICLES));
        boolean generateInputFiles = Boolean.parseBoolean(System.getProperty(GENERATE_INPUT_FILES));
        int n = Integer.parseInt(System.getProperty(N));
        int id = Integer.parseInt(System.getProperty(ID));
        int m = Integer.parseInt(System.getProperty(M));
        double l = Double.parseDouble(System.getProperty(L));
        boolean boundPeriodicity = Boolean.parseBoolean(System.getProperty(BOUND_PERIODICITY));
        double neighborRadius = Double.parseDouble(System.getProperty(NEIGHBOR_RADIUS));
        Grid grid = new Grid(l, m);

        if (generateParticles) {
            double particleRadius = Double.parseDouble(System.getProperty(PARTICLE_RADIUS));
            boolean fixedRadius = Boolean.parseBoolean(System.getProperty(FIXED_RADIUS));
            ParticleGenerator.generate(n, l, grid::addParticle, generateInputFiles,particleRadius,fixedRadius);
        } else {
            parseInput(grid, n);
        }

        long startTime = System.currentTimeMillis();
        grid.performCellIndexMethod(neighborRadius, boundPeriodicity);
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        PostProcessor.process(grid.getParticles(),elapsedTime);
        // TODO: post processor

        GraphRenderer.show(grid,id);


        //testeo todo: sacar
       // grid.getParticles().forEach(
        //        p -> System.out.println(p.stringNeighborhoods())
        //);
    }

    private static void parseInput(Grid grid, int n) {
        Path staticPath = Paths.get(System.getProperty(STATIC_FILE));
        Path dynamicPath = Paths.get(System.getProperty(DYNAMIC_FILE));
        try (BufferedReader staticLines = Files.newBufferedReader(staticPath); BufferedReader dynamicLines = Files.newBufferedReader(dynamicPath)) {
            InputParser.parseParticlesFiles(staticLines, dynamicLines, grid::addParticle, n);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
