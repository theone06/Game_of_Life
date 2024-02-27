import java.util.*;

public class Main {
    public static void sumOfRandom(int low, int high, int num) {
        Random ran = new Random();
        ran.setSeed(low + high);
        int sum = 0;
        for (int i = 0; i < num; i++) {
            sum += ran.nextInt(high - low + 1) + low;
        }
        System.out.println(sum);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int low = scanner.nextInt();
        int high = scanner.nextInt();
        sumOfRandom(low, high, num);
    }
}