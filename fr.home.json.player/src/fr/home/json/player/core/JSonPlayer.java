package fr.home.json.player.core;

public abstract class JSonPlayer {

	int	period = 1000;;
	String	fileName;
	boolean playing = false;
	
	protected JSonPlayer(String pFileName) {
		fileName = pFileName;
	}
	
	public abstract boolean start();
	
	public abstract void stop();
	
	public abstract boolean isValid();

	public boolean isPlaying() {
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
