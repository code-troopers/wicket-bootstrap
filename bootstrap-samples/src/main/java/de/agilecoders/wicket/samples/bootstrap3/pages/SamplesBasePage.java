package de.agilecoders.wicket.samples.bootstrap3.pages;

import com.newrelic.api.agent.NewRelic;
import de.agilecoders.wicket.core.markup.html.bootstrap.behavior.BootstrapResourcesBehavior;
import de.agilecoders.wicket.core.markup.html.bootstrap.html.ChromeFrameMetaTag;
import de.agilecoders.wicket.core.markup.html.bootstrap.html.HtmlTag;
import de.agilecoders.wicket.core.markup.html.bootstrap.html.MetaTag;
import de.agilecoders.wicket.core.markup.html.bootstrap.html.OptimizedMobileViewportMetaTag;
import de.agilecoders.wicket.samples.assets.base.Bootstrap3DocsCssResourceReference;
import org.apache.wicket.AttributeModifier;
import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.TransparentWebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

/**
 * base sample page
 *
 * @author miha
 */
abstract class SamplesBasePage extends WebPage {

    /**
     * Construct.
     *
     * @param parameters the page parameters
     */
    public SamplesBasePage(PageParameters parameters) {
        super(parameters);

        add(new HtmlTag("html"));

        add(new OptimizedMobileViewportMetaTag("viewport"));
        add(new ChromeFrameMetaTag("chrome-frame"));
        add(new MetaTag("description", Model.of("description"), Model.of("Apache Wicket & Twitter Bootstrap Demo")));
        add(new MetaTag("author", Model.of("author"), Model.of("Michael Haitz <michael.haitz@agile-coders.de>")));

        add(new BootstrapResourcesBehavior());
        add(newBodyTag("body"));

        // add new relic RUM scripts.
        add(new Label("newrelic", Model.of(NewRelic.getBrowserTimingHeader()))
                    .setEscapeModelStrings(false)
                    .setRenderBodyOnly(true)
                    .add(new AttributeModifier("id", "newrelic-rum-header")));
        add(new Label("newrelic-footer", Model.of(NewRelic.getBrowserTimingFooter()))
                    .setEscapeModelStrings(false)
                    .setRenderBodyOnly(true)
                    .add(new AttributeModifier("id", "newrelic-rum-footer")));
    }

    protected TransparentWebMarkupContainer newBodyTag(String id) {
        return new TransparentWebMarkupContainer(id);
    }

    @Override
    public void renderHead(IHeaderResponse response) {
        super.renderHead(response);

        response.render(CssHeaderItem.forReference(Bootstrap3DocsCssResourceReference.INSTANCE));
    }
}
