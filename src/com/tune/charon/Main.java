package com.tune.charon;

import javafx.application.Application;
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
    private final int NUM = 4;
    private final List<Node> objects = new ArrayList<Node>();

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
            objects.add(new Circle(radius + Math.random() * (sceneWidth - radius),
                                   radius + Math.random() * (sceneHeight - radius), radius, Color.WHITE));
        }

        PhysicsEngine physicsEngine = new PhysicsEngine(10);
        physicsEngine.addObjects(objects);

        Renderer renderer = new Renderer(physicsEngine);

        final Scene scene = new Scene(new Group(objects), sceneWidth, sceneHeight, Color.BLACK);
        primaryStage.setScene(scene);
        primaryStage.show();

        renderer.start();
    }
}

