package cn.buaa.util;

/**
 * @author Bob
 */
public class StringUtil {
    //*********************字符常量***********************//
    public static final String NULL = "null";

    /**
     * 描述: 判断字符串是否为空
     *
     * @param str
     *            字符串  
     * @return boolean
     */
    public static boolean isNotNull(Object... str) {

        if (str == null) {
            return false;
        }

        for (Object s : str) {
            if (isEmptyObj(s)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 描述: 判断object是否为空
     *
     * @param o
     *            字符串  
     * @return boolean
     */
    public static boolean isEmptyObj(final Object o) {
        if (o == null || o.toString().trim().length() == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 判断参数是否为空，NULL与""返回true，反之false
     *
     * @param s
     * @return boolean
     */
    public static boolean isEmpty(final String s) {
        if (s == null || s.trim().length() == 0) {
            return true;
        }
        return false;
    }

    /**
     * 判断参数是否为空，NULL与""返回false，反之true
     *
     * @param s
     * @return boolean
     */
    public static boolean isNotEmpty(final String s) {
        return !isEmpty(s);
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


    /**
     * 判断字符串是否包含在数组中
     * @param str
     * @return true 包含 false 不包含
     */
    public static boolean containsStr(String str,String[] strArray){
        boolean flag = false;
        if(!Validator.isEmpty(strArray)){
            for (String string : strArray){
                if (string.equals(str)) {
                    flag=true;
                }
            }
        }
        return flag;
    }
}
