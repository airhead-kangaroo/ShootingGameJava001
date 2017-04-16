package com.outbackexmo;

import java.awt.geom.Point2D.Double;
import java.io.IOException;

public class HeroBulletCharacter extends BulletCharacter implements Bullet {

	private final static String fileName = "img\\tama.png";
	private final int SEVERITY = 10;

	public HeroBulletCharacter() throws IOException {
		super(fileName);
	}

	@Override
	public Bullet getInstance() throws IOException {
			return new HeroBulletCharacter();
	}

	@Override
	public boolean isHit(Double point) {
		if(Math.abs(this.point.x - point.x) < SEVERITY && Math.abs(this.point.y - point.y) < SEVERITY){
				return true;
		}
		return false;
	}






}
