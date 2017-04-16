package com.outbackexmo;

import java.awt.geom.Point2D.Double;
import java.util.Random;

public class RandomBulletStrategy implements BulletStrategy {

	private int direction;
	private int devitation_x;
	private int devitation_y;
	private boolean setFlag = true;

	@Override
	public Double shoot(Double point, int speed, int type) {
		if(setFlag){
			direction = new Random().nextInt(2);
			devitation_x = new Random().nextInt(5) + 1;
			devitation_y = new Random().nextInt(5) + 1;
			setFlag = false;
		}
		switch(direction){
			case 0:
				point.x += speed * TimeInfo.frameTime / devitation_x;
				point.y += speed * TimeInfo.frameTime / devitation_y;
				break;
			case 1:
				point.x -= speed * TimeInfo.frameTime / devitation_x;
				point.y += speed * TimeInfo.frameTime / devitation_y;
				break;
		}
		return point;
	}

}
