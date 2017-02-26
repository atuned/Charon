package com.tune.charon;

import javafx.geometry.Point2D;

/**
 * Created by Tune on 2017-02-26.
 */
public class StraightBorder extends PhysicalObject implements Collidable
{
    private final double length;
    private final double rotation;

    public StraightBorder(double restitution, Vector2D centerPosition, double length, double rotation)
    {
        super(1, restitution, new Vector2D(Point2D.ZERO), centerPosition);
        this.length = length;
        this.rotation = rotation;
    }

    @Override
    public boolean isInside(Vector2D position)
    {
        return false;
    }

    @Override
    public double safeDistance()
    {
        return length / 2;
    }
}
