package ru.kartsev.task4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * @author Dmitry Kartsev
 */
public class Task4 {
    public static void main(String[] args) throws IOException {
//        String path = "src\\main\\resources\\test4.txt";
        String path = args[0];
        ArrayList<String> lines = (ArrayList<String>) Files.readAllLines(Paths.get(path));
        for (int i = lines.size() - 1; i >= 0; i--) {
            if (lines.get(i).equals("")) {
                lines.remove(i);
            }
        }
        int sum = 0;
        int stepCount = 0;
        int[] nums = new int[lines.size()];
        for (int i = 0; i < lines.size(); i++) {
            nums[i] = Integer.parseInt(lines.get(i));
            sum += nums[i];
        }
        int average = Math.round(sum / lines.size());
        for (int num : nums) {
            stepCount += Math.abs(num - average);
        }
        System.out.println(stepCount);
    }
}