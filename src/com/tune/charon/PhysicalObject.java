package com.tune.charon;

import javafx.geometry.Point2D;

/**
 * Created by Tune on 2017-02-19.
 */
public abstract class PhysicalObject
{
    private final double mass;
    private Vector2D velocity;
    private Point2D position;
    private double restitution;

    public PhysicalObject(double mass, double restitution, Vector2D velocity, Point2D position)
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

    public void setVelocity(Vector2D velocity)
    {
        this.velocity = velocity;
    }

    public Point2D getPosition()
    {
        return position;
    }

    public void setPosition(Point2D position)
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
