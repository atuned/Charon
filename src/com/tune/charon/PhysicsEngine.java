package com.tune.charon;

import javafx.animation.AnimationTimer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tune on 2017-02-18.
 */
public class PhysicsEngine extends AnimationTimer
{
    private final double STEP_SIZE;
    private final NumericMethod numericMethod;
    private final Controller controller;
    private Vector2D gravity;
    private List<Movable> objectList = new ArrayList<>();

    public PhysicsEngine(NumericMethod numericMethod, double stepSize, double gravity, Controller controller)
    {
        this.numericMethod = numericMethod;
        this.STEP_SIZE = stepSize;
        this.gravity = new Vector2D(0, gravity);
        this.controller = controller;
    }

    @Override
    public void handle(long now)
    {
        stepForward();
    }

    private void stepForward()
    {
        Vector2D mousePositionForThisStep = new Vector2D(controller.getMouseX(), controller.getMouseY());

        List<Vector2D> Forces = new ArrayList<>();
        List<Vector2D> NewVelocities = new ArrayList<>();
        List<Vector2D> NewPositions = new ArrayList<>();
        for (Movable object : objectList)
        {
            //Determine all forces
            Vector2D forceSum = Vector2D.add(gravity, calculateMouseForce(object, mousePositionForThisStep));

            //Calculate new velocities
            Vector2D newVelocity = object.calculateNewVelocity(forceSum, STEP_SIZE);

            //Calculate new positions
            Vector2D newPosition = object.calculateNewPosition(newVelocity, STEP_SIZE);

            //Save calculations
            Forces.add(forceSum);
            //TODO Maybe not needed to save velocities?
            NewVelocities.add(newVelocity);
            NewPositions.add(newPosition);
        }

        //Check for collisions
        //Resolve collisions
        for (int i = 0; i < objectList.size(); i++)
        {
            //Update velocities
            objectList.get(i).setVelocity(NewVelocities.get(i));
            //Update positions
            objectList.get(i).setPosition(NewPositions.get(i));
        }
    }

    private void checkForCollision()
    {

    }

    private Vector2D calculateMouseForce(Movable object, Vector2D mousePosition)
    {
        Vector2D vector = Vector2D.subtract(object.getPosition(), mousePosition);
        vector.scale(-1000 / (vector.length() * vector.length()));
        return vector;
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
