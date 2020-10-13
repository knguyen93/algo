package matrix;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MatrixUtils {
    public static void printMatrix(int[][] matrix) {
        for (int[] x : matrix) {
            System.out.println(Arrays.stream(x).boxed().collect(Collectors.toList()));
        }
        System.out.println("");
    }
}
