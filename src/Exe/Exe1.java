package Exe;

public class Exe1 {
    public static void main(String[] args) {
        long num = 600851475143L;
        System.out.println(findSimpleDivider(num));
    }

    private static long findSimpleDivider(long number) {
        for (int i = 2; i < number; ) {
            if (number % i == 0) {
                number /= i;
            } else i++;
        }
        return number;
    }
}
