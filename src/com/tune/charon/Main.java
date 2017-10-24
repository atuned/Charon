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
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Controller controller = new Controller(200, 1000, 1800, NumericMethod.EULER_FORWARD, 0.1, 9.82);

        primaryStage.setScene(controller.getScene());
        primaryStage.show();
        controller.start();
    }
}

