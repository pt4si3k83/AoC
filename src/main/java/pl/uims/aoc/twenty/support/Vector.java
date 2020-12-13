package pl.uims.aoc.twenty.support;

public class Vector {
    private int x;
    private int y;

    public Vector(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Vector(final Vector normal, final int length) {
        this.x = normal.getX() * length;
        this.y = normal.getY() * length;
    }

    public Vector(final int angle) {
        double radians = Math.toRadians(angle);
        this.x = (int) Math.cos(radians);
        this.y = (int) Math.sin(radians);
    }

    public void multiply(final int length) {
        this.x *= length;
        this.y *= length;
    }

    public void rotate(final int angle) {
        double newAngle = Math.toRadians(-angle);
        int t = this.x;
        this.x = (int) Math.round(x * Math.cos(newAngle) - y * Math.sin(newAngle));
        this.y = (int) Math.round(t * Math.sin(newAngle) + y * Math.cos(newAngle));
    }

    public void add(final Vector other) {
        this.x += other.getX();
        this.y += other.getY();
    }

    @Override
    public String toString() {
        return "Vector{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public int getManhattanDistance() {
        return Math.abs(x) + Math.abs(y);
    }
}
