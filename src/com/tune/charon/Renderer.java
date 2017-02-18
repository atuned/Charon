package com.tune.charon;

import javafx.animation.AnimationTimer;

/**
 * Created by Tune on 2017-02-18.
 */
public class Renderer extends AnimationTimer
{
    private final PhysicsEngine physicsEngine;

    public Renderer(PhysicsEngine physicsEngine)
    {
        this.physicsEngine = physicsEngine;
    }

    @Override
    public void handle(long now)
    {
        physicsEngine.stepForward();
    }
}
