package com.github.tkurz.media.fragments;

/**
 * ...
 * <p/>
 * Author: Thomas Kurz (tkurz@apache.org)
 */
public class RegionalFragment {

    private Unit unit = Unit.PIXEL;
    private double x,y,w,h;

    public RegionalFragment() {}

    public RegionalFragment(double x, double y, double w, double h) {
        this(Unit.PIXEL,x,y,w,h);
    }

    public RegionalFragment(Unit unit, double x, double y, double w, double h) {
        this.unit = unit;
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    public static enum Unit {
        PIXEL, PERCENT
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
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

    public double getW() {
        return w;
    }

    public void setW(double w) {
        this.w = w;
    }

    public double getH() {
        return h;
    }

    public void setH(double h) {
        this.h = h;
    }

    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("xywh=");
        b.append(unit.name().toLowerCase());
        b.append(":");
        b.append(x);
        b.append(",");
        b.append(y);
        b.append(",");
        b.append(w);
        b.append(",");
        b.append(h);
        return b.toString();
    }
}