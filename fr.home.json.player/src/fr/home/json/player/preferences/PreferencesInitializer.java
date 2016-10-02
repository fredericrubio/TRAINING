package fr.home.json.player.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

import fr.home.json.player.JSonPlayerActivator;

public class PreferencesInitializer extends AbstractPreferenceInitializer {

	public PreferencesInitializer() {

	}

	@Override
	public void initializeDefaultPreferences() {

		IPreferenceStore store = JSonPlayerActivator.getDefault().getPreferenceStore();
		
		store.setDefault(JSonPlayerPreferences.PERIOD, 1000);

	}

}
