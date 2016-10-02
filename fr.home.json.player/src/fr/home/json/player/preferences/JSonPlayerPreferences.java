package fr.home.json.player.preferences;

import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IntegerFieldEditor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import fr.home.json.player.JSonPlayerActivator;

public class JSonPlayerPreferences extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	public static String PERIOD = "period";
	
	public JSonPlayerPreferences() {
		
		setTitle("JSon Player Configuration");
		setPreferenceStore(JSonPlayerActivator.getDefault().getPreferenceStore());
	
	}

	@Override
	public void init(IWorkbench workbench) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void createFieldEditors() {
		{
			
			IntegerFieldEditor integerFieldEditor = new IntegerFieldEditor(PERIOD, "Période", getFieldEditorParent());
			integerFieldEditor.setStringValue("1000");
			integerFieldEditor.setValidRange(100, 5000);
			addField(integerFieldEditor);
		}
		
	}

}
