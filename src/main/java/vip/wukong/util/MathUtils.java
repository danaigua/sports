package vip.wukong.util;

import java.util.ArrayList;
import java.util.List;

/**
 * 数学工具类
 * @author 章家宝
 *
 */
public class MathUtils {

	/**
	 * 获得一个0 ~ limit的随机数
	 * @param limit
	 * @return
	 */
	public static Integer getRadomNumber(Integer limit) {
		return (int)(Math.random()*limit);
	}
	/**
	 * 获取n个不重复的值
	 * @param limit
	 * @return
	 */
	public static String getNumberNoRepeat(Integer limit) {
		String str = "";
		int k = 0;
		List<Integer> numList = new ArrayList<Integer>();
		List<Integer> numBoxList = new ArrayList<Integer>();
		while(numList.size() < limit) {
			int i = getRadomNumber(limit);
			boolean flag = true;
			for (int j : numBoxList) {
				if(i == j) {
					flag = false;
				}
			}
			if(flag) {
				numList.add(i);
				numBoxList.add(i);
			}
		}
		for (Integer integer : numList) {
			if(k == 0) {
				str = str + integer;
				k++;
			}else {
				str = str + "," +  integer;
			}
		}
		return str;
	}
	/**
	 * 获取n个不重复的值
	 * @param limit
	 * @return
	 */
	public static String getNumberNoRepeat(Integer limit, Integer persion) {
		String str = "";
		int k = 0;
		List<Integer> numList = new ArrayList<Integer>();
		List<Integer> numBoxList = new ArrayList<Integer>();
		while(numList.size() < persion) {
			int i = getRadomNumber(limit);
			boolean flag = true;
			for (int j : numBoxList) {
				if(i == j) {
					flag = false;
				}
			}
			if(flag) {
				numList.add(i);
				numBoxList.add(i);
			}
		}
		for (Integer integer : numList) {
			if(k == 0) {
				str = str + integer;
				k++;
			}else {
				str = str + "," +  integer;
			}
		}
		return str;
	}
	public static void main(String[] args) {
		System.out.println(1 / 2);
	}
}
