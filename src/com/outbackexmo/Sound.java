package com.outbackexmo;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sound {

	private Clip normalTheme;
	private Clip bossTheme;
	private String normalThemeFile = "sound\\hozuki.wav";
	private String bossThemeFile = "sound\\yomayako.wav";


	public Sound(){
		try {
			AudioInputStream aim1 = AudioSystem.getAudioInputStream(new File(normalThemeFile));
			AudioInputStream aim2 = AudioSystem.getAudioInputStream(new File(bossThemeFile));
			DataLine.Info info1 = new DataLine.Info(Clip.class, aim1.getFormat());
			DataLine.Info info2 = new DataLine.Info(Clip.class, aim2.getFormat());
			normalTheme = (Clip)AudioSystem.getLine(info1);
			bossTheme = (Clip)AudioSystem.getLine(info2);
			normalTheme.open(aim1);
			bossTheme.open(aim2);
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			e.printStackTrace();
		}

	}

	public void playNormalTheme(){
		if(!normalTheme.isRunning() && !bossTheme.isRunning()){
			normalTheme.setFramePosition(0);
			normalTheme.start();
		}
	}

	public void playBossTheme(){
		if(!bossTheme.isRunning()){
		bossTheme.setFramePosition(0);
		bossTheme.start();
		}
	}

	public void stopNormalTheme(){
		if(normalTheme.isRunning()){
			normalTheme.stop();
		}
	}

}
