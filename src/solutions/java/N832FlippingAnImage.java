package solutions.java;

import java.util.Arrays;
import java.util.stream.IntStream;

public class N832FlippingAnImage {

    public int[][] flipAndInvertImage(int[][] arr) {
        return Arrays.stream(arr)//
                .map(a -> IntStream.range(0, a.length).map(i -> a[a.length - 1 - i] ^ 1).toArray())//
                .toArray(int[][]::new);
    }

    public int[][] flipAndInvertImageInPlace(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < (arr[i].length + 1) / 2; j++) {
                int tmp = arr[i][j] ^ 1;
                arr[i][j] = arr[i][arr.length - 1 - j] ^ 1;
                arr[i][arr.length - 1 - j] = tmp;
            }
        }
        return arr;
    }
}
