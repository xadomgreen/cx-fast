package cn.com.cx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Import;

import cn.com.cx.datasources.DynamicDataSourceConfig;

/**
 * @author xdd
 * App启动入口
 */
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@EnableEurekaClient // 注册到注册中心
@Import({DynamicDataSourceConfig.class})
public class FastApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(FastApplication.class, args);
	}

}
