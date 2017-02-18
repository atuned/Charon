package com.tune.charon;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * Created by Tune on 2017-02-18.
 */
public class Main extends Application
{
    private final int NUM = 2;
    private final Circle[] nodes = new Circle[NUM];
    private final double RADIUS = 10;
    private final int sceneWidth = 1000;
    private final int sceneHeight = 800;

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        for (int i = 0; i < NUM; i++)
        {
            nodes[i] = new Circle(RADIUS + Math.random() * (sceneWidth - RADIUS),
                                  RADIUS + Math.random() * (sceneHeight - RADIUS), RADIUS, Color.BLUE);
        }
        final Scene scene = new Scene(new Group(nodes), sceneWidth, sceneHeight, Color.BLACK);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

