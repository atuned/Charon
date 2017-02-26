package com.tune.charon;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * Created by Tune on 2017-02-19.
 */
public class Ball extends PhysicalObject implements Movable, Collidable, Rendable
{
    private double radius;
    private Color color;
    private Circle rendition;

    public Ball(double mass, double restitution, Vector2D velocity, Vector2D position)
    {
        super(mass, restitution, velocity, position);
        radius = 10;
        color = Color.WHITE;
        rendition = new Circle(radius, color);
    }

    public Ball(double mass, double restitution, double radius, Vector2D velocity, Vector2D position)
    {
        super(mass, restitution, velocity, position);
        this.radius = radius;
        color = Color.WHITE;
        rendition = new Circle(position.getX(), position.getY(), radius, color);
    }

    @Override
    public void applyForce(Vector2D force, double timeStep)
    {
        Vector2D acceleration = Vector2D.scale(force, 1 / getMass());
        Vector2D velocityDelta = Vector2D.scale(acceleration, timeStep);
        setVelocity(Vector2D.add(velocityDelta, getVelocity()));
    }

    @Override
    public void updatePosition(double timeStep)
    {
        Vector2D positionDelta = Vector2D.scale(getVelocity(), timeStep);
        setPosition(Vector2D.add(positionDelta, getPosition()));
        setRenditionPosition(getPosition());

    }

    private void setRenditionPosition(Vector2D position)
    {
        getRendition().relocate(position.getX(), position.getY());
    }

    @Override
    public Node getRendition()
    {
        return rendition;
    }

    @Override
    public boolean isInside(Vector2D position)
    {
        if (getPosition().distance(position) < safeDistance())
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    public double safeDistance()
    {
        return radius;
    }
}
