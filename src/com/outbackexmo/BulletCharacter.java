package com.outbackexmo;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.io.IOException;

public abstract class BulletCharacter extends Character {

	protected boolean isVisible;
	protected int speed;
	protected BulletStrategy strategy;
	protected int strategyVariable;

	public BulletCharacter(String fileName) throws IOException {
		super(fileName);
		isVisible = false;

	}

	public void shoot(Point2D.Double point, BulletStrategy strategy, int strategyVariable, int speed){
		this.point.x = point.x;
		this.point.y = point.y;
		this.strategy = strategy;
		this.strategyVariable = strategyVariable;
		this.speed = speed;
		isVisible = true;
	}

	public boolean isShot(){
		return isVisible;
	}

	public int getBulletPointx(){
		return (int)point.x;
	}

	public int getBulletPointy(){
		return (int)point.y;
	}

	protected boolean isInnerArea(){
		if(point.x > 0 && point.x < GameFrame.FRAME_WIDTH && point.y >0 && point.y < GameFrame.FRAME_HEIGHT){
			return true;
		}
		return false;
	}

	public void show(Graphics2D graphics) {
		point = strategy.shoot(point,speed,strategyVariable);
		if(isInnerArea()){
			graphics.drawImage(imageData,(int)point.x, (int)point.y,null);
		}else{
			isVisible = false;
		}
	}


}
