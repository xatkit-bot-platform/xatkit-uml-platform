package com.xatkit.plugins.uml.platform.action;

import com.xatkit.core.platform.action.RuntimeAction;
import com.xatkit.core.session.XatkitSession;
import com.xatkit.plugins.uml.platform.UmlPlatform;
import org.eclipse.uml2.uml.Class;

public class GetClass extends RuntimeAction<UmlPlatform> {

    private String name;

    public GetClass(UmlPlatform umlPlatform, XatkitSession session, String name) {
        super(umlPlatform, session);
        this.name = name;
    }

    @Override
    protected Object compute() throws Exception {
        return this.runtimePlatform.getModel().getOwnedElements().stream().filter(e ->
            e instanceof Class && (((Class) e).getName().equals(name))).findAny().orElseGet(() -> null);
    }
}
