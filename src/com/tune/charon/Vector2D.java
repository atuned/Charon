package com.tune.charon;

import javafx.geometry.Point2D;

/**
 * Created by Tune on 2017-02-19.
 */
public class Vector2D
{
    private double x;
    private double y;

    public Vector2D(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    public Vector2D()
    {
        x = 0;
        y = 0;
    }

    public static Vector2D scale(Vector2D vector, double constant)
    {
        return new Vector2D(constant * vector.getX(), constant * vector.getY());
    }

    public static Vector2D add(Vector2D vector1, Vector2D vector2)
    {
        return new Vector2D(vector1.getX() + vector2.getX(), vector1.getY() + vector2.getY());
    }

    public void add(Vector2D vectorToAdd)
    {
        this.x = x + vectorToAdd.getX();
        this.y = y + vectorToAdd.getY();
    }

    public double getX()
    {
        return x;
    }

    public double getY()
    {
        return y;
    }
}
