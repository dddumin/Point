package model;

import java.util.ArrayList;

public class Point implements Comparable<Point> {
    private double x;
    private double y;

    public Point() {
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Point sumPoints(Point other) {
        return new Point(this.x + other.x, this.y + other.y);
    }

    public Point multiplyPoint(double n) {
        return new Point(this.x * n, this.y * n);
    }

    public Point dividingPoint(double n) {
        return new Point(this.x / n, this.y / n);
    }


    public double dist() {
        return Math.hypot(this.x, this.y);
    }

    public double dist(Point other) {
        return Math.hypot(this.x-other.x, this.y - other.y);
    }

    public double perimeter(Point other1, Point other2) {
        return this.dist(other1) + this.dist(other2) + other1.dist(other2);
    }

    public double area(Point other1, Point other2) {
        double p = this.perimeter(other1, other2) / 2;
        return Math.sqrt(p * (p - this.dist(other1)) * (p - this.dist(other2)) *
                (p - other1.dist(other2)));
    }

    @Override
    public int compareTo(Point p) {
        return Double.compare(this.dist(), p.dist());
    }


    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    /**
     * Вычислить точку, наиболее удаленную от начала координат.
     * Для решения этой задачи напишите и используйте дополнительный метод dist,
     * который возвращает расстояние от точки до начала координат.
     * Если таких точек несколько, то вернуть последнюю, удовлетворяющую условиям задачи
     */
    public static Point maxDistPoint(Point[] points) {
        double dist = 0;
        Point p = null;
        for (Point point : points) {
            if (point.dist() >= dist) {
                dist = point.dist();
                p = point;
            }
        }
        return p;
    }

    /**
     * Вычислить точки, наиболее удаленные от начала координат.
     */

    public static Point[] maxDistPoints(Point[] points) {
        double dist = maxDistPoint(points).dist();
        ArrayList<Point> pointArrayList = new ArrayList<>();
        for (Point point : points) {
            if (point.dist() == dist) {
                pointArrayList.add(point);
            }
        }
        return pointArrayList.toArray(new Point[0]);
    }

    /**
     * Вычислите точку, являющуюся центом масс данного множества точек,
     * т.е. точку, которая имеет в качестве своих координат среднее арифметическое по х и у
     */

    public static Point centerMass(Point[] points) {
        double a = 0;
        double b = 0;
        for (Point point : points) {
            a += point.x;
            b += point.y;
        }
        return new Point(a / points.length, b / points.length);
    }

    /**
     * Выведите диаметр данного множества – максимальное расстояние между двумя данными точками.
     * Для решения этой задачи реализуйте и используйте перегрузку метода dist,
     * который принимает на вход вторую точку и возвращает расстояние между двумя данными точками.
     */

    public static double setDiam(Point[] points) {
        double diam = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                if (points[i].dist(points[j]) > diam) {
                    diam = points[i].dist(points[j]);
                }
            }
        }
        return diam;
    }

    /**
     * Среди данных точек найдите три точки, образующие треугольник с наибольшим периметром.
     * Выведите данный периметр.
     * Для нахождения периметра треугольника напишите отдельный метод double Perimeter(Point other1, Point other2),
     * возвращающий периметр между тремя данными точками.
     */

    public static double maxPerimetr(Point[] points) {
        double perimetr = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = i+1; j < points.length; j++) {
                for (int k = j + 1; k < points.length; k++) {
                    if (points[i].perimeter(points[j], points[k]) > perimetr) {
                        perimetr = points[i].perimeter(points[j], points[k]);
                    }
                }
            }
        }
        return perimetr;
    }

    /**
     * Среди данных точек найдите три точки, образующие треугольник с наибольшей площадью. Выведите данную площадь.
     * Для нахождения площади треугольника напишите отдельный метод double Area(Point other1, Point other2).
     */

    public static double maxArea(Point[] points) {
        double area = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                for (int k = j + 1; k < points.length; k++) {
                    if (points[i].area(points[j], points[k]) > area)
                        area = points[i].area(points[j], points[k]);
                }
            }
        }
        return area;
    }
}







