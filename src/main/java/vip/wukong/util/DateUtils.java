package vip.wukong.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期工具类
 * @author 章家宝
 *
 */
public class DateUtils {

	/**
	 * 把string字符串转化成一个日期对象
	 * @throws ParseException 
	 */
	public static Date formatString2Date(String str) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.parse(str);
	}
	public static void main(String[] args) throws Exception {
	}
	public static String getCurrentYear() {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		return sdf.format(new Date()) + "年度";
	}
}
