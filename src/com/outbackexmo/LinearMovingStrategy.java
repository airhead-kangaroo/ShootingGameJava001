package com.outbackexmo;

import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;

public class LinearMovingStrategy implements MovingStrategy{

	public static final int MOVE_90DEGREE = 0; //右へ直進
	public static final int MOVE_180DEGREE = 1;//下へ直進
	public static final int MOVE_270DEGREE = 2;//左へ直進
	public static final int MOVE_90_UP = 3;
	private int frameCount = 0;

	@Override
	public Double move(Double point, int speed, int type) {
		switch(type){
		case MOVE_90DEGREE:
			point.x += speed * TimeInfo.frameTime;
			break;
		case MOVE_180DEGREE:
			point.y += speed * TimeInfo.frameTime;
			break;
		case MOVE_270DEGREE:
			point.x -= speed * TimeInfo.frameTime;
			break;
		case MOVE_90_UP:
			point = move90up(point, speed);
		}
		frameCount++;

		return point;
	}

	private Point2D.Double move90up(Point2D.Double point,int speed){
		if(frameCount < 300){
			point.x += speed * TimeInfo.frameTime;
		}else{
			point.y -= speed * TimeInfo.frameTime;
		}
		return point;
	}

}
