package com.outbackexmo;

import java.awt.geom.Point2D;

public interface BulletStrategy {

	public Point2D.Double shoot(Point2D.Double point, int speed,int type);
}
