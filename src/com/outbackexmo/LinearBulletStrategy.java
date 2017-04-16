package com.outbackexmo;

import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;

public class LinearBulletStrategy implements BulletStrategy {

	public static final int DEGREE_0 = 0;
	public static final int DEGREE_15 = 1;
	public static final int DEGREE_30 = 2;
	public static final int DEGREE_45 = 3;
	public static final int DEGREE_60 = 4;
	public static final int DEGREE_75 = 5;
	public static final int DEGREE_90 = 6;
	public static final int DEGREE_105 = 7;
	public static final int DEGREE_120 = 8;
	public static final int DEGREE_135 = 9;
	public static final int DEGREE_150 = 10;
	public static final int DEGREE_165 = 11;
	public static final int DEGREE_180 = 12;
	public static final int DEGREE_195 = 13;
	public static final int DEGREE_210 = 14;
	public static final int DEGREE_225 = 15;
	public static final int DEGREE_240 = 16;
	public static final int DEGREE_255 = 17;
	public static final int DEGREE_270 = 18;
	public static final int DEGREE_285 = 19;
	public static final int DEGREE_300 = 20;
	public static final int DEGREE_315 = 21;
	public static final int DEGREE_330 = 22;
	public static final int DEGREE_345 = 23;
	private Point2D.Double point;
	private int speed;

	@Override
	public Double shoot(Double point,int speed, int type) {
		this.point = point;
		this.speed = speed;
		switch(type){
		case DEGREE_0:
			degree_0();
			break;
		case DEGREE_15:
			degree_15();
			break;
		case DEGREE_30:
			degree_30();
			break;
		case DEGREE_45:
			degree_45();
			break;
		case DEGREE_60:
			degree_60();
			break;
		case DEGREE_75:
			degree_75();
			break;
		case DEGREE_90:
			degree_90();
			break;
		case DEGREE_105:
			degree_105();
			break;
		case DEGREE_120:
			degree_120();
			break;
		case DEGREE_135:
			degree_135();
			break;
		case DEGREE_150:
			degree_150();
			break;
		case DEGREE_165:
			degree_165();
			break;
		case DEGREE_180:
			degree_180();
			break;
		case DEGREE_195:
			degree_195();
			break;
		case DEGREE_210:
			degree_210();
			break;
		case DEGREE_225:
			degree_225();
			break;
		case DEGREE_240:
			degree_240();
			break;
		case DEGREE_255:
			degree_255();
			break;
		case DEGREE_270:
			degree_270();
			break;
		case DEGREE_285:
			degree_285();
			break;
		case DEGREE_300:
			degree_300();
			break;
		case DEGREE_315:
			degree_315();
			break;
		case DEGREE_330:
			degree_330();
			break;
		case DEGREE_345:
			degree_345();
			break;
		}
		return point;
	}

	private void degree_0(){
		point.y -= speed * TimeInfo.frameTime;
	}

	private void degree_15(){
		point.x += speed * TimeInfo.frameTime * 1/3;
		point.y -= speed * TimeInfo.frameTime;

	}

	private void degree_30(){
		point.x += speed * TimeInfo.frameTime * 2/3;
		point.y -= speed * TimeInfo.frameTime;

	}

	private void degree_45(){
		point.x += speed * TimeInfo.frameTime;
		point.y -= speed * TimeInfo.frameTime;
	}

	private void degree_60(){
		point.x += speed * TimeInfo.frameTime;
		point.y -= speed * TimeInfo.frameTime * 2/3;
	}

	private void degree_75(){
		point.x += speed * TimeInfo.frameTime;
		point.y -= speed * TimeInfo.frameTime * 1/3;
	}

	private void degree_90(){
		point.x += speed * TimeInfo.frameTime;

	}

	private void degree_105(){
		point.x += speed * TimeInfo.frameTime;
		point.y += speed * TimeInfo.frameTime * 1/3;
	}

	private void degree_120(){
		point.x += speed * TimeInfo.frameTime;
		point.y += speed * TimeInfo.frameTime * 2/3;
	}

	private void degree_135(){
		point.x += speed * TimeInfo.frameTime;
		point.y += speed * TimeInfo.frameTime;
	}

	private void degree_150(){
		point.x += speed * TimeInfo.frameTime * 2/3;
		point.y += speed * TimeInfo.frameTime;
	}

	private void degree_165(){
		point.x += speed * TimeInfo.frameTime * 1/3;
		point.y += speed * TimeInfo.frameTime;
	}

	private void degree_180(){
		point.y += speed * TimeInfo.frameTime;
	}

	private void degree_195(){
		point.x -= speed * TimeInfo.frameTime * 1/3;
		point.y += speed * TimeInfo.frameTime;
	}

	private void degree_210(){
		point.x -= speed * TimeInfo.frameTime * 2/3;
		point.y += speed * TimeInfo.frameTime;
	}

	private void degree_225(){
		point.x -= speed * TimeInfo.frameTime;
		point.y += speed * TimeInfo.frameTime;
	}

	private void degree_240(){
		point.x -= speed * TimeInfo.frameTime;
		point.y += speed * TimeInfo.frameTime * 1/3;

	}

	private void degree_255(){
		point.x -= speed * TimeInfo.frameTime;
		point.y += speed * TimeInfo.frameTime * 2/3;
	}

	private void degree_270(){
		point.x -= speed * TimeInfo.frameTime;
	}

	private void degree_285(){
		point.x -= speed * TimeInfo.frameTime;
		point.y -= speed * TimeInfo.frameTime * 1/3;

	}

	private void degree_300(){
		point.x -= speed * TimeInfo.frameTime;
		point.y -= speed * TimeInfo.frameTime * 2/3;
	}

	private void degree_315(){
		point.x -= speed * TimeInfo.frameTime;
		point.y -= speed * TimeInfo.frameTime;
	}

	private void degree_330(){
		point.x -= speed * TimeInfo.frameTime * 2/3;
		point.y -= speed * TimeInfo.frameTime;
	}

	private void degree_345(){
		point.x -= speed * TimeInfo.frameTime * 1/3;
		point.y -= speed * TimeInfo.frameTime;
	}

}
