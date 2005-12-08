/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */
package net.sourceforge.pmd.renderers;

import net.sourceforge.pmd.PMD;
import net.sourceforge.pmd.Report;
import net.sourceforge.pmd.RuleViolation;

import java.util.Iterator;

/**
 * <P>A Renderer for running PMD via a TextPad 'tool'.  <a href="http://www.textpad.com">TextPad</a> is a text editor by Helios Software Solutions.</P>
 * <p/>
 * <P>Output lines are in the form:</P>
 * <p/>
 * <P><CODE>pathtojavafile(line#, NameOfRule):&nbsp; Specific rule violation message</CODE></P>
 * <p/>
 * <P>For example:</P>
 * <p/>
 * <P><CODE>D:\java\pmd\src\src\net\sourceforge\pmd\renderers\TextPadRenderer.java(24, AtLeastOneConstructor):&nbsp; Each class should declare at least one constructor
 * <br>D:\java\pmd\src\src\net\sourceforge\pmd\renderers\TextPadRenderer.java(26, VariableNamingConventionsRule):&nbsp; Variables should start with a lowercase character
 * <br>D:\java\pmd\src\src\net\sourceforge\pmd\renderers\TextPadRenderer.java(31, ShortVariable):&nbsp; Avoid variables with short names</CODE></P>
 *
 * @author Jeff Epstein, based upon <a href="EmacsRenderer.html">EmacsRenderer</a>, Tuesday, September 23, 2003
 */
public class TextPadRenderer extends AbstractRenderer implements Renderer {
    public String render(Report report) {
        StringBuffer buf = new StringBuffer();
        Iterator i;
        try {
            i = report.iterator();
        } catch (NullPointerException npx) {
            throw new NullPointerException("ERROR in " + this.getClass().getName() + ".render:  Parameter report is null.");
        }
        while (i.hasNext()) {
            RuleViolation rv = (RuleViolation) i.next();
            //Filename
            buf.append(PMD.EOL).append(rv.getFilename() + "(");
            //Line number
            buf.append(Integer.toString(rv.getNode().getBeginLine())).append(",  ");
            //Name of violated rule
            buf.append(rv.getRule().getName()).append("):  ");
            //Specific violation message
            buf.append(rv.getDescription());
        }
        return buf.toString();
    }
}
