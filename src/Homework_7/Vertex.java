package Homework_7;

import java.util.Objects;

public class Vertex {
    private final String label;
    private boolean isVisited;
    private Integer mark;

    public Vertex(String label) {
        this.label = label;
        this.mark = Integer.MAX_VALUE;
    }

    public String getLabel() {
        return label;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public Integer getMark() {
        return mark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Vertex vertex = (Vertex) o;
        return Objects.equals(label, vertex.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label);
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "label='" + label + '\'' +
                ", mark=" + mark +
                '}';
    }

    public void setIsVisited(boolean isVisited) {
        this.isVisited = isVisited;
    }

    public boolean isVisited() {
        return isVisited;
    }
}
