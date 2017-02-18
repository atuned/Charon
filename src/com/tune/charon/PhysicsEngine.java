package com.tune.charon;

import javafx.scene.Node;
import javafx.scene.shape.Shape;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tune on 2017-02-18.
 */
public class PhysicsEngine
{
    private final double STEP_SIZE;
    private List<Node> objectList = new ArrayList<Node>();

    public PhysicsEngine(double stepSize)
    {
        this.STEP_SIZE = stepSize;
    }

    public void stepForward()
    {
        for (int i = 0; i < objectList.size(); i++)
        {
            objectList.get(i).setTranslateX(Math.random()*STEP_SIZE);
            objectList.get(i).setTranslateY(Math.random()*STEP_SIZE);
        }
    }

    public void addObjects(Node object)
    {
        objectList.add(object);
    }

    public void addObjects(List<Node> objects)
    {
        objectList.addAll(objects);
    }
}
