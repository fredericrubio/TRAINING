package fr.home.json.player.core;

import org.eclipse.jface.util.IPropertyChangeListener;

public abstract class JSonPlayer implements IPropertyChangeListener {

	int	period = 1000;;
	String	fileName;
	protected boolean playing = false;

	public abstract boolean start();
	
	public abstract void stop();
	
	public abstract boolean isValid();

	public synchronized void setPlaying(boolean playing) {
			this.playing = playing;
	}

	protected JSonPlayer(String pFileName) {
		fileName = pFileName;
	}
	
	public synchronized boolean isPlaying() {
		return playing;
	}
	
	/**
	 * @param pPeriod : en millisecondes
	 */
	public void setPeriod(int pPeriod) {
	
		period = pPeriod;
	
	}
	
	public String getFileName() {
		return fileName;
	}
	
	public String getShortFileName() {
		return fileName;
	}
}
