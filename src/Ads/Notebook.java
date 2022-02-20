package Ads;

public class Notebook implements Comparable<Notebook> {
    private int cost;
    private int memory;
    private Manufacturer manufacturer;

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "cost=" + cost +
                ", memory=" + memory +
                ", manufacturer='" + manufacturer + '\'' +
                '}';
    }

    @Override
    public int compareTo(Notebook o) {
        if (this.cost > o.cost) {
            return 1;
        } else if (this.cost < o.cost) {
            return -1;
        } else {
            if (this.memory > o.memory) {
                return 1;
            } else if (this.memory < o.memory) {
                return -1;
            } else {
                return this.manufacturer.compareTo(o.manufacturer);
            }
        }
    }
}
