/**
 *
 * Copyright © 2010 杭州邦盛金融信息技术有限公司 版权所有
 *
 */
package com.example.newboot.utils.fit;
/**
 * 工具类<br>
 * 功能:将long数值类型数据转换为64进制的字符串类型 <br>
 * 时间:2018年8月17日 下午6:06:00 <br>
 * @author
 */
public class ConvertUtil {
    /*
     * 64个字符,从大到小,满64进1
     */
    final static char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8',
        '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
        'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A',
        'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
        'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '_', '$'};
    /**
     * 
     * 将long数值类型数据转换为64进制的字符串类型<br>
     *
     * @author 余建浪
     * @param number 待转换的long类型数值 
     * @return 转换后的字符串
     */
    public static String compress64(long number) {
        int shift=6;
        char[] buf = new char[64];
        int charPos = 64;
        int radix = 1 << shift;
        long mask = radix - 1L;
        do {
            buf[--charPos] = digits[(int)(number & mask)];
            number >>>= shift;
        } while (number != 0);
        return new String(buf, charPos, (64 - charPos));
    }
}
