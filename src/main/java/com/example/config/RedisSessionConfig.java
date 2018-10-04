package com.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
/**
 * spring boot session 配置redisSession共享，什么都不写,默认读配置，如要加入自定义配置，加入下面@Bean就行
 * @author zhang
 *
 */
@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds=60)
public class RedisSessionConfig {

/*	@Bean
	public LettuceConnectionFactory redisConnectionFactory() {
		
		RedisStandaloneConfiguration config = new RedisStandaloneConfiguration("localhost",6379);
		config.setPassword(RedisPassword.of("zhang983521"));
		LettuceConnectionFactory lettuceConnectionFactory = new LettuceConnectionFactory(config);
		return lettuceConnectionFactory;
	}
*/
}