package com.outbackexmo;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.util.TimerTask;

import javax.swing.JFrame;

public class Render extends TimerTask {

	private BufferStrategy strategy;
	private JFrame frame;

	public Render(BufferStrategy strategy, JFrame frame) {
		this.strategy = strategy;
		this.frame = frame;
	}

	@Override
	public void run() {
		Graphics2D graphics = viewTask();
		timeCalc();
		GameController.getInstance(frame).gameScenario(graphics);
		graphics.dispose();
		strategy.show();
	}

	private Graphics2D viewTask(){
		Graphics2D graphics = (Graphics2D)strategy.getDrawGraphics();
		graphics.setBackground(Color.BLACK);
		graphics.clearRect(0, 0, frame.getWidth(), frame.getHeight());
		return graphics;
	}

	private void timeCalc(){
		long timeMills = System.currentTimeMillis();
		TimeInfo.currentTime = timeMills - TimeInfo.START_TIME;
		TimeInfo.frameTime = (timeMills - TimeInfo.lastCycleTime) * 0.001;
		TimeInfo.lastCycleTime = timeMills;
	}

}
