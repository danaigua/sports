package vip.wukong.util;

import org.apache.shiro.crypto.hash.Md5Hash;

public class Md5Utils {

	private Md5Utils() {}
	public Md5Utils build() {
		return new Md5Utils();
	}
	public static String md5(String str, String salt) {
		return new  Md5Hash(str, salt).toString();
	}
	public static void main(String[] args) {
		System.out.println(md5("admin", "sports"));
	}
}
