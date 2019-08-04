package com.ue.utils;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Random;

public class JavaUtils {

	private static Random random;
	
	/**
	 * 得到一个小于n并且大于0的int随机数
	 * @param n 最大值
	 * @return 生成的随机数
	 */
	public static int nextInt(int n){
		if(random == null){
			random = new Random();
		}
		return random.nextInt(n);
	}
	
	
	/**
	 * 得到一个随机数double
	 * @param n 最大值
	 * @return 生成的随机数
	 */
	public static double nextDouble(int n){
		if(random == null){
			random = new Random();
		}
		return random.nextDouble() * n;
	}
	/**
	 * 得到一个0到1的double随机数
	 * @return 生成的随机数
	 */
	public static double nextDouble(){
		if(random == null){
			random = new Random();
		}
		return random.nextDouble();
	}
	
	/**
	 * 将一个double保留n位小数
	 * @param value 待处理的小数
	 * @param n 保留的位数
	 * @return 处理后的小数
	 */
	public static double subToN(double value,int n){
		if(n == 0){
			return (int)value;
		}
		String str = "###.";
		for(int i = 0; i < n ;i ++){
			str = str + "0";
		}
		DecimalFormat decimalFormat  = new DecimalFormat(str );
		return Double.parseDouble(decimalFormat.format(value));
	}
	
	/**
	 * 将一个list变成string并返回
	 * @param list
	 * @return 拼合成的字符串
	 */
	public static <T> String toString(List<T> list){
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i).toString() + "\n");
		}
		return sb.toString();
	}
	/**
	 * 判断是否为空
	 * @param str
	 * @return
	 */
	public static boolean isEmptyOrNUll(String str){
		if(str == null || "".equals(str)){
			return true;
		}
		return false;
	}
	/**
	 * 判断是否为空
	 * @param str
	 * @return
	 */
	public static boolean areAllEmptyOrNUll(String ...str){
		for (int i = 0; i < str.length; i++) {
			if(str != null || !"".equals(str)){
				return false;
			}
		}
		return true;
	}
	
}
