package com.tune.charon;

import javafx.geometry.Point2D;

/**
 * Created by Tune on 2017-02-19.
 */
public abstract class PhysicalObject
{
    private final double mass;
    private Vector2D velocity;
    private Vector2D position;
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

    protected void setVelocity(Vector2D velocity)
    {
        this.velocity = velocity;
    }

    public Vector2D getPosition()
    {
        return position;
    }

    protected void setPosition(Vector2D position)
    {
        this.position = position;
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
