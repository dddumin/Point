package program;

import arrays.ArrayUtil;
import model.Point;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Point[] points = new Point[n];

        ArrayUtil.fill(points, scanner);

        Arrays.sort(points);

        // System.out.println(Point.setDiam(points));

        // System.out.println(Arrays.toString(Point.maxDistPoints2(points)));

        //System.out.println(Point.maxArea(points));

        System.out.println(Arrays.toString(points));

    }
}
