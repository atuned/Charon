package com.tune.charon;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tune on 2017-02-18.
 */
public class Main extends Application
{
    private final int NUM_BALLS = 100;
    private final int SCENE_HEIGHT = 1000;
    private final int SCENE_WIDTH = 1800;

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        List<PhysicalObject> objectList = createObjects();

        PhysicsEngine physicsEngine = new PhysicsEngine(NumericMethod.EULER_FORWARD, 0.2, -9.82);
        Renderer renderer = new Renderer(physicsEngine);

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

        Scene scene = new Scene(new Group(rendable), SCENE_WIDTH, SCENE_HEIGHT, Color.BLACK);
        primaryStage.setScene(scene);
        primaryStage.show();

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
}

