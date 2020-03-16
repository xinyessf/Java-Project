package com.huanyu.fun.common.util.ValidateUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @description
 * @create: 2019-12-15 10:54
 **/
public class ValidateUtil {
    /**
     * 验证身份证
     *
     * @param IDNumber
     * @return
     */
    public static boolean isIDCard(String IDNumber) {
        if (IDNumber == null || "".equals(IDNumber)) {
            return false;
        }
        if (IDNumber == null || (IDNumber.length() != 15 && IDNumber.length() != 18))
            return false;
        // 定义判别用户身份证号的正则表达式（15位或者18位，最后一位可以为字母）
        String regularExpression = "(^[1-9]\\d{5}(18|19|20)\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$)|" +
                "(^[1-9]\\d{5}\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}$)";
        boolean matches = IDNumber.matches(regularExpression);
        //判断第18位校验值
        if (matches) {

            if (IDNumber.length() == 18) {
                try {
                    char[] charArray = IDNumber.toCharArray();
                    //前十七位加权因子
                    int[] idCardWi = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
                    //这是除以11后，可能产生的11位余数对应的验证码
                    String[] idCardY = {"1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2"};
                    int sum = 0;
                    for (int i = 0; i < idCardWi.length; i++) {
                        int current = Integer.parseInt(String.valueOf(charArray[i]));
                        int count = current * idCardWi[i];
                        sum += count;
                    }
                    char idCardLast = charArray[17];
                    int idCardMod = sum % 11;
                    if (idCardY[idCardMod].toUpperCase().equals(String.valueOf(idCardLast).toUpperCase())) {
                        return true;
                    } else {
                        System.out.println("身份证最后一位:" + String.valueOf(idCardLast).toUpperCase() +
                                "错误,正确的应该是:" + idCardY[idCardMod].toUpperCase());
                        return false;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }
            }
        }
        return matches;
    }

    /**
     * 验证邮箱
     */
    public static boolean isEmail(String str) {
        String regex = "^([\\w-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([\\w-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
        return match(regex, str);
    }

    /**
     * 验证以逗号分隔的邮箱字符串
     *
     * @param str 邮箱字符串
     */
    public static boolean isManyEmail(String str) {
        boolean flag = false;
        String regex = "^([\\w-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([\\w-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
        if (str != null && str.length() > 0) {
            String[] emaiAddresss = str.split(",");
            for (int i = 0; i < emaiAddresss.length; i++) {
                if (!match(regex, emaiAddresss[i])) {
                    return false;
                }
                flag = true;
            }
        }
        return flag;
    }

    /**
     * 验证固话
     */
    public static boolean isTelephone(String str) {
        //String regex1="^[0][1-9]{2,3}-[0-9]{5,10}$";
        String regex2 = "[1-9]{1}[0-9]{5,8}$"; // 验证没有区号的
        String regex1 = "^((0\\d{2,3})-)(\\d{7,8})(-(\\d{3,}))?$";// 验证带区号的
        return match(regex2, str) || match(regex1, str);
    }

    /**
     * 包含大小写字母、数字、特殊字符至少8到16字符
     */
    public static boolean isPassword(String str) {
        String regex = "^(?![A-Za-z]+$)(?![A-Z\\d]+$)(?![A-Z\\W]+$)(?![a-z\\d]+$)(?![a-z\\W]+$)(?![\\d\\W]+$)\\S{8,16}$";
        return match(regex, str);
    }

    /**
     * 验证输入邮政编号
     */
    public static boolean isPostalcode(String str) {
        String regex = "^\\d{6}$";
        return match(regex, str);
    }

    /**
     * 验证输入手机号码
     */
    public static boolean isHandset(String str) {
        String regex = "^((13[0-9])|(17[0-1,6-8])|(15[^4,\\\\D])|(18[0-9]))\\d{8}$";
        return match(regex, str);
    }

    /**
     * 验证输入身份证号
     */
    public static boolean isIDcard(String str) {
        String regex = "(^\\d{18}$)|(^\\d{15}$)";
        return match(regex, str);
    }

    /**
     * 验证日期时间
     */
    public static boolean isDate(String str) {
        String regex = "^((((1[6-9]|[2-9]\\d)\\d{2})-(0?[13578]|1[02])-(0?[1-9]|[12]\\d|3[01]))|(((1[6-9]|[2-9]\\d)\\d{2})-(0?[13456789]|1[012])-(0?[1-9]|[12]\\d|30))|(((1[6-9]|[2-9]\\d)\\d{2})-0?2-(0?[1-9]|1\\d|2[0-8]))|(((1[6-9]|[2-9]\\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))-0?2-29-)) (20|21|22|23|[0-1]?\\d):[0-5]?\\d:[0-5]?\\d$";
        return match(regex, str);
    }

    private static boolean match(String regex, String str) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }
}
