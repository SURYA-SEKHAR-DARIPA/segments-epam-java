package com.epam.rd.autotasks.segments;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;
import static java.lang.StrictMath.pow;

class Segment {

    public double x1;
    public double y1;
    public double x2;
    public double y2;
    public Segment(Point start, Point end) {
        x1 = start.getX();
        y1 = start.getY();
        x2 = end.getX();
        y2 = end.getY();
        if (x1 == x2 && y1 == y2) {
            throw new IllegalArgumentException();
        }
    }

    double length() {
        double d = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        return d;
    }

    Point middle() {
        double x;
        double y;
        x = (x1 + x2)/2;
        y = (y1 + y2)/2;
        Point mid = new Point(x,y);
        return mid;
    }

    Point intersection(Segment another) {
        double x3 = another.x1;
        double y3 = another.y1;
        double x4 = another.x2;
        double y4 = another.y2;
        double u = ((x1 - x3) * (y1 - y2) - (y1 - y3) * (x1-x2))/((x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4));
        double t = ((x1 - x3) * (y3 - y4) - (y1 - y3) * (x3-x4))/((x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4));
        double x = x1 + t * (x2 - x1);
        double y = y1 + t * (y2 - y1);
        if ((t >= 0 && t <= 1) && (u >= 0 && u <= 1)){
            Point inter = new Point(x,y);
            return inter;
        } else {
            return null;
        }
    }
}


