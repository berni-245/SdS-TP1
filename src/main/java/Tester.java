public class Tester {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        Particle p1 =  new Particle(0.8, 1.1, 0.5, 5);
        Particle p2 = new Particle(0, 5, 0.6, 5);
        Particle p3 = new Particle(5, 0, 0.4, 5);
        Particle p4 = new Particle(1.5, 5, 0.5, 5);
        Particle p5 = new Particle(1.2, 2, 0.5, 5);
        double L = 6;
        int M = 2;
        Grid grid = new Grid(L, M);
        grid.addParticle(p1).addParticle(p2).addParticle(p3).addParticle(p4)
                .addParticle(p5);
        System.out.printf("L=%.2f and M=%d\n", L, M);
        System.out.println("Particles amount per Cell");
        System.out.println(grid.getParticlesPerCell());
        System.out.println("Particles location per Cell");
        System.out.println(grid);
        System.out.println("Cell Index Method");
        grid.performCellIndexMethod(1.4, true);
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        PostProcessor.process(grid.getParticles(),elapsedTime);
        grid.getParticles().forEach(
                p -> System.out.println(p.stringNeighborhoods())
        );
        GraphRenderer.show(grid,1);
    }
}
