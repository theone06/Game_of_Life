import java.util.Scanner;

class NumbersFilter extends Thread {

    /* use it to read numbers from the standard input */
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void run() {
        int nums = scanner.nextInt();
        while (nums != 0) {
            if (nums % 2 == 0) {
                System.out.println(nums);
            }
            nums = scanner.nextInt();
        }
    }
}