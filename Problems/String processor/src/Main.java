import java.util.Scanner;

class StringProcessor extends Thread {

    final Scanner scanner = new Scanner(System.in); // use it to read string from the standard input

    @Override
    public void run() {
        String input = scanner.nextLine();
        while (!input.equals(input.toUpperCase())) {
            System.out.println(input.toUpperCase());
            input = scanner.nextLine();
        }

        System.out.println("FINISHED");
        scanner.close();
    }
}