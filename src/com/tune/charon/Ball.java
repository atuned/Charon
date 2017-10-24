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

    private void setRenditionPosition(Vector2D position)
    {
        getRendition().relocate(position.getX(), position.getY());
    }

    @Override
    public Vector2D calculateNewVelocity(Vector2D force, double timeStep)
    {
        Vector2D acceleration = Vector2D.scale(force, 1 / getMass());
        Vector2D newVelocity = Vector2D.add(getVelocity(), Vector2D.scale(acceleration, timeStep));
        return newVelocity;
    }

    @Override
    public Vector2D calculateNewPosition(Vector2D newVelocity, double timeStep)
    {
        Vector2D positionDelta = Vector2D.scale(newVelocity, timeStep);
        Vector2D newPosition = Vector2D.add(positionDelta, getPosition());
        return newPosition;
    }

    @Override
    public void setVelocity(Vector2D newVelocity)
    {
        velocity = newVelocity;
    }

    @Override
    public void setPosition(Vector2D newPosition)
    {
        position = newPosition;
        rendition.relocate(position.getX(), position.getY());
    }

    @Override
    public Node getRendition()
    {
        return rendition;
    }

    @Override
    public boolean isInside(Vector2D position)
    {
        if (false)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    public boolean safeDistance(Vector2D position)
    {
        return false;
    }
}
