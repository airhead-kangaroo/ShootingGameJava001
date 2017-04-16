package com.outbackexmo;


import java.awt.image.BufferStrategy;
import java.util.Timer;

import javax.swing.JFrame;

public class GameFrame extends JFrame {

	public static final int FRAME_WIDTH = 1000;
	public static final int FRAME_HEIGHT = 800;

	public GameFrame() {

		super("MyShooting!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(FRAME_WIDTH,FRAME_HEIGHT);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		setIgnoreRepaint(true);
		createBufferStrategy(2);
		BufferStrategy strategy = getBufferStrategy();
		GameController.getInstance(this);
		Timer t = new Timer();
		t.schedule(new Render(strategy,this), 0,16);
		}

	public static void main(String[] args) {
		new GameFrame();
	}

}
