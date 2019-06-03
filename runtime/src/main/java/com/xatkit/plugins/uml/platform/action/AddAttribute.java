package com.xatkit.plugins.uml.platform.action;

import com.xatkit.core.platform.action.RuntimeAction;
import com.xatkit.core.session.XatkitSession;
import com.xatkit.plugins.uml.platform.UmlPlatform;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLFactory;

import static java.util.Objects.nonNull;

public class AddAttribute extends RuntimeAction<UmlPlatform> {

    private Class clazz;

    private String name;

    private String type;

    public AddAttribute(UmlPlatform umlPlatform, XatkitSession session, Class clazz, String name, String type) {
        super(umlPlatform, session);
        this.name = name;
        this.clazz = clazz;
        this.type = type;
    }

    public AddAttribute(UmlPlatform umlPlatform, XatkitSession session, Class clazz, String name) {
        this(umlPlatform, session, clazz, name, null);
    }

    @Override
    protected Object compute() throws Exception {
        Property property = UMLFactory.eINSTANCE.createProperty();
        property.setName(this.name);
        if(nonNull(this.type)) {
            DataType dataType = UMLFactory.eINSTANCE.createDataType();
            dataType.setName(this.type);
            property.setType(dataType);
        }
        this.clazz.getOwnedAttributes().add(property);
        return property;
    }
}
