package com.outbackexmo;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.geom.Point2D;
import java.io.IOException;

public class HeroCharacter extends Character {

	private static final String IMAGE_FILE_NAME = "img\\alice.png";
	private static HeroCharacter singletonHeroCharacter;
	private Magazine magazine;
	private BulletStrategy strategy;
	private final int IMAGE_WIDTH;
	private final int IMAGE_HEIGHT;
	private final int BULLET_COUNT = 100;
	private final int SPEED = 500;
	private final int BULLET_SPEED = 500;
	private boolean keyUp = false;
	private boolean keyDown = false;
	private boolean keyLeft = false;
	private boolean keyRight = false;
	private boolean keySpace = false;
	private int frameCount = 0;


	public HeroCharacter() throws IOException{
		super(IMAGE_FILE_NAME);
		magazine = new Magazine(BULLET_COUNT,new HeroBulletCharacter());
		point.x = 500;
		point.y = 700;
		IMAGE_WIDTH = imageData.getWidth();
		IMAGE_HEIGHT = imageData.getHeight();
		strategy = new LinearBulletStrategy();
	}


	public static HeroCharacter getInstance() throws IOException
	{
		if(singletonHeroCharacter == null){
			singletonHeroCharacter = new HeroCharacter();
		}
		return singletonHeroCharacter;
	}


	public void show(Graphics2D graphics){
		move();
		graphics.drawImage(imageData,(int)point.x, (int)point.y,null);
		magazine.show(graphics);
		frameCount++;
	}

	private void shoot(){
		magazine.getAvaliableBullet().shoot(point, strategy, LinearBulletStrategy.DEGREE_0, BULLET_SPEED);
	}

	public void keyPressMove(KeyEvent e){
	switch(e.getKeyCode()){
		case KeyEvent.VK_UP:
			keyUp = true;
			break;
		case KeyEvent.VK_DOWN:
			keyDown = true;
			break;
		case KeyEvent.VK_RIGHT:
			keyRight = true;
			break;
		case KeyEvent.VK_LEFT:
			keyLeft = true;
			break;
		case KeyEvent.VK_SPACE:
			keySpace = true;
			break;
		}
	}

	public void keyReleaseMove(KeyEvent e){
	switch(e.getKeyCode()){
		case KeyEvent.VK_UP:
			keyUp = false;
			break;
		case KeyEvent.VK_DOWN:
			keyDown = false;
			break;
		case KeyEvent.VK_RIGHT:
			keyRight = false;
			break;
		case KeyEvent.VK_LEFT:
			keyLeft = false;
			break;
		case KeyEvent.VK_SPACE:
			keySpace = false;
			break;
		}
	}

	public void move(){
			if(keyUp){
				if(point.y > IMAGE_HEIGHT / 2){
					point.y -= SPEED * TimeInfo.frameTime;
				}
			}
			if(keyDown){
				if(point.y < (GameFrame.FRAME_HEIGHT - IMAGE_HEIGHT)){
					point.y += SPEED * TimeInfo.frameTime;
				}
			}
			if(keyRight){
				if(point.x < (GameFrame.FRAME_WIDTH - IMAGE_WIDTH)){
					point.x += SPEED * TimeInfo.frameTime;
				}
			}
			if(keyLeft){
				if(point.x > IMAGE_WIDTH / 2){
					point.x -= SPEED * TimeInfo.frameTime;
				}
			}
			if(keySpace && frameCount % 3 == 0){
				shoot();
			}


		}

	public Point2D.Double getPoint(){
		return point;
	}

	public boolean hasHitEnemy(Point2D.Double point){
		return magazine.isHit(point);
	}

//	public int[][] getBulletPoint(){
//		int[][] position = new int[BULLET_COUNT][2];
//		for(int i=0;i<BULLET_COUNT;i++){
//			if(bullets[i].isVisible){
//				position[i][0] = bullets[i].getBulletPointx();
//				position[i][1] = bullets[i].getBulletPointy();
//			}else{
//				position[i][0] = -1;
//				position[i][1] = -1;
//			}
//		}
//		return position;
//
//	}



}
