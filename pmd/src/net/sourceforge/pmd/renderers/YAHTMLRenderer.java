/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */
package net.sourceforge.pmd.renderers;

import java.io.IOException;
import java.io.Writer;
import java.util.Properties;

import net.sourceforge.pmd.Report;
import net.sourceforge.pmd.lang.dfa.report.ReportHTMLPrintVisitor;
import net.sourceforge.pmd.lang.dfa.report.ReportTree;

/**
 * Renderer to another HTML format.
 */
public class YAHTMLRenderer extends AbstractRenderer {

    public static final String NAME = "yahtml";

    public static final String OUTPUT_DIR = "outputDir";

    private String outputDir;

    public YAHTMLRenderer(Properties properties) {
	// YA = Yet Another?
	super(NAME, "Yet Another HTML format.", properties);
	defineProperty(OUTPUT_DIR, "Output directory.");

	this.outputDir = properties.getProperty(OUTPUT_DIR);
    }

    /**
     * {@inheritDoc}
     */
    public void render(Writer writer, Report report) throws IOException {
	ReportTree tree = report.getViolationTree();
	tree.getRootNode().accept(new ReportHTMLPrintVisitor(outputDir == null ? ".." : outputDir));
	writer.write("<h3 align=\"center\">The HTML files are located "
		+ (outputDir == null ? "above the project directory" : ("in '" + outputDir + '\'')) + ".</h3>");
    }
}
