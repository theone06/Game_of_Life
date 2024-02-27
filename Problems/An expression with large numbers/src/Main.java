import java.math.BigInteger;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigInteger a = scanner.nextBigInteger();
        BigInteger b = scanner.nextBigInteger();
        BigInteger c = scanner.nextBigInteger();
        BigInteger d = scanner.nextBigInteger();
        BigInteger result = a.negate().multiply(b);
        result = result.add(c);
        result = result.subtract(d);

        System.out.println(result);
    }
}