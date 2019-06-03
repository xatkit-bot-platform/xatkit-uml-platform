package com.xatkit.plugins.uml.platform;

import com.xatkit.core.XatkitCore;
import com.xatkit.core.platform.RuntimePlatform;
import org.apache.commons.configuration2.Configuration;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.UMLFactory;

public class UmlPlatform extends RuntimePlatform {

    private Model model;

    public UmlPlatform(XatkitCore xatkitCore, Configuration configuration) {
        super(xatkitCore, configuration);
        this.model = UMLFactory.eINSTANCE.createModel();
    }

    public Model getModel() {
        return model;
    }
}
