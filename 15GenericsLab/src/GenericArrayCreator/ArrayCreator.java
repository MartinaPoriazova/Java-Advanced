package GenericArrayCreator;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayCreator {

    public static <T> T[] create(int length, T def) {
        T[] arr = (T[]) Array.newInstance(def.getClass(), length);
        Arrays.fill(arr, def);
        return arr;
    }

    public static <T> T[] create(
            Class<T> cl, int length, T item) {
        T[] arr = (T[]) Array.newInstance(cl, length);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = item;
        }
        return arr;
    }
}
