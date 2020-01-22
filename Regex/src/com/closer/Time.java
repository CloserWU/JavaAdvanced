package com.closer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.*;

/**
 * Learn Java from https://www.liaoxuefeng.com/
 * 
 * @author liaoxuefeng
 */
public class Time {

	/**
	 * 从"21:05:19"中提取时，分，秒，否则抛出IllegalArgumentException
	 */
	public static int[] parseTime(String s) throws IllegalArgumentException{
		// FIXME:
		Pattern pattern = compile("([0-1]\\d|2[0-3]):([0-5]\\d):([0-5]\\d)");
		Matcher matcher = pattern.matcher(s);
		if (matcher.matches()) {
			Integer hour = new Integer(matcher.group(1));
			Integer minute = new Integer(matcher.group(2));
			Integer second = new Integer(matcher.group(3));
			return new int[] {hour, minute, second};
		} else {
			throw new IllegalArgumentException();
		}

	}

	public static void main(String[] args) {
		int[] ints = parseTime("21:05:19");
		for (int i: ints ) {
			System.out.println(i);
		}
	}

}
