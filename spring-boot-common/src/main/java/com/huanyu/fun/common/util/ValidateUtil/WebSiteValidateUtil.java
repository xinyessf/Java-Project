package com.huanyu.fun.common.util.ValidateUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @description
 * @create: 2019-12-15 10:57
 **/
public class WebSiteValidateUtil {

    /**
     * 验证网址Url
     */
    public static boolean IsUrl(String str) {
        String regex = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";

        //String regex= "^((https|http|ftp|rtsp|mms)?:\\)[-A-Za-z0-9+&@#/%?=~_|!:,.;]+[-A-Za-z0-9+&@#/%=~_|]";
        // String ab="((http|ftp|https)://)(([a-zA-Z0-9\\._-]+\\.[a-zA-Z]{2,6})|([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}))(:[0-9]{1,4})*(/[a-zA-Z0-9\\&%_\\./-~-]*)?\n";
        //String regex = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/?%=~_|]";
        ///(http|https):\/\/([\w.]+\/?)\S*/　
        ///http[s]{0,1}:\/\/([\w.]+\/?)\S*/
        String test="http://([w-]+.)+[w-]+(/[w- ./?%&=]*)?";
        return match(regex, str);
    }

    /**
     * 验证IPv4地址
     */
    public static boolean isIPv4(String ip) {
        return ip.matches("\\d{1,3}(\\.\\d{1,3}){3}");
    }

    /**
     * 验证IPv6地址
     */
    public static boolean isIpv6(String ipv6) {
        String regex = "([0-9A-Fa-f]{1,4}:){7}([0-9A-Fa-f]{1,4}|:)";
        return match(regex, ipv6);
    }

    private static boolean match(String regex, String str) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }
}
