package fr.home.json.player.core;

import java.util.LinkedList;
import java.util.List;

import fr.home.json.player.JSonPlayerActivator;

public class JSonPlayerFactory {

	static JSonPlayerFactory instance;
	List <JSonPlayer>	players;
	
	static {
		instance = new JSonPlayerFactory();
	}
	
	private JSonPlayerFactory() {
		players = new LinkedList<JSonPlayer>();
	}
	
	/**
	 * 
	 * @param pFileName
	 * @param pPeriod
	 * @return
	 */
	static public boolean startNewPlayer(String pFileName, int pPeriod) {
	
		JSonArrayFilePlayer lPlayer = new JSonArrayFilePlayer(pFileName);
		
		if (lPlayer.isValid()) {
			
			instance.players.add(lPlayer);
			
			JSonPlayerActivator.getDefault().getPreferenceStore().addPropertyChangeListener(lPlayer);
			lPlayer.setPeriod(pPeriod);
			lPlayer.start();
			
			return true;
		}
		
		return false;
	}
	
	static public void setPeriod(int pPeriod) {
		
		for (JSonPlayer lPlayer : instance.players) {
			lPlayer.setPeriod(pPeriod);
		}
	}
	
	public static List<JSonPlayer> getPlayers() {
		return instance.players;
	}

}
