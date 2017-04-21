package com.tune.charon;

/**
 * Created by Tune on 2017-04-21.
 */
public class Angle
{
    private double radians;

    public Angle(double radians)
    {
        this.radians = limitRadians(radians);
    }

    private double limitRadians(double radians)
    {
        if (radians <= 2*Math.PI)
        {
            return radians;
        }
        else
        {
            return (2*Math.PI) % radians;
        }
    }

    public double getRadians()
    {
        return radians;
    }

    public void setRadians(double radians)
    {
        this.radians = limitRadians(radians);
    }
}
