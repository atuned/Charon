package com.tune.charon;

import javafx.scene.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tune on 2017-02-18.
 */
public class PhysicsEngine
{
    private final double STEP_SIZE;
    private final NumericMethod numericMethod;
    private Vector2D gravity;
    private List<Movable> objectList = new ArrayList<Movable>();

    public PhysicsEngine(NumericMethod numericMethod, double stepSize, double gravity)
    {
        this.numericMethod = numericMethod;
        this.STEP_SIZE = stepSize;
        this.gravity = new Vector2D(0, - gravity);
    }

    public void stepForward()
    {
        for (int i = 0; i < objectList.size(); i++)
        {
            objectList.get(i).applyForce(gravity, STEP_SIZE);
        }
    }

    public void addObjects(Movable object)
    {
        objectList.add(object);
    }

    public void addObjects(List<Movable> objects)
    {
        objectList.addAll(objects);
    }
}
