public class Tester {
    public static void main(String[] args) {
        Particle p1 =  new Particle(0, 1.1, 5, 5);
        Particle p2 = new Particle(0, 5, 5, 5);
        Particle p3 = new Particle(5, 0, 5, 5);
        Particle p4 = new Particle(1.5, 5, 5, 5);
        Particle p5 = new Particle(0, 1.5, 5, 5);
        Particle p6 = new Particle(0, 1.6, 5, 5);
        Particle p7 = new Particle(0, 1.7, 5, 5);
        double L = 6;
        int M = 4;
        Grid grid = new Grid(L, M);
        grid.addParticle(p1).addParticle(p2).addParticle(p3).addParticle(p4)
                .addParticle(p5).addParticle(p6).addParticle(p7);
        System.out.printf("L=%.2f and M=%d\n", L, M);
        System.out.println("Particles amount per Cell");
        System.out.println(grid.getParticlesPerCell());
        System.out.println("Particles location per Cell");
        System.out.println(grid);
        System.out.println("Cell Index Method");
        grid.performCellIndexMethod(1.4, true);
        grid.getParticles().forEach(
                p -> System.out.println(p.stringNeighborhoods())
        );
    }
}
