package Day3_String;

/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 */
public class ReplaceSpace {

    public static String replaceSpace(String s) {
        return s.replace(" ", "%20");
    }

    public static void main(String[] args) {
        System.out.println(replaceSpace("We are happy."));
    }
}
