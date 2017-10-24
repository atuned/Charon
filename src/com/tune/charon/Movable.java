package com.tune.charon;

/**
 * Created by Tune on 2017-02-23.
 */
public interface Movable
{
    Vector2D calculateNewVelocity(Vector2D force, double timeStep);

    Vector2D calculateNewPosition(Vector2D newVelocity, double timeStep);

    Vector2D getPosition();

    Vector2D getVelocity();

    void setVelocity(Vector2D newVelocity);

    void setPosition(Vector2D newPosition);


}
