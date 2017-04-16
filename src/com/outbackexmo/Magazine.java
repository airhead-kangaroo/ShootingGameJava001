package com.outbackexmo;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.io.IOException;

public class Magazine {

	private Bullet[] bullet;
	private int bulletNum;

	public Magazine(int bulletNum, Bullet bullet){
		this.bulletNum = bulletNum;
		this.bullet = new Bullet[this.bulletNum];
		for(int i=0;i<bulletNum;i++){
			try {
				this.bullet[i] = bullet.getInstance();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public Bullet getAvaliableBullet(){
		for(int i=0;i<bulletNum;i++){
			if(!bullet[i].isShot()){
				return bullet[i];
			}
		}
		return null;
		//throw new NullPointerException();
	}

	public boolean isHit(Point2D.Double point){
		for(int i=0;i<bulletNum;i++){
			if(bullet[i].isShot()){
				if(bullet[i].isHit(point)){
					return true;
				}
			}
		}
		return false;
	}

	public void show(Graphics2D graphics){
		for(int i=0;i<bulletNum;i++){
			if(bullet[i].isShot()){
				bullet[i].show(graphics);
			}
		}
	}

	public void shoot(Point2D.Double point, BulletStrategy strategy, int strategyVariable, int speed){
		getAvaliableBullet().shoot(point, strategy, strategyVariable, speed);
	}

}
