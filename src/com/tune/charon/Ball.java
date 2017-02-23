package com.tune.charon;

import javafx.geometry.Point2D;

/**
 * Created by Tune on 2017-02-19.
 */
public class Ball extends PhysicalObject implements Movable
{
    public Ball(double mass, double restitution, Vector2D velocity, Point2D position)
    {
        super(mass, restitution, velocity, position);
    }

    @Override
    public void applyForce(Vector2D force, double time)
    {
        Vector2D acceleration = Vector2D.scale(force, 1 / getMass());
        Vector2D velocityDelta = Vector2D.scale(acceleration, time);
        setVelocity(Vector2D.add(velocityDelta, getVelocity()));
    }

}
