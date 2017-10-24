package com.tune.charon;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Created by Tune on 2017-02-26.
 */
public class StraightBorder extends PhysicalObject implements Collidable, Rendable
{
    // Rotation of 0 is a horizontal border with inside downwards.
    private final Angle rotation;
    private final Rectangle rendition;

    public StraightBorder(double restitution, Vector2D centerPosition, Angle rotation)
    {
        super(1, restitution, new Vector2D(), centerPosition);
        this.rotation = rotation;
        rendition = createRectangle(centerPosition, rotation);
        rendition.setStroke(Color.WHITE);
        rendition.setFill(Color.WHITE);
    }

    private Rectangle createRectangle(Vector2D centerPosition, Angle rotation)
    {
        Rectangle rectangle = new Rectangle(centerPosition.getX(), centerPosition.getY(), 1000, 1);
        rectangle.setRotate(-rotation.getDegrees());
        return rectangle;
    }

    @Override
    public boolean isInside(Vector2D position)
    {
        Angle angle = Vector2D.subtract(position, getPosition()).getAngle();
        return angle.getRadians() > (rotation.getRadians() + Math.PI / 2) || angle.getRadians() < (rotation.getRadians() - Math.PI / 2);
    }

    @Override
    public boolean safeDistance(Vector2D position)
    {
        return false;
    }

    @Override
    public Node getRendition()
    {
        return rendition;
    }
}
