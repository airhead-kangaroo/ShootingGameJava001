package com.outbackexmo;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Stage1GameController implements KeyListener{

	private static Stage1GameController singletonStage1;
	private HeroCharacter heroCharacter;
	private WeekestEnemy enemy;
	private WeekestEnemy[] enemyLeft;
	private WeekestEnemy[] enemyRight;
	private Sound sound;
	private final int ENEMY_COUNT = 5;

	private Stage1GameController(JFrame frame){
		frame.addKeyListener(this);
		sound = new Sound();
		try{
			heroCharacter = HeroCharacter.getInstance();
			enemyLeft = new WeekestEnemy[ENEMY_COUNT * 2];
			enemyRight = new WeekestEnemy[ENEMY_COUNT * 2];
			for(int i=0;i<ENEMY_COUNT;i++){
				enemyLeft[i] = (WeekestEnemy)new WeekestEnemy(100, 10).setPosition(100, 100 + 100 * i).setBulletStrategy(new LinearBulletStrategy()).setBulletCount(100).create();
				enemyRight[i] = (WeekestEnemy)new WeekestEnemy(100, 10).setPosition(900, 100 + 100 * i).setBulletStrategy(new LinearBulletStrategy()).setBulletCount(100).create();
				enemyLeft[i].load();
				enemyRight[i].load();
			}
			for(int i=5;i<ENEMY_COUNT * 2;i++){
				enemyLeft[i] = (WeekestEnemy)new WeekestEnemy(100, 10).setPosition(100, 100 + 100 * (i -5)).setBulletStrategy(new LinearBulletStrategy()).setBulletCount(100).create();
				enemyRight[i] = (WeekestEnemy)new WeekestEnemy(100, 10).setPosition(900, 100 + 100 * (i - 5)).setBulletStrategy(new LinearBulletStrategy()).setBulletCount(100).create();
				enemyLeft[i].load();
				enemyRight[i].load();
			}
			enemy = (WeekestEnemy)new WeekestEnemy(10, 100).setPosition(400, 200).setBulletStrategy(new RandomBulletStrategy()).setBulletCount(300).create();
			enemy.load();

		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(frame,"画像の読み込みに失敗しました","エラー",JOptionPane.ERROR_MESSAGE);
		}

	}

	public static Stage1GameController getInstance(JFrame frame){
		if(singletonStage1 == null){
			singletonStage1 = new Stage1GameController(frame);
		}
		return singletonStage1;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		heroCharacter.keyPressMove(e);

	}

	@Override
	public void keyReleased(KeyEvent e) {
		heroCharacter.keyReleaseMove(e);
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	public void isHeroAlive(boolean isHit){
		if(isHit){
			System.out.println("dead");
		}
	}

	public void enemyRoutine(WeekestEnemy thisenemy, Graphics2D graphics){
		isHeroAlive(thisenemy.hasHitHero(heroCharacter.getPoint()));
		if(heroCharacter.hasHitEnemy(thisenemy.getPoint())){
			thisenemy.setDamage();
			if(thisenemy.getLifePoint() <= 0){
				thisenemy.setDead();
			}
		}
	}

//	private boolean isBossHit(){
//		int[] enemyPosition = bossCharacter.getPoint();
//		int[][] bulletPosition = heroCharacter.getBulletPoint();
//
//		for(int i=0;i<bulletPosition.length;i++){
//			if(Math.abs(enemyPosition[0] - bulletPosition[i][0]) < severity && Math.abs(enemyPosition[1] - bulletPosition[i][1]) < severity){
//				return true;
//			}
//		}
//		return false;
//	}
//
//	private boolean isEnemyHit(int j){
//			if(zakoCharacter[j].getIsActivated() && zakoCharacter[j].getIsAlive()){
//				int[] zakoPosition = zakoCharacter[j].getPoint();
//				int [][]bulletPosition = heroCharacter.getBulletPoint();
//
//				for(int i=0;i<bulletPosition.length;i++){
//					if(Math.abs(zakoPosition[0] - bulletPosition[i][0]) < severity && Math.abs(zakoPosition[1] - bulletPosition[i][1]) < severity){
//						return true;
//					}
//				}
//			}
//		return false;
//	}
//
//	private boolean isHeroHit(){
//		if(bossBulletHit() || enemyBulletHit()){
//			return true;
//		}
//		return false;
//	}
//
//
//	private boolean bossBulletHit(){
//		int[] heroPosition = heroCharacter.getPoint();
//		int [][]bulletPosition = bossCharacter.getBulletPoint();
//
//		for(int i=0;i<bulletPosition.length;i++){
//			if(Math.abs(heroPosition[0] - bulletPosition[i][0]) < heroHitRange && Math.abs(heroPosition[1] - bulletPosition[i][1]) < heroHitRange){
//				return true;
//			}
//		}
//		return false;
//	}
//
//	private boolean enemyBulletHit(){
//		for(int j=0;j<10;j++){
//			if(zakoCharacter[j].getIsActivated() && zakoCharacter[j].getIsAlive()){
//				int[] heroPosition = heroCharacter.getPoint();
//				int [][]bulletPosition = zakoCharacter[j].getBulletPoint();
//
//				for(int i=0;i<bulletPosition.length;i++){
//					if(Math.abs(heroPosition[0] - bulletPosition[i][0]) < heroHitRange && Math.abs(heroPosition[1] - bulletPosition[i][1]) < heroHitRange){
//						return true;
//					}
//				}
//			}
//		}
//		return false;
//	}
//
//	private void showZakoCharacter(int showtime,int zakonumber,Graphics2D graphics){
//		if(TimeInfo.currentTime >= showtime * 1000 && zakoCharacter[zakonumber].getIsAlive()){
//			zakoCharacter[zakonumber].show(graphics);
//			if(TimeInfo.currentTime % 10 == 0){
//				zakoCharacter[zakonumber].shoot();
//				if(isEnemyHit(zakonumber)){
//					zakoCharacter[zakonumber].setDamage();
//					if(zakoCharacter[zakonumber].getLifePoint() >= 0){
//						zakoCharacter[zakonumber].setDead();
//					}
//				}
//			}
//		}
//	}



	public void gameScenario(Graphics2D graphics){
		heroCharacter.show(graphics);
		sound.playNormalTheme();
		if(enemy.getIsAlive()){
			enemy.show(graphics, LinearMovingStrategy.MOVE_90DEGREE);
			enemyRoutine(enemy, graphics);
			if(TimeInfo.currentTime % 2 == 0){
				enemy.shoot(500, 0);
			}
		}

		for(int i=0;i<ENEMY_COUNT;i++){
			if(TimeInfo.currentTime > (1000 + i * 2000) && enemyLeft[i].getIsAlive()){
				enemyLeft[i].show(graphics, LinearMovingStrategy.MOVE_90_UP);
				enemyRoutine(enemyLeft[i], graphics);
				if(TimeInfo.currentTime % 5 == 0){
					enemyLeft[i].shoot(300, LinearBulletStrategy.DEGREE_150);
					enemyLeft[i].shoot(300, LinearBulletStrategy.DEGREE_165);
					enemyLeft[i].shoot(300, LinearBulletStrategy.DEGREE_180);
				}
			}
			if(TimeInfo.currentTime > (1000 + i * 2000) && enemyRight[i].getIsAlive()){
				enemyRight[i].show(graphics, LinearMovingStrategy.MOVE_270DEGREE);
				enemyRoutine(enemyRight[i], graphics);
				if(TimeInfo.currentTime % 5 == 0){
					enemyRight[i].shoot(300, LinearBulletStrategy.DEGREE_180);
					enemyRight[i].shoot(300, LinearBulletStrategy.DEGREE_195);
					enemyRight[i].shoot(300, LinearBulletStrategy.DEGREE_210);
				}
			}
		}
		for(int i=5;i<ENEMY_COUNT * 2;i++){
			if(TimeInfo.currentTime > (i * 2000 + 1000) && enemyLeft[i].getIsAlive()){
				enemyLeft[i].show(graphics, LinearMovingStrategy.MOVE_90DEGREE);
				enemyRoutine(enemyLeft[i], graphics);
				if(TimeInfo.currentTime % 5 == 0){
					enemyLeft[i].shoot(300, LinearBulletStrategy.DEGREE_150);
					enemyLeft[i].shoot(300, LinearBulletStrategy.DEGREE_165);
					enemyLeft[i].shoot(300, LinearBulletStrategy.DEGREE_180);
				}
			}
			if(TimeInfo.currentTime > (i * 2000 + 1000) && enemyRight[i].getIsAlive()){
				enemyRight[i].show(graphics, LinearMovingStrategy.MOVE_270DEGREE);
				enemyRoutine(enemyRight[i], graphics);
				if(TimeInfo.currentTime % 5 == 0){
					enemyRight[i].shoot(300, LinearBulletStrategy.DEGREE_180);
					enemyRight[i].shoot(300, LinearBulletStrategy.DEGREE_195);
					enemyRight[i].shoot(300, LinearBulletStrategy.DEGREE_210);
				}
			}
		}





//		if(TimeInfo.currentTime > 1000 && enemyLeft[0].getIsAlive()){
//			enemyRoutine(enemyLeft[0], graphics);
//			if(TimeInfo.currentTime % 5 == 0){
//				enemyLeft[0].shoot(300, LinearBulletStrategy.DEGREE_150);
//				enemyLeft[0].shoot(300, LinearBulletStrategy.DEGREE_165);
//				enemyLeft[0].shoot(300, LinearBulletStrategy.DEGREE_180);
//			}
//		}
//		if(TimeInfo.currentTime > 1000 && enemyRight[0].getIsAlive()){
//			enemyRoutine(enemyRight[0], graphics);
//			if(TimeInfo.currentTime % 5 == 0){
//				enemyRight[0].shoot(300, LinearBulletStrategy.DEGREE_180);
//				enemyRight[0].shoot(300, LinearBulletStrategy.DEGREE_195);
//				enemyRight[0].shoot(300, LinearBulletStrategy.DEGREE_210);
//			}
//		}
//		if(TimeInfo.currentTime > 1500 && enemyLeft[1].getIsAlive()){
//			enemyRoutine(enemyLeft[1], graphics);
//			if(TimeInfo.currentTime % 5 == 0){
//				enemyLeft[0].shoot(300, LinearBulletStrategy.DEGREE_150);
//				enemyLeft[0].shoot(300, LinearBulletStrategy.DEGREE_165);
//				enemyLeft[0].shoot(300, LinearBulletStrategy.DEGREE_180);
//			}
//		}
//		if(TimeInfo.currentTime > 1500 && enemyRight[1].getIsAlive()){
//			enemyRoutine(enemyRight[1], graphics);
//			if(TimeInfo.currentTime % 5 == 0){
//				enemyRight[1].shoot(300, LinearBulletStrategy.DEGREE_180);
//				enemyRight[1].shoot(300, LinearBulletStrategy.DEGREE_195);
//				enemyRight[1].shoot(300, LinearBulletStrategy.DEGREE_210);
//			}
//		}
//		if(TimeInfo.currentTime > 2000 && enemyLeft[2].getIsAlive()){
//			enemyRoutine(enemyLeft[2], graphics);
//			if(TimeInfo.currentTime % 5 == 0){
//				enemyLeft[2].shoot(300, LinearBulletStrategy.DEGREE_150);
//				enemyLeft[2].shoot(300, LinearBulletStrategy.DEGREE_165);
//				enemyLeft[2].shoot(300, LinearBulletStrategy.DEGREE_180);
//			}
//		}
//		if(TimeInfo.currentTime > 2000 && enemyRight[2].getIsAlive()){
//			enemyRoutine(enemyRight[2], graphics);
//			if(TimeInfo.currentTime % 5 == 0){
//				enemyRight[2].shoot(300, LinearBulletStrategy.DEGREE_180);
//				enemyRight[2].shoot(300, LinearBulletStrategy.DEGREE_195);
//				enemyRight[2].shoot(300, LinearBulletStrategy.DEGREE_210);
//			}
//		}
//		if(TimeInfo.currentTime > 1500 && enemyLeft[0].getIsAlive()){
//			enemyRoutine(enemyLeft[1], graphics);
//			if(TimeInfo.currentTime % 5 == 0){
//				enemyLeft[0].shoot(300, LinearBulletStrategy.DEGREE_150);
//				enemyLeft[0].shoot(300, LinearBulletStrategy.DEGREE_165);
//				enemyLeft[0].shoot(300, LinearBulletStrategy.DEGREE_180);
//			}
//		}
//		if(TimeInfo.currentTime > 1500 && enemyRight[0].getIsAlive()){
//			enemyRoutine(enemyRight[1], graphics);
//			if(TimeInfo.currentTime % 5 == 0){
//				enemyRight[0].shoot(300, LinearBulletStrategy.DEGREE_180);
//				enemyRight[0].shoot(300, LinearBulletStrategy.DEGREE_195);
//				enemyRight[0].shoot(300, LinearBulletStrategy.DEGREE_210);
//			}
//		}
//		if(TimeInfo.currentTime > 2000 && enemyLeft[0].getIsAlive()){
//			enemyRoutine(enemyLeft[2], graphics);
//			if(TimeInfo.currentTime % 5 == 0){
//				enemyLeft[0].shoot(300, LinearBulletStrategy.DEGREE_150);
//				enemyLeft[0].shoot(300, LinearBulletStrategy.DEGREE_165);
//				enemyLeft[0].shoot(300, LinearBulletStrategy.DEGREE_180);
//			}
//		}
//		if(TimeInfo.currentTime > 2000 && enemyRight[0].getIsAlive()){
//			enemyRoutine(enemyRight[2], graphics);
//			if(TimeInfo.currentTime % 5 == 0){
//				enemyRight[0].shoot(300, LinearBulletStrategy.DEGREE_180);
//				enemyRight[0].shoot(300, LinearBulletStrategy.DEGREE_195);
//				enemyRight[0].shoot(300, LinearBulletStrategy.DEGREE_210);
//			}
//		}




	}

}
