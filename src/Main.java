import sun.misc.Regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by luyunfeng on 2018/7/17.
 */
public class Main {
    public static void main(String[] args) {
        test("this\\s+is\\s+text", "this    is  text");
        test("this\\s+is\\s+text", "this  1  is  text");

        test("^\\d+(\\.\\d+)?$", "6.28");
        test("^\\d+(\\.\\d+)?$", "2.6f");

        test("^[abc][vz]$", "az");
        test("^[abc][vz]$", "a");

        // 匹配除了a,b,c外的任意字符
        test("[^abc]", "abaabbbcccc");
        test("[^abc]", "agggrsea");
        test("[^abc]", "kkk");

        test("[a-d1-7]", "a5");
        test("[a-d1-7]", "r9");
        test("[a-d1-7]", "e1");

        test("X|Z", "X");
        test("X|Z", "T");

        test("\\w+", "#$_");
        test("\\w+", "ver");
    }

    public static void test(String patternStr, String str) {
        Pattern pattern = Pattern.compile(patternStr);
        Matcher matcher = pattern.matcher(str);
        boolean result = matcher.find();
        System.out.println(patternStr + "   |   " + str + " => " + result);
    }
}
