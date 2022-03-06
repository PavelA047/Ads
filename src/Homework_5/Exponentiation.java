package Homework_5;

public class Exponentiation {

    public static float exponent(int number, int extent) {
        if (extent == 1) {
            return number;
        } else if (extent == 0) {
            return 1;
        } else if (extent < 0) {
            extent *= -1;
            return 1 / (number * exponent(number, extent - 1));
        } else
            return number * exponent(number, extent - 1);
    }
}
