package edu.uoc.som.jarvis.uml.platform.action;

import edu.uoc.som.jarvis.core.platform.action.RuntimeAction;
import edu.uoc.som.jarvis.core.session.JarvisSession;
import edu.uoc.som.jarvis.uml.platform.UmlPlatform;
import net.sourceforge.plantuml.SourceStringReader;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Class;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import static java.util.Objects.nonNull;

public class Save extends RuntimeAction<UmlPlatform> {

    public Save(UmlPlatform umlPlatform, JarvisSession session) {
        super(umlPlatform, session);
    }

    @Override
    protected Object compute() throws Exception {
        File f = new File("output.png");
        OutputStream png = new FileOutputStream(f);
        StringBuffer sb = new StringBuffer();
        sb.append("@startuml\n");
        sb.append(printClasses());
        sb.append(printAssociations());
        sb.append("@enduml\n");
        System.out.println(sb.toString());
        SourceStringReader reader = new SourceStringReader(sb.toString());
        // Write the first image to "png"
        String desc = reader.outputImage(png).getDescription();
        // Return a null string if no generation
        return f;
    }

    private String printClasses() {
        StringBuilder sb = new StringBuilder();
        this.runtimePlatform.getModel().getOwnedElements().stream().filter(e -> e instanceof Class).map(e -> (Class) e).forEach(clazz -> {
            sb.append("class ");
            sb.append(clazz.getName());
            sb.append(" {\n");
            sb.append(printAttributes(clazz));
            sb.append("}\n");
        });
        return sb.toString();
    }

    private String printAttributes(Class clazz) {
        StringBuilder sb = new StringBuilder();
        clazz.getOwnedAttributes().forEach(att -> {
            sb.append(att.getName());
            if(nonNull(att.getType())) {
                sb.append(" : ");
                sb.append(att.getType().getName());
            }
            sb.append("\n");
        });
        return sb.toString();
    }

    private String printAssociations() {
        StringBuilder sb = new StringBuilder();
        this.runtimePlatform.getModel().getOwnedElements().stream().filter(e -> e instanceof Association).map(e -> (Association)e).forEach(association -> {
            Class source = (Class)association.getOwnedEnds().get(0).getType();
            Class target = (Class)association.getOwnedEnds().get(1).getType();
            sb.append(source.getName());
            sb.append(" ");
            sb.append("*--");
            sb.append(" ");
            sb.append(target.getName());
            sb.append("\n");
        });
        return sb.toString();
    }
}
