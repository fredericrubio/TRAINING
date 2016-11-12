package fr.home.wwlightconfiguration.ui;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Group;

public class wwlightconfiguration extends Dialog {

	/**
	 * Create the dialog.
	 * @param parentShell
	 */
	public wwlightconfiguration(Shell parentShell) {
		super(parentShell);
		
		setShellStyle(SWT.DIALOG_TRIM);
		
	}


//	@Override
//	protected int getShellStyle()
//	{
//	    return (super.getShellStyle() & (~SWT.RESIZE));
//	}
	
	@Override
   protected void configureShell(Shell shell) {
	      super.configureShell(shell);
	      shell.setText("Configuration de la source lumineuse");
			
	   }
	
	/**
	 * Create contents of the dialog.
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		GridLayout gridLayout = (GridLayout) container.getLayout();
		
		Composite composite = new Composite(container, SWT.BORDER);
		GridData gd_composite = new GridData(SWT.CENTER, SWT.CENTER, true, true, 1, 1);
		gd_composite.heightHint = 52;
		gd_composite.widthHint = 301;
		composite.setLayoutData(gd_composite);
		GridLayout gl_composite = new GridLayout(4, true);
		gl_composite.marginHeight = 15;
		gl_composite.verticalSpacing = 10;
		composite.setLayout(gl_composite);
		
		Label lblNewLabel = new Label(composite, SWT.NONE);
		lblNewLabel.setText("Azimut (°) :");
		
		Spinner spinner = new Spinner(composite, SWT.BORDER);
		GridData gd_spinner = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_spinner.widthHint = 30;
		spinner.setLayoutData(gd_spinner);
		spinner.setMaximum(360);
		
		Label lblNewLabel_1 = new Label(composite, SWT.NONE);
		lblNewLabel_1.setText("Elévation (°) :");
		
		Spinner spinner_1 = new Spinner(composite, SWT.BORDER);
		GridData gd_spinner_1 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_spinner_1.widthHint = 30;
		spinner_1.setLayoutData(gd_spinner_1);
		spinner_1.setMaximum(80);

		return container;
	}

	/**
	 * Create contents of the button bar.
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		Button buttonCancel = createButton(parent, IDialogConstants.CANCEL_ID, "Annuler", false);
		buttonCancel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		Button buttonApply = createButton(parent, IDialogConstants.OK_ID, "Appliquer", true);
		buttonApply.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		Button buttonValidate = createButton(parent, IDialogConstants.OK_ID, "Valider", true);
		buttonValidate.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(327, 149);
	}

}
