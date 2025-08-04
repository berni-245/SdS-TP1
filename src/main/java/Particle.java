import java.util.ArrayList;
import java.util.List;

public class Particle {
    private static int globalId = 1;
    private final int id;
    private final double x, y;
    private final double rad;
    private final double prop;
    private final List<Particle> neighbors;

    public Particle(double x, double y, double rad, double prop) {
        this.id = globalId++;
        this.x = x;
        this.y = y;
        this.rad = rad;
        this.prop = prop;
        this.neighbors = new ArrayList<>();
    }

    public Particle addNeighbor(Particle neighbor) {
        this.neighbors.add(neighbor);
        return this;
    }

    public double getDistance(Particle p) {
        return Math.sqrt(Math.pow(p.x - x, 2) + Math.pow(p.y - y, 2));
    }

    public double getEdgeDistance(Particle p) {
        return getDistance(p) - rad - p.rad;
    }

    public double getProp() {
        return prop;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder()
                .append(id)
                .append("\t\t");
        for (Particle p : neighbors) {
            sb.append(p.id).append(", ");
        }
        sb.replace(sb.length() - 2, sb.length(), "\n");
        return sb.toString();
    }
}
