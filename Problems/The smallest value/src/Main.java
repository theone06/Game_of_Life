import java.math.BigInteger;
import java.util.Scanner;


class Main {
    public static BigInteger  nFactorial(long n) {
        if (n == 0 || n == 1)  {
            return BigInteger.ONE;
        } else  {
            return BigInteger.valueOf(n).multiply(nFactorial (n - 1)) ;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigInteger M = scanner.nextBigInteger();
        long n = 0;
        BigInteger result = BigInteger.ZERO;

        while (M.compareTo(result) == 1) {
            result = nFactorial(n++);
        }
        System.out.println(n - 1);

    }
}