package edu.uoc.som.jarvis.uml.platform.action;

import edu.uoc.som.jarvis.core.platform.action.RuntimeAction;
import edu.uoc.som.jarvis.core.session.JarvisSession;
import edu.uoc.som.jarvis.uml.platform.UmlPlatform;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.UMLFactory;

public class CreateClass extends RuntimeAction<UmlPlatform> {

    private String name;

    public CreateClass(UmlPlatform umlPlatform, JarvisSession session, String name) {
        super(umlPlatform, session);
        this.name = name;
    }

    @Override
    protected Object compute() throws Exception {
        Class clazz = UMLFactory.eINSTANCE.createClass();
        clazz.setName(this.name);
        this.runtimePlatform.getModel().getPackagedElements().add(clazz);
        return clazz;
    }
}
