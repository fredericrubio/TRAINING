package fr.home.json.player.ui.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.swt.widgets.Display;

import fr.home.json.player.ui.jface.JSonPlayerViewer;

public class ViewPlayersHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		JSonPlayerViewer lViewer = new JSonPlayerViewer(Display.getDefault().getActiveShell());
		lViewer.open();

		return null;
	}


}
