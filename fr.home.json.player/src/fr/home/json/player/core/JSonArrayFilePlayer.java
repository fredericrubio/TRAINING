package fr.home.json.player.core;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.eclipse.jface.util.PropertyChangeEvent;

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
		
		setPlaying(true);
		
		executor.execute(new Runnable() {
			@Override
			public void run() {

				try {

					while (isPlaying()) {
						
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
		
		setPlaying(false);
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

	@Override
	public void propertyChange(PropertyChangeEvent event) {
		
		System.out.println(event.getProperty());
		System.out.println(event.getOldValue());
		System.out.println(event.getNewValue());
		
	}

}
