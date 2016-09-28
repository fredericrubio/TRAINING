package fr.home.json.player.core;

import java.util.LinkedList;
import java.util.List;

public class JSonPlayerFactory {

	static JSonPlayerFactory instance;
	List <JSonPlayer>	players;
	
	static {
		instance = new JSonPlayerFactory();
	}
	
	private JSonPlayerFactory() {
		players = new LinkedList<JSonPlayer>();
	}
	
	static public boolean startNewPlayer(String pFileName) {
	
		JSonArrayFilePlayer lPlayer = new JSonArrayFilePlayer(pFileName);
		
		if (lPlayer.isValid()) {
			
			instance.players.add(lPlayer);
			
			lPlayer.setPeriod(1000);
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
