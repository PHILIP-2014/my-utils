package com.philip.utils.test;

public class TestString {

	public static void main(String[] args) {
		//反转字符串测试
		StringBuffer sb = new StringBuffer("abcdefg1234567890");
		System.out.println(sb.toString());
		sb.reverse();
		System.out.println(sb.toString());
	}
}
