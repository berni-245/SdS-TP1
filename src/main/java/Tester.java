public class Tester {
    public static void main(String[] args) {
        Particle p1 = new Particle(0, 0, 5, 5);
        Particle p2 = new Particle(0, 5, 5, 5);
        Particle p3 = new Particle(5, 0, 5, 5);
        Particle p4 = new Particle(4.5, 4.5, 5, 5);
        double L = 6;
        int M = 6;
        Grid grid = new Grid(L, M);
        grid.addParticle(p1).addParticle(p2).addParticle(p3).addParticle(p4);
        System.out.printf("L=%f and M=%d\n", L, M);
        System.out.println("Particles amount per Cell");
        System.out.println(grid.getParticlesPerCell());
        System.out.println("Particles location per Cell");
        System.out.println(grid);
    }
}
