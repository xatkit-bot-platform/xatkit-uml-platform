package edu.uoc.som.jarvis.uml.platform.action;

import edu.uoc.som.jarvis.core.platform.action.RuntimeAction;
import edu.uoc.som.jarvis.core.session.JarvisSession;
import edu.uoc.som.jarvis.uml.platform.UmlPlatform;
import org.eclipse.uml2.uml.Class;

public class GetClass extends RuntimeAction<UmlPlatform> {

    private String name;

    public GetClass(UmlPlatform umlPlatform, JarvisSession session, String name) {
        super(umlPlatform, session);
        this.name = name;
    }

    @Override
    protected Object compute() throws Exception {
        return this.runtimePlatform.getModel().getOwnedElements().stream().filter(e ->
            e instanceof Class && (((Class) e).getName().equals(name))).findAny().orElseGet(() -> null);
    }
}
