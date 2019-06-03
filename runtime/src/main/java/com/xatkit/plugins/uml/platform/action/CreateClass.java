package com.xatkit.plugins.uml.platform.action;

import com.xatkit.core.platform.action.RuntimeAction;
import com.xatkit.core.session.XatkitSession;
import com.xatkit.plugins.uml.platform.UmlPlatform;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.UMLFactory;

public class CreateClass extends RuntimeAction<UmlPlatform> {

    private String name;

    public CreateClass(UmlPlatform umlPlatform, XatkitSession session, String name) {
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
