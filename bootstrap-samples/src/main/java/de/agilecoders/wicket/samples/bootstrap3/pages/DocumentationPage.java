package de.agilecoders.wicket.samples.bootstrap3.pages;

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.TransparentWebMarkupContainer;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.wicketstuff.annotation.mount.MountPath;

/**
 * TODO miha: document class purpose
 *
 * @author miha
 */
@MountPath(value = "/docs", alt = "/documentation")
public class DocumentationPage extends SamplesBasePage {

    /**
     * Construct.
     *
     * @param parameters the page parameters
     */
    public DocumentationPage(PageParameters parameters) {
        super(parameters);
    }

    @Override
    protected TransparentWebMarkupContainer newBodyTag(String id) {
        return new TransparentWebMarkupContainer(id) {
            @Override
            protected void onComponentTag(ComponentTag tag) {
                super.onComponentTag(tag);

                tag.put("class", "bs-docs-docs");
                tag.put("data-spy", "scroll");
                tag.put("data-target", ".bs-docs-sidebar");
            }
        };
    }
}
