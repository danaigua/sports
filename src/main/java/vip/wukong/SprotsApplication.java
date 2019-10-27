package vip.wukong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SprotsApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(SprotsApplication.class, args);
	}
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(SprotsApplication.class);
	}
}

/**
 * 
 * @author 章家宝
部署的时候使用
@SpringBootApplication
public class SprotsApplication{
	public static void main(String[] args) {
		SpringApplication.run(SprotsApplication.class, args);
	}
}

*
*/