package filter;

import org.owasp.validator.html.AntiSamy;
import org.owasp.validator.html.CleanResults;
import org.owasp.validator.html.Policy;


class XssClean {

     static String xssClean(String value) {
        AntiSamy antiSamy = new AntiSamy();
        try {
            final CleanResults cr = antiSamy.scan(value, Policy.getInstance("policy.xml"), AntiSamy.SAX);
            return cr.getCleanHTML();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }
}

