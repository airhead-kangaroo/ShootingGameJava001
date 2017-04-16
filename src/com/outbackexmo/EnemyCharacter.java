package com.outbackexmo;

import java.awt.geom.Point2D;
import java.io.IOException;
import java.util.ArrayList;
import java.util.WeakHashMap;

public abstract class EnemyCharacter extends Character {

	protected boolean isAlive;
	protected boolean isActivated;
	protected int lifePoint;
	protected int bulletCount;
	protected int frameCount;
	protected int enemySpeed;
	protected Magazine magazine;
	protected BulletStrategy strategy;
	protected ArrayList<BulletStrategy> strategyList;
	protected WeakHashMap<String, BulletStrategy> strategyHashMap;
	protected MovingStrategy movingStrategy;

	public EnemyCharacter(String fileName, int enemySpeed,int lifePoint) throws IOException {
		super(fileName);
		this.enemySpeed = enemySpeed;
		this.lifePoint = lifePoint;
		bulletCount = 0;
		isAlive = true;
		frameCount = 0;

	}

	public boolean hasHitHero(Point2D.Double point){
		return magazine.isHit(point);
	}


	public boolean getIsAlive(){
		return isAlive;
	}

	public boolean getIsActivated(){
		return isActivated;
	}

	public void setDead(){
		isAlive = false;
	}

	public void setDamage(){
		lifePoint--;
	}

	public int getLifePoint(){
		return lifePoint;
	}

	public EnemyCharacter setPosition(double x, double y){
		point.x = x;
		point.y = y;
		return this;
	}

	public EnemyCharacter setBulletCount(int bulletCount){
		this.bulletCount = bulletCount;
		return this;
	}


	public EnemyCharacter setBulletStrategy(BulletStrategy strategy){
		this.strategy = strategy;
		return this;
	}

	public EnemyCharacter setBulletStrategy(BulletStrategy... strategy){
		if(strategyList == null){
			strategyList = new ArrayList<>();
		}
		for(int i=0;i<strategy.length;i++){
			strategyList.add(strategy[i]);
		}
		return this;
	}

	public EnemyCharacter setBulletStrategy(String strategyName, BulletStrategy strategy){
		if(strategyHashMap == null){
			strategyHashMap = new WeakHashMap<>();
		}
		strategyHashMap.put(strategyName, strategy);
		return this;
	}

	public Point2D.Double getPoint(){
		return point;
	}

	public EnemyCharacter create() throws NotEnoughPropertyException{
		if(strategy == null && strategyList == null && strategyHashMap == null){
			throw new NotEnoughPropertyException("bulletStrategyが設定されていません");
		}

		if(point == null){
			throw new NotEnoughPropertyException("座標が設定されていません");
		}
		if(bulletCount == 0){
			throw new NotEnoughPropertyException("弾数が設定されていません");
		}

		return this;
	}

	public boolean isInsideForm(){
		if(point.x > 0 && point.x < GameFrame.FRAME_WIDTH && point.y > 0 && point.y < GameFrame.FRAME_HEIGHT){
			return true;
		}
		else{
			return false;
		}
	}

	public void changeBulletStrategy(BulletStrategy strategy){
		this.strategy = strategy;
	}

	public abstract void load() throws IOException;
}
