package com.tune.charon;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class Controller
{
    private final Scene scene;
    private final Renderer renderer;
    private final PhysicsEngine physicsEngine;
    private final int SCENE_HEIGHT;
    private final int SCENE_WIDTH;
    private final int NUM_BALLS;
    private double mouseX;
    private double mouseY;

    public Controller(int numberOfBalls, int sceneHeight, int sceneWidth, NumericMethod numericMethod, double stepSize, double gravity)
    {
        NUM_BALLS = numberOfBalls;
        SCENE_HEIGHT = sceneHeight;
        SCENE_WIDTH = sceneWidth;

        List<PhysicalObject> objectList = createObjects();

        physicsEngine = new PhysicsEngine(NumericMethod.EULER_FORWARD, stepSize, gravity);
        renderer = new Renderer(physicsEngine);

        List<Node> rendable = new ArrayList<Node>();
        for (PhysicalObject object : objectList)
        {
            if (object instanceof Movable)
            {
                physicsEngine.addObjects((Movable) object);
            }

            if (object instanceof Rendable)
            {
                rendable.add(((Rendable) object).getRendition());
            }
        }

        scene = new Scene(new Group(rendable), SCENE_WIDTH, SCENE_HEIGHT, Color.BLACK);
        scene.setOnMouseMoved(event -> { mouseX = event.getSceneX(); mouseY = event.getSceneY();});
    }

    public void start()
    {
        renderer.start();
    }

    private List<PhysicalObject> createObjects()
    {
        List<PhysicalObject> objects = new ArrayList<>();

        for (int i = 0; i < NUM_BALLS; i++)
        {
            double radius = 10;
            Vector2D velocity = new Vector2D(Math.random() * 10, Math.random() * 10);
            Vector2D position = new Vector2D(Math.random() * 0.90 * SCENE_WIDTH + radius,
                    Math.random() * 0.90 * SCENE_HEIGHT + radius);
            Ball ball = new Ball(10, 1, radius, velocity, position);
            objects.add(ball);
        }
        return objects;
    }

    public double getMouseX()
    {
        return mouseX;
    }

    public double getMouseY()
    {
        return mouseY;
    }

    public Scene getScene()
    {
        return scene;
    }
}
