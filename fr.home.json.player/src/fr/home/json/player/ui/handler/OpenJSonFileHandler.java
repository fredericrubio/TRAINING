package fr.home.json.player.ui.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;

import fr.home.json.player.JSonPlayerActivator;
import fr.home.json.player.core.JSonArrayFilePlayer;
import fr.home.json.player.core.JSonPlayerFactory;
import fr.home.json.player.preferences.JSonPlayerPreferences;

public class OpenJSonFileHandler extends AbstractHandler {

	protected static String FILE_NAME = "/Users/fredericrubio/Development/Project/Java/Workspace/fr.home.json.player/resources/JSon.json";
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		FileDialog fd = new FileDialog(Display.getDefault().getActiveShell(), SWT.OPEN);
		
        String[] filterExt = { "*.json"};
        fd.setFilterExtensions(filterExt);
        
        fd.setFilterPath(System.getProperty("user.dir"));
        
		String selected = fd.open();
		
		IPreferenceStore preferenceStore = JSonPlayerActivator.getDefault().getPreferenceStore();
		JSonPlayerFactory.startNewPlayer(selected, preferenceStore.getInt((JSonPlayerPreferences.PERIOD)));
		
		return null;
		
	}
	
	@Override
	public boolean isEnabled() {
		return true;
	}

}
