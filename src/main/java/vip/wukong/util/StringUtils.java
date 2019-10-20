package vip.wukong.util;
/**
 * 字符串工具类
 * @author 章家宝
 *
 */
public class StringUtils {

	private StringUtils() {
		
	}
	public static StringUtils build() {
		return new StringUtils();
	}
	/**
	 * 判断字符串是否为空
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		if(str == null || "".equals(str)) {
			return true;
		}else {
			return false;
		}
	}
	/**
	 * 判断字符串是否不为空
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str) {
		if(!isEmpty(str)) {
			return true;
		}else {
			return false;
		}
	}
}
