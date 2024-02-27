import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int barrier = 1000;
        int num = scanner.nextInt();
        int total = 0;
        while (num != 0) {
            total += num;
            if (total >= barrier) {
               total -= barrier;
                break;
            }
            num = scanner.nextInt();
        }
        System.out.println(total);
        scanner.close();
    }
}