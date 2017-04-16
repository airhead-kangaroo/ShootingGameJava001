package com.outbackexmo;

import java.awt.geom.Point2D.Double;
import java.io.IOException;

public abstract class EnemyBulletCharacter extends BulletCharacter {

	public final int SEVERITY = 5;

	public EnemyBulletCharacter(String fileName) throws IOException {
		super(fileName);
	}

	public boolean isHit(Double point) {
		if(Math.abs(this.point.x - point.x) < SEVERITY && Math.abs(this.point.y - point.y) < SEVERITY){
			return true;
		}

		return false;
	}



}
