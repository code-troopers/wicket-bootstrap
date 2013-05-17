package de.agilecoders.wicket.samples.assets.base;

import org.apache.wicket.request.resource.CssResourceReference;

/**
 * TODO: document
 *
 * @author miha
 * @version 1.0
 */
public class Bootstrap3DocsCssResourceReference extends CssResourceReference {

    public static Bootstrap3DocsCssResourceReference INSTANCE = new Bootstrap3DocsCssResourceReference("bootstrap3-docs.css");

    private Bootstrap3DocsCssResourceReference(String name) {
        super(Bootstrap3DocsCssResourceReference.class, name);
    }
}
