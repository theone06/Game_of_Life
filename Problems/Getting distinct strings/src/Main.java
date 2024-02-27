import java.util.*;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;


class Operator {

    public static UnaryOperator<List<String>> unaryOperator = x -> {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.addAll(x);
        return hashSet.stream().collect(Collectors.toList());
    };
}