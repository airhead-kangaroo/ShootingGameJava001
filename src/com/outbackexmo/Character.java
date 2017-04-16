package com.outbackexmo;

import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class Character {

	protected Point2D.Double point;
	protected BufferedImage imageData;

	public Character(String fileName) throws IOException {
		point = new Point2D.Double();
		imageData = ImageIO.read(new File(fileName));
	}
}
