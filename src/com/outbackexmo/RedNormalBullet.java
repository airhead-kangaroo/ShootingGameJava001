package com.outbackexmo;

import java.io.IOException;

public class RedNormalBullet extends EnemyBulletCharacter implements Bullet {

	private static final String fileName = "img\\tekitama.png";

	public RedNormalBullet() throws IOException {
		super(fileName);

	}

	@Override
	public Bullet getInstance() throws IOException {
		return new RedNormalBullet();
	}




}
