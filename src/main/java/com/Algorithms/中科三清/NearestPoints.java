package com.Algorithms.中科三清;

public class NearestPoints {

    static Point key = null;

    public static void main(String[] args) {
        Point[] points = new Point[]{
                new Point(0.0,0.0),
                new Point(1.0,2.0),
                new Point(3.0,5.0),
                new Point(4.0,4.0),
                new Point(7.0,5.0),
                new Point(12.0,30.0),
                new Point(14.0,12.0),
                new Point(7.0,9.0),
                new Point(10.0,16.0)
        };
        Point[] nearestPoint = getNearestPoint(points, new Point(3.0, 3.0), 3);
        System.out.println(nearestPoint.toString());
    }

    public static Point[] getNearestPoint(Point[] points, Point p, int n) {
        key = p;
        Point[] list = quickSort(points, 0, points.length - 1);
        Point[] result = new Point[n];
        for (int i = 0; i < n; i++) {
            result[i] = list[i];
        }
        return result;
    }

    /**
     * 对平面点数组进行快排
     * @param points 点数组
     * @param L 排序起始索引
     * @param R 结束索引
     * @return 排序后的数组
     */
    public static Point[] quickSort(Point[] points, int L, int R) {
        int i = L;
        int j = R;

        Point pivot = points[(L+R)/2];

        while (i <= j) {
            while (square(pivot) > square(points[i])) {
                i++;
            }
            while (square(pivot) < square(points[j])) {
                j--;
            }
            if (i <= j) {
                Point temp = points[i];
                points[i] = points[j];
                points[j] = temp;
                i++;
                j--;
            }
        }
        if (L < j) {
            quickSort(points, L, j);
        }
        if (i < R) {
            quickSort(points, i, R);
        }
        return points;
    }

    /**
     * 算出节点与目标节点的直线距离
     * a² = b² + c²
     * @param point 节点
     * @return
     */
    public static double square(Point point) {
        double x = Math.abs(point.x - key.x);
        double y = Math.abs(point.y - key.y);

        return x*x + y*y;
    }

    static class Point {
        double x;
        double y;

        Point(double x,double y) {
            this.x = x;
            this.y = y;
        }
    }
}
