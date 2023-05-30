package ru.kartsev.task2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Dmitry Kartsev
 */
public class Task2 {
    public static void main(String[] args) throws IOException {

//        File circleParameter = new File("src\\main\\resources\\file1.txt");
//        File coordinatesParameters = new File("src\\main\\resources\\file2.txt");
        File circleParameter = new File(args[0]);
        File coordinatesParameters = new File(args[1]);
        BufferedReader objectCircle = new BufferedReader(new FileReader(circleParameter));
        BufferedReader objectCoordinates = new BufferedReader(new FileReader(coordinatesParameters));

        String[] centerArray = objectCircle.readLine().split(" ");
        float centerCircleX = Float.parseFloat(centerArray[0]);
        float centerCircleY = Float.parseFloat(centerArray[1]);
        float radius = Float.parseFloat(objectCircle.readLine());

        String[] coordinatesArray;
        String line;
        while ((line = objectCoordinates.readLine()) != null) {
            coordinatesArray = line.split(" ");
            float coordinatesX = Float.parseFloat(coordinatesArray[0]);
            float coordinatesY = Float.parseFloat(coordinatesArray[1]);
            if (radius == findPosition(coordinatesX, coordinatesY, centerCircleX, centerCircleY)) {
                System.out.println("0");
            } else if (Math.pow(coordinatesX - centerCircleX, 2) + Math.pow(coordinatesY - centerCircleY, 2) <=
                    Math.pow(radius, 2) &&
                    radius != findPosition(coordinatesX, coordinatesY, centerCircleX, centerCircleY)) {
                System.out.println("1");
            } else {
                System.out.println("2");
            }
        }
    }

    public static float findPosition(float coordinatesX, float coordinatesY, float centerCircleX, float centerCircleY) {
        return (float) Math.pow(Math.pow(coordinatesX - centerCircleX, 2) + Math.pow(coordinatesY - centerCircleY, 2), 0.5);
    }
}