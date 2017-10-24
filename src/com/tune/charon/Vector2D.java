package com.tune.charon;

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

    public void scale(double constant)
    {
        x = constant * x;
        y = constant * y;
    }

    public static Vector2D add(Vector2D vector1, Vector2D vector2)
    {
        return new Vector2D(vector1.getX() + vector2.getX(), vector1.getY() + vector2.getY());
    }

    /**
     * Subtract vector1 from vector 2
     *
     * @param vector1
     * @param vector2
     * @return
     */
    public static Vector2D subtract(Vector2D vector1, Vector2D vector2)
    {
        return new Vector2D(vector1.getX() - vector2.getX(), vector1.getY() - vector2.getY());
    }

    public void add(Vector2D vectorToAdd)
    {
        this.x = x + vectorToAdd.getX();
        this.y = y + vectorToAdd.getY();
    }

    public static double distanceBetween(Vector2D vector1, Vector2D vector2)
    {
        return subtract(vector1, vector2).length();
    }

    public double length()
    {
        return Math.sqrt(x * x + y * y);
    }

    public Angle getAngle()
    {
        return new Angle(Math.atan(this.y / this.x));
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
