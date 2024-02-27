import java.util.function.*;


class Operator {

    public static LongBinaryOperator binaryOperator = (from, to) -> {
        long product = 1;
        for (long i = from; i <= to; i++) {
            product *= i;
        }
        return product;
    };
}