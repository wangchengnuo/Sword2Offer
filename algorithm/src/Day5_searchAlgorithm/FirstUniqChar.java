package Day5_searchAlgorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 */
public class FirstUniqChar {

    public char firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            map.compute(s.charAt(i), (key, value) -> {
                if(value == null){
                    value = 1;
                }else {
                    value += 1;
                }
                return value;
            });
        }
        for(int i = 0; i < s.length(); i++){
            if(map.get(s.charAt(i)) == 1){
                return s.charAt(i);
            }
        }
        return ' ';
    }
}
