package com.tune.charon;

import javafx.geometry.Point2D;

/**
 * Created by Tune on 2017-02-19.
 */
public class Vector2D extends Point2D
{
    public Vector2D(double x, double y)
    {
        super(x,y);
    }

    public Vector2D(Point2D point2D)
    {
        super(point2D.getX(), point2D.getY());
    }

    public static Vector2D scale(Vector2D vector, double constant)
    {
        return new Vector2D(constant * vector.getX(), constant * vector.getY());
    }

    public static Vector2D add(Vector2D vector1, Vector2D vector2)
    {
        return new Vector2D(vector1.add(vector2));
    }




}
