package solution;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-07-11 21:41
 * @see <a href="https://leetcode.com/problems/defanging-an-ip-address/">1108. Defanging an IP Address</a>
 */
public class DefangingAnIpAddress {

    // my solution
    public String defangIPaddr(String address) {
        return address.replaceAll("\\.", "\\[.\\]");
    }

    public String anotherSolution(String address) {
        StringBuilder builder = new StringBuilder();
        int length = address.length();
        for (int i = 0; i < length; i++) {
            char c = address.charAt(i);
            if (c == '.') {
                builder.append("[.]");
            }else {
                builder.append(c);
            }
        }
        return builder.toString();
    }

    @Test
    public void test01() {
        assertEquals("1[.]1[.]1[.]1", defangIPaddr("1.1.1.1"));
        assertEquals("1[.]1[.]1[.]1", anotherSolution("1.1.1.1"));

    }

    @Test
    public void test02() {
        assertEquals("255[.]100[.]50[.]0", defangIPaddr("255.100.50.0"));
        assertEquals("255[.]100[.]50[.]0", anotherSolution("255.100.50.0"));
    }
}
