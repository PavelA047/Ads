package Homework_5;

public enum Things {
    LAPTOP(70000, 5, 1),
    TV(50000, 20, 2),
    SMARTPHONE(100000, 1, 3),
    WATCH(50000, 1, 4),
    XBOX(50000, 5, 5),
    SOUND_SYSTEM(40000, 25, 6);

    final int cost;
    final int weight;
    final int num;

    Things(int cost, int weight, int num) {
        this.cost = cost;
        this.weight = weight;
        this.num = num;
    }
}
