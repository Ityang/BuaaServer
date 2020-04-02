package cn.buaa.util;

/**
 * @author Bob
 */
public class StringUtil {

    /**
     * 判断字符串是否为空，不为null，且也不为空字符串，则返回true，否则返回false。
     *
     * @param str str
     * @return boolean
     */
    public static boolean isNotNull(String str) {
        return !isNull(str);
    }

    /**
     * 判断字符串是否为空，为Null、空串返回true；否则返回false；
     *
     * @param str str
     * @return boolean
     */
    public static boolean isNull(String str) {
        if (str != null && str.trim().length() >= 1) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
}
