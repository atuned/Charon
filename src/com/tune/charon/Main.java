package com.tune.charon;

import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tune on 2017-02-18.
 */
public class Main extends Application
{
    private final int NUM = 10;
    private final List<PhysicalObject> objects = new ArrayList<PhysicalObject>();

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        int sceneHeight = 800;
        int sceneWidth = 1000;
        for (int i = 0; i < NUM; i++)
        {
            double radius = 10;
            Vector2D velocity = new Vector2D(Math.random() * 10, Math.random() * 10);
            Vector2D position = new Vector2D(Math.random() * 0.90 * sceneWidth + radius,
                                            Math.random() * 0.90 * sceneHeight + radius);
            Ball ball = new Ball(10, 1, radius, velocity, position);
            objects.add(ball);
        }

        PhysicsEngine physicsEngine = new PhysicsEngine(NumericMethod.EULER_FORWARD, 0.1, -9.82);
        Renderer renderer = new Renderer(physicsEngine);

        List<Node> rendable = new ArrayList<Node>();
        for (PhysicalObject object : objects)
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

        final Scene scene = new Scene(new Group(rendable), sceneWidth, sceneHeight, Color.BLACK);


        primaryStage.setScene(scene);
        primaryStage.show();

        renderer.start();
    }
}

