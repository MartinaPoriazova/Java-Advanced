package ListUtilities;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> integers = List.of(1, 2, 18, 2, -1);

        System.out.println(ListUtils.getMin(integers));
        System.out.println(ListUtils.getMax(integers));

        List<String> strings = List.of("a", "b", "c", "d");

        System.out.println(ListUtils.getMin(strings));
        System.out.println(ListUtils.getMax(strings));
    }
}
