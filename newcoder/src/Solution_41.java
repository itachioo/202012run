import java.util.*;

public class Solution_41 {
    /**
     * leetcode 49
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList();
        Map<String, List<String>> map = new HashMap();
        for(String str:strs) {
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String key = String.valueOf(ch);
            if(!map.containsKey(key)) {
//                map.put(key,str);
            }
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
