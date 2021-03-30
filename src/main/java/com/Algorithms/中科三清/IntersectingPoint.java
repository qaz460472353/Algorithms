package com.Algorithms.中科三清;

import java.util.Random;

public class IntersectingPoint {

    public static void main(String[] args) {
        Random random = new Random();
        Point p1 = new Point(random.nextInt(10), random.nextInt(10));
        Point p2 = new Point(random.nextInt(10), random.nextInt(10));
        Point p3 = new Point(random.nextInt(10), random.nextInt(10));
        Point p4 = new Point(random.nextInt(10), random.nextInt(10));

        Point point = intersection(p1, p2, p3, p4);
        if (point == null) {
            System.out.print("null");
        } else {
            System.out.print("交点是：(" + point.x + "," + point.y + ")");
        }

    }
    /**
     * 1、判断斜率相同不，y2-y1/x2-x1,y4-y3/x4-x3,相同则无交点，不相同说明直线有交点则执行第二步；
     * 2、设y=ax+b,通过斜率可求出a的值，通过坐标可以求出b的值，这样两个线段所在直线的两个方程式就得到了；
     * 3、通过两个方程式求出交点，再判断交点是不是落在两线段交点的区域中
     */
    public static Point intersection(Point p1, Point p2, Point p3, Point p4) {

        double A1 = p2.getY() - p1.getY();
        double B1 = p2.getX() - p1.getX();

        double C1 = A1 * p1.getX() + B1 * p1.getY();

        double A2 = p4.getY() - p3.getY();
        double B2 = p4.getX() - p3.getX();

        double C2 = A2 * p3.getX() + B2 * p3.getY();

        double det_k = A1 * B2 - A2 * B1;

        if (Math.abs(det_k) < 0.00001) {
            return null;
        }
        double a = B2 / det_k;
        double b = -1 * B1 / det_k;
        double c = -1 * A2 / det_k;
        double d = A1 / det_k;
        double x = a * C1 + b * C2;
        double y = c * C1 + d * C2;
        return new Point(x, y);
    }

    static class Point {
        double x;
        double y;

        Point() {
        }

        Point(double x, double y) {
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
    }
}
