package com.tune.charon;

/**
 * Created by Tune on 2017-02-26.
 */
public interface Collidable
{
    boolean isInside(Vector2D position);
    double safeDistance();
}
