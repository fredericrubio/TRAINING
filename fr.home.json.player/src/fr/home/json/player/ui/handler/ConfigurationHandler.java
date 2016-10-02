package fr.home.json.player.ui.handler;
import java.util.Map;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;

import fr.home.json.player.ui.jface.ConfigurationUI;


public class ConfigurationHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		
		ConfigurationUI lUI = new ConfigurationUI(Display.getDefault().getActiveShell());
		lUI.open();
		
		return null;
	}


}
