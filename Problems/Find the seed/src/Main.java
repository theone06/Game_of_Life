import java.util.*;

public class Main {
    public static void findSeedMax(int lower, int upper, int num, int bounds) {
        Random random = new Random();
        int genNum = 0;
        int genMax = Integer.MIN_VALUE;
        int minMax = Integer.MAX_VALUE;
        int minSeed = 0;
        for (int i = lower; i <= upper; i++) {
            //set seed value
            random.setSeed(i);
            //generate N (num) values using current seed value
            for (int j = 0; j < num; j++) {
                genNum = random.nextInt(bounds);
                //find the max of the generated numbers
                if (genNum > genMax) {
                    genMax = genNum;
                }
            }
            //find the minimum among the maximums
            if (genMax < minMax) {
                minMax = genMax;
                minSeed = i;
            }
            //reset genMax
            genMax = Integer.MIN_VALUE;
        }
        System.out.println("" + minSeed + "\n" + minMax);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lowerSeed = scanner.nextInt(); //between
        int upperSeed = scanner.nextInt(); //and
        int num = scanner.nextInt(); //number of numbers
        int bounds = scanner.nextInt(); //upper bounds (exclusive)
        findSeedMax(lowerSeed, upperSeed, num, bounds);
        scanner.close();
    }
}