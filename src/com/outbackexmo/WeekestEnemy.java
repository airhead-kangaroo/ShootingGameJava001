package com.outbackexmo;

import java.awt.Graphics2D;
import java.io.IOException;

public class WeekestEnemy extends EnemyCharacter {

	private static final String fileName = "img\\misu.png";

	protected WeekestEnemy(int enemySpeed,int lifePoint) throws IOException {
		super(fileName,enemySpeed,lifePoint);
		movingStrategy = new LinearMovingStrategy();

	}

	public void show(Graphics2D graphics, int strategyVariable){
		if(isInsideForm()){
			point = movingStrategy.move(point, enemySpeed, strategyVariable);
			graphics.drawImage(imageData,(int)point.x, (int)point.y,null);
			magazine.show(graphics);
			frameCount++;
		}else{
			setDead();
		}
	}



	public void shoot(int bulletSpeed, int bulletStrategyVriable){
		Bullet bullet = magazine.getAvaliableBullet();
		if(bullet != null){
			bullet.shoot(point, strategy, bulletStrategyVriable, bulletSpeed);
		}
	}

	@Override
	public void load() throws IOException {
		magazine = new Magazine(bulletCount, new RedNormalBullet());
	}


}
