package edu.uoc.som.jarvis.uml.platform;

import edu.uoc.som.jarvis.core.JarvisCore;
import edu.uoc.som.jarvis.core.platform.RuntimePlatform;
import org.apache.commons.configuration2.Configuration;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.UMLFactory;

public class UmlPlatform extends RuntimePlatform {

    private Model model;

    public UmlPlatform(JarvisCore jarvisCore, Configuration configuration) {
        super(jarvisCore, configuration);
        this.model = UMLFactory.eINSTANCE.createModel();
    }

    public Model getModel() {
        return model;
    }
}
