/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */
package net.sourceforge.pmd.renderers;

import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;
import java.util.Properties;

import net.sourceforge.pmd.RuleViolation;

/**
 * Renderer to GNU Emacs parsable format.
 */
public class EmacsRenderer extends OnTheFlyRenderer {

    public static final String NAME = "emacs";

    protected static final String EOL = System.getProperty("line.separator", "\n");

    public EmacsRenderer(Properties properties) {
	super(NAME, "GNU Emacs integration.", properties);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void renderFileViolations(Iterator<RuleViolation> violations) throws IOException {
	Writer writer = getWriter();
	StringBuffer buf = new StringBuffer();
	while (violations.hasNext()) {
	    RuleViolation rv = violations.next();
	    buf.setLength(0);
	    buf.append(EOL).append(rv.getFilename());
	    buf.append(':').append(Integer.toString(rv.getBeginLine()));
	    buf.append(": ").append(rv.getDescription());
	    writer.write(buf.toString());
	}
    }
}
