package com.outbackexmo;

import java.awt.Graphics2D;

import javax.swing.JFrame;

public class GameController {

	private Stage1GameController stage1;
	private static GameController singletonController;
	int stageCount;


	private GameController(JFrame frame){

		stageCount = 1;
		stage1 = Stage1GameController.getInstance(frame);

	}


	public static GameController getInstance(JFrame frame){
		if(singletonController == null){
			singletonController = new GameController(frame);
		}
		return singletonController;
	}


	public void gameScenario(Graphics2D graphics){
		switch(stageCount){
		case 1:
			stage1.gameScenario(graphics);
		}
	}
}
