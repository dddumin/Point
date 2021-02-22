package arrays;

import model.Point;

import java.util.Scanner;

public class ArrayUtil {

    public static void fill(Point[] points, Scanner scanner){
        for (int i = 0; i < points.length; i++) {
            double x = scanner.nextDouble();
            double y = scanner.nextDouble();
            points[i] = new Point(x, y);
        }
    }
}
