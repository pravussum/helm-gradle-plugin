package com.kiwigrid.k8s.helm.tasks;

import java.io.File;

import com.kiwigrid.k8s.helm.HelmPlugin;
import org.gradle.api.tasks.OutputDirectory;
import org.gradle.api.tasks.OutputFile;
import org.gradle.api.tasks.OutputFiles;
import org.gradle.api.tasks.TaskAction;

/**
 * created on 28.03.18.
 *
 * @author Jörg Eichhorn {@literal <joerg.eichhorn@kiwigrid.com>}
 */
public class HelmInitTask extends AbstractHelmTask {

	@TaskAction
	public void helmInit() {
		HelmPlugin.helmExec(getProject(), this, "init", "--client-only");
	}

	@OutputDirectory
	public File getTaskOutput() {
		// we use the plugin directory as output because nobody messes with it
		return new File(super.getHelmHomeDirectory(), "plugins");
	}
}
