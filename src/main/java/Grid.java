import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Grid {
    private final double L;
    private final int M;
    private final double cellLength;
    private final List<List<Particle>> particles;
    public Grid(double L, int M) {
        this.L = L;
        this.M = M;
        this.cellLength = L / M;
        this.particles = new ArrayList<>();
        for (int i = 0; i < M*M; i++) {
            particles.add(new ArrayList<>());
        }
    }

    /**
     * Particles on horizontal cell borders go to the upper cell,
     * and particles on vertical cell borders go to the right cell.
    */
    public Grid addParticle(Particle particle) {
        double parX = particle.getX();
        double parY = particle.getY();

        if (parX >= L || parX < 0 || parY >= L || parY < 0)
            throw new IndexOutOfBoundsException("The particle doesn't fit on the grid");
        int i = (int) (parX / cellLength) + M * (int) (parY / cellLength);
        particles.get(i).add(particle);
        return this;
    }

    /** To find the amount of particles per cell */
    public String getParticlesPerCell() {
        return getCustomGridRepresentation(cellParticles -> String.valueOf(cellParticles.size()));
    }

    @Override
    public String toString() {
        return getCustomGridRepresentation(particles1 -> particles1.toString() + "\t");
    }

    private String getCustomGridRepresentation(Function<List<Particle>, String> cellToString) {
        StringBuilder sb = new StringBuilder();
        for (int row = M - 1; row >= 0; row--) {
            for (int col = 0; col < M; col++) {
                int index = row * M + col;
                sb.append(cellToString.apply(particles.get(index)));
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}