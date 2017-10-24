package com.tune.charon;

import javafx.geometry.Point2D;

/**
 * Created by Tune on 2017-02-19.
 */
public abstract class PhysicalObject
{
    protected Vector2D position;
    protected Vector2D velocity;
    private final double mass;
    private double restitution;

    public PhysicalObject(double mass, double restitution, Vector2D velocity, Vector2D position)
    {
        this.mass = mass;
        this.velocity = velocity;
        this.position = position;
        this.restitution = restitution;
    }

    public Vector2D getVelocity()
    {
        return velocity;
    }

    public Vector2D getPosition()
    {
        return position;
    }

    public double getMass()
    {
        return mass;
    }

    public double getRestitution()
    {
        return restitution;
    }
}
