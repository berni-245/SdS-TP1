public class MainTester {

    private final static String STATIC_FILE = "static";
    private final static String DYNAMIC_FILE = "dynamic";
    private final static String N = "N";
    private final static String L = "L";
    private final static String M = "M";

    public static void main(String[] args) {
        //Path staticFilePath = Paths.get(System.getProperty(STATIC_FILE));
        //Path dynamicFilePath = Paths.get(System.getProperty(DYNAMIC_FILE));
        Grid grid = new Grid(6,4);
        ParticleGenerator.generate(20,6,grid::addParticle);
        grid.performCellIndexMethod(1.4,false);
        grid.getParticles().forEach(
                p -> System.out.println(p.stringNeighborhoods())
        );

    }

}
