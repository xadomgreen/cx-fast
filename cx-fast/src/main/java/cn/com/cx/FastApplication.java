package cn.com.cx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author xdd
 * App启动入口
 */
@SpringBootApplication
@EnableEurekaClient // 注册到注册中心
public class FastApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(FastApplication.class, args);
	}

}
