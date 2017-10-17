package com.tune.charon;

import javafx.geometry.Point2D;

/**
 * Created by Tune on 2017-02-26.
 */
public class StraightBorder extends PhysicalObject implements Collidable
{
    // Rotation of 0 is a horizontal border with inside downwards.
    private final Angle rotation;

    public StraightBorder(double restitution, Vector2D centerPosition, double rotationInRadians)
    {
        super(1, restitution, new Vector2D(Point2D.ZERO), centerPosition);
        this.rotation = new Angle(rotationInRadians);
    }

    @Override
    public boolean isInside(Vector2D position)
    {
        return false;
    }

    @Override
    public boolean safeDistance(Vector2D position)
    {
        return false;
    }

}
