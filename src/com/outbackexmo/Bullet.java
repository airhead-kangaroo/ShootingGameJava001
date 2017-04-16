package com.outbackexmo;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.io.IOException;

public interface Bullet {

public void shoot(Point2D.Double point, BulletStrategy strategy, int strategyVariable, int speed);

public boolean isShot();


public int getBulletPointx();

public int getBulletPointy();

public void show(Graphics2D graphics);

public Bullet getInstance() throws IOException;

public boolean isHit(Point2D.Double point);



}
