package content;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void mergeSort(int[] array) {
        if (array.length < 2) return;
        int[] left = Arrays.copyOfRange(array, 0, array.length / 2);
        int[] right = Arrays.copyOfRange(array, left.length, array.length);
        mergeSort(left);
        mergeSort(right);
        merge(array, left, right);
    }

    public static void merge(int[] array, int[] left, int[] right) {
        int leftPointer = 0;
        int rightPointer = 0;
        for (int i = 0; i < array.length; i++) {
            if (leftPointer == left.length) {
                array[i] = right[rightPointer++];
            } else if (rightPointer == right.length) {
                array[i] = left[leftPointer++];
            } else if (left[leftPointer] < right[rightPointer]) {
                array[i] = left[leftPointer++];
            } else {
                array[i] = right[rightPointer++];
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[20];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(99);
        }
        System.out.println(Arrays.toString(array));
        mergeSort(array);
        System.out.println(Arrays.toString(array));
    }


}

