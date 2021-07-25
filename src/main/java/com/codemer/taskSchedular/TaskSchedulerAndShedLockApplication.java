package com.codemer.taskSchedular;





import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;
import net.javacrumbs.shedlock.provider.jdbctemplate.JdbcTemplateLockProvider;
import net.javacrumbs.shedlock.core.LockProvider;
import net.javacrumbs.shedlock.spring.annotation.EnableSchedulerLock;

@SpringBootApplication
@EnableScheduling
@EnableSchedulerLock(defaultLockAtMostFor = "PT30S")
public class TaskSchedulerAndShedLockApplication {

	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
	@Bean
    public LockProvider lockProvider(DataSource dataSource) {
        return new JdbcTemplateLockProvider(dataSource);
    }
	public static void main(String[] args) {
		SpringApplication.run(TaskSchedulerAndShedLockApplication.class, args);
		System.out.println("In the TASK schedular App it is running on port: 8086");
	}

}
