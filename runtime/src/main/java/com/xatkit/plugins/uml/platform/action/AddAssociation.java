package com.xatkit.plugins.uml.platform.action;

import com.xatkit.core.platform.action.RuntimeAction;
import com.xatkit.core.session.XatkitSession;
import com.xatkit.plugins.uml.platform.UmlPlatform;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.*;

public class AddAssociation extends RuntimeAction<UmlPlatform> {

    private Class source;

    private Class target;

    private String type;

    public AddAssociation(UmlPlatform umlPlatform, XatkitSession session, Class source, Class target, String type) {
        super(umlPlatform, session);
        this.source = source;
        this.target = target;
        this.type = type;
    }

    @Override
    protected Object compute() throws Exception {
        Association association = UMLFactory.eINSTANCE.createAssociation();
        Property sourceProperty = UMLFactory.eINSTANCE.createProperty();
        Property targetProperty = UMLFactory.eINSTANCE.createProperty();
        sourceProperty.setType(source);
        targetProperty.setType(target);
        // aggregation set on the opposite end (to check)
        // should depend on the provided type
        targetProperty.setAggregation(AggregationKind.COMPOSITE_LITERAL);
        association.getOwnedEnds().add(sourceProperty);
        association.getOwnedEnds().add(targetProperty);
        this.runtimePlatform.getModel().getPackagedElements().add(association);
        return association;
    }
}
