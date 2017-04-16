package com.outbackexmo;

import java.awt.geom.Point2D;

public interface MovingStrategy {
	public Point2D.Double move(Point2D.Double point, int speed,int type);
}
