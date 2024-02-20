package org.example.cw.task4;

public class Point2D {
    int i;
    int j;

    public Point2D(int i, int j) {
        this.i = i;
        this.j = j;
    }

    @Override
    public String toString() {
        return String.format("[%s][%s]", i, j);
    }
}
