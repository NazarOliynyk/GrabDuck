package oktenweb;

import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;
import com.sun.org.apache.xml.internal.security.utils.Base64;
import org.junit.Test;


public class ApplicationTest {

    @Test
    public void testConfigurationGlobal() throws Base64DecodingException {
        String auth = "";
        System.out.println(new String(Base64.decode(auth)));
    }
}
