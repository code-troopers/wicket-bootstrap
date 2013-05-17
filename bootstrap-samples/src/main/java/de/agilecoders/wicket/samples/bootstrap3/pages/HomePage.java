package de.agilecoders.wicket.samples.bootstrap3.pages;

import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.wicketstuff.annotation.mount.MountPath;

/**
 * Homepage with large description and links to source
 *
 * @author miha
 */
@MountPath(value = "/", alt = "/home")
public class HomePage extends SamplesBasePage {

    /**
     * Construct.
     *
     * @param parameters the page parameters
     */
    public HomePage(PageParameters parameters) {
        super(parameters);
    }

}
