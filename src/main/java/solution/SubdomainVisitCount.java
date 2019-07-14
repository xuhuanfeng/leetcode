package solution;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author huanfeng.xu
 * @date 2019-07-14 22:22
 * @see <a href="https://leetcode.com/problems/subdomain-visit-count/">811. Subdomain Visit Count</a>
 */
public class SubdomainVisitCount {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> domainMap = new HashMap<>();
        for (String cpdomain : cpdomains) {
            String[] split = cpdomain.split(" ");
            int counter = Integer.parseInt(split[0]);
            String[] domains = split[1].split("\\.");
            String domain = "";
            for (int i = domains.length - 1; i >= 0; i--) {
                if ("".equals(domain)) {
                    domain = (domains[i]);
                }else {
                    domain = domains[i] + "." + domain;
                }
                Integer cnt = domainMap.get(domain);
                if (cnt == null || cnt == 0) {
                    domainMap.put(domain, counter);
                }else {
                    domainMap.put(domain, cnt + counter);
                }
            }
        }
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : domainMap.entrySet()) {
            result.add(entry.getValue() + " " + entry.getKey());
        }
        return result;
    }

    @Test
    public void test01() {
        System.out.println(subdomainVisits(new String[]{"9001 discuss.leetcode.com"}));
        System.out.println(subdomainVisits(new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"}));
    }
}
