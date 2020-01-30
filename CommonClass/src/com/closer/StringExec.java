package com.closer;

import org.junit.Test;

import java.util.Arrays;

/**
 * <p>StringExec</p>
 * <p>description</p>
 *
 * @author closer
 * @version 1.0.0
 * @date 2020-01-30 20:23
 */
public class StringExec {
    /**
     * 字符串反转 [begin, end]
     *
     * @param str
     * @param begin
     * @param end
     * @return
     */
    public String reverse1(String str, int begin, int end) {
        char[] arr = str.toCharArray();
        for (int i = begin, j = end; i < j; i++, j--) {
            char tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
        return new String(arr);
    }

    public String reverse2(String str, int begin, int end) {
        StringBuilder sb = new StringBuilder(str.length());
        sb.append(str.substring(0, begin));
        sb.append(new StringBuilder(str.substring(begin, end + 1)).reverse());
        sb.append(str.substring(end + 1));
        return sb.toString();
    }

    @Test
    public void test1() {
        String s = "abcdefghijklmn";
        System.out.println(reverse1(s, 1, 3));
        System.out.println(reverse1(s, 3, 9));
    }

    /**
     * 判断子字符串在主字符串中出现次数
     *
     * @param mainStr 主字符串
     * @param subStr  子字符串
     * @return
     */
    public int getCount(String mainStr, String subStr) {
        int mainLen = mainStr.length();
        int subLen = subStr.length();
        if (mainLen < subLen) {
            return 0;
        } else {
            int count = 0;
            int index = 0;
            /*while ((index = mainStr.indexOf(subStr)) != -1) {
                mainStr = mainStr.substring(index + subLen);
                count++;
            }*/
            while ((index = mainStr.indexOf(subStr, index)) != -1) {
                count++;
                index += subLen;
            }
            return count;
        }
    }

    @Test
    public void test2() {
        System.out.println(getCount("ababababaabababab", "ab"));
    }


    public String[] getMaxSameString(String str1, String str2) {
        String maxStr = (str1.length() > str2.length()) ? str1 : str2;
        String minStr = (str1.length() <= str2.length()) ? str1 : str2;
        int epoch = minStr.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < epoch; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(i);
                System.out.println(" " + j);
                String subStr = minStr.substring(j, epoch - i + j);
                if (maxStr.contains(subStr)) {
                    sb.append(subStr + ",");
                }
            }
            if (sb.length() != 0) {
                break;
            }
        }
        String[] res = sb.toString().replaceAll(".$", "").split("\\,");
        return res;
    }

    @Test
    public void test3() {
        System.out.println(Arrays.asList(getMaxSameString("hellopWorld", "helloWorld")));
    }
}

