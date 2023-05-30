package ru.kartsev.task1;

import java.util.Arrays;

/**
 * @author Dmitry Kartsev
 */
public class Task1 {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);

        int[] array = new int[n];
        Arrays.setAll(array, i -> ++i);

        int current = 0; // Указатель на текущий элемент в массиве
        do {
            System.out.print(array[current]);
            current = (current + m - 1) % n;
        } while (current != 0);
    }
}