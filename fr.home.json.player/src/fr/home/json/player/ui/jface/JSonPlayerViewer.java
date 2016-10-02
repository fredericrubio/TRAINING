package fr.home.json.player.ui.jface;

import java.awt.Image;
import java.text.SimpleDateFormat;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

import fr.home.json.player.core.JSonPlayer;
import fr.home.json.player.core.JSonPlayerFactory;

public class JSonPlayerViewer extends Dialog {
	private Table table;
	private TableViewer tableViewer;
	
	/**
	 * Create the dialog.
	 * @param parentShell
	 */
	public JSonPlayerViewer(Shell parentShell) {
		super(parentShell);
		setShellStyle(SWT.RESIZE | SWT.TITLE | SWT.APPLICATION_MODAL);
	}

	/**
	 * Create contents of the dialog.
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		
		tableViewer = new TableViewer(container, SWT.BORDER | SWT.FULL_SELECTION);
		table = tableViewer.getTable();
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

	    // Define the columns
	    String[] COLUMNS = new String[] { "Fichier", "Etat", "Status" };
	    for( String element : COLUMNS ) {
	        TableColumn col = new TableColumn( table, SWT.CENTER );
	        col.setText( element);
	        col.setWidth(100);
	    }
	    
	    tableViewer.setContentProvider( new ArrayContentProvider());
	    
	    // For very element to display, we will select what to display
	    // in function of the column index
	    tableViewer.setLabelProvider( new ITableLabelProvider() {
	 
	        @Override
	        public String getColumnText( Object element, int colmnIndex ) {
	 
	            String result = null;
	            boolean lBoolean;
	            
	            switch( colmnIndex ) {
	            case 0:
	                result = ((JSonPlayer) element).getShortFileName();
	                break;
	 
	            case 1:
	            	lBoolean =  ((JSonPlayer) element).isValid();
	                result = lBoolean ? "Valide":"Non valide";
	                break;
	 
	            case 2:
	            	lBoolean =  ((JSonPlayer) element).isPlaying();
	                result = lBoolean ? "En cours":"A l'arrêt";
	                break;
	            }
	 
	            return result;
	        }

			@Override
			public void addListener(ILabelProviderListener listener) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void dispose() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public boolean isLabelProperty(Object element, String property) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public void removeListener(ILabelProviderListener listener) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public org.eclipse.swt.graphics.Image getColumnImage(Object element, int columnIndex) {
				// TODO Auto-generated method stub
				return null;
			}

	    });
	    
	    // Eventually, let's define an input	 
	    tableViewer.setInput( JSonPlayerFactory.getPlayers().toArray() );
	    tableViewer.refresh();
	    
	    return container;
	}

	/**
	 * Create contents of the button bar.
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(450, 300);
	}

}
