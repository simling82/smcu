package com.rwh.smcu;

import com.rwh.smcu.core.base.SpringContextHolder;
import com.rwh.smcu.thread.ThreadStateModel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication
@EnableRedisHttpSession
@EnableCaching
public class SmcuApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SmcuApplication.class, args);
		SpringContextHolder.setApplicationContext(context);
		ThreadStateModel.getInstance().start();
	}
}
