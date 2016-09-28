package fr.home.json.player.core;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JSonArrayFilePlayer extends JSonPlayer {
	
	// Attributs
	FileReader fileReader;
	JsonArray arrayOfObjects;
	ExecutorService executor;
	int currentItem = 0;

	
	public JSonArrayFilePlayer(String pFileName) {

		super(pFileName);
		
		executor = Executors.newSingleThreadExecutor();
		
		try {
			JsonParser	parser = new JsonParser();
			
			fileReader = new FileReader(pFileName);
			arrayOfObjects = (JsonArray) parser.parse(fileReader);
			  
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public boolean start() {
	
		if (! isValid() )
			return false;
		
		executor.execute(new Runnable() {
			@Override
			public void run() {

				try {

//					while (currentItem <= arrayOfObjects.size()) {
					while (! playing) {
						
						Thread.sleep(period);
						
						playOne();
											
					}
 					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		return true;
	}
	
	public void stop() {
		
		playing= true;
		executor.shutdown();
		
	}
	
	protected void playOne() {
		int loop = 0;
		
		for (Object o : arrayOfObjects) {
		    JsonObject lObject = (JsonObject) o;
		
		    if (loop == currentItem) {
			    System.out.println(lObject.toString());
			    currentItem++;
			    if (currentItem >= arrayOfObjects.size()) {
			    	stop();
			    }
			    return;
		    }
		    loop++;
		  }	
		}
	
	public boolean isValid() {
		
		return (fileReader != null);
		
	}

}
