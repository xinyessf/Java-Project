package com.huanyu.fun.common.util.ValidateUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @description
 * @create: 2019-12-15 10:59
 **/
public class NumberValidateUtil {
    /**
     * 验证数字输入
     */
    public static boolean IsNumber(String str) {
        String regex = "^[0-9]*$";
        return match(regex, str);
    }

    /**
     * 验证非零的正整数
     */
    public static boolean IsIntNumber(String str) {
        String regex = "^\\+?[1-9][0-9]*$";
        return match(regex, str);
    }
    private static boolean match(String regex, String str) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }
}
