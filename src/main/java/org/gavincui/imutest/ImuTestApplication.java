package org.gavincui.imutest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableJpaRepositories
@EnableScheduling   // 1.开启定时任务
@EnableAsync        // 2.开启多线程
public class ImuTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImuTestApplication.class, args);
	}

}
