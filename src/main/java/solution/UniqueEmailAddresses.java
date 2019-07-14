package solution;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-07-14 10:44
 * @see <a href="https://leetcode.com/problems/unique-email-addresses/">929. Unique Email Addresses</a>
 */
public class UniqueEmailAddresses {
    public int numUniqueEmails(String[] emails) {
        Set<String> result = new HashSet<>();
        for (String email : emails) {
            String[] strs = email.split("@");
            String localName = strs[0].split("\\+")[0];
            localName = localName.replace(".", "");
            result.add(localName + "@" + strs[1]);
        }
        return result.size();
    }

    @Test
    public void test01() {
        assertEquals(2, numUniqueEmails(new String[]{"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"}));

    }
}
