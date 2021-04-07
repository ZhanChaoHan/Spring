package com.jachs.rest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

/***
 * 
 * @author zhanchaohan
 * @see https://docs.spring.io/spring-data/rest/docs/3.4.7/reference/html/#getting-started.setting-repository-detection-strategy
 */
@Configuration
public class CustomRestMvcConfiguration implements RepositoryRestConfigurer {
	@Bean
	public RepositoryRestConfigurer repositoryRestConfigurer() {
		return new RepositoryRestConfigurer() {
			@Override
			public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
				/***
				 * 效果等同配置文件里的:spring.data.rest.basePath=/api
				 */
				config.setBasePath("/api");
				
				config.setDefaultMediaType(MediaType.ALL);
				config.setDefaultPageSize(10);
				
			}
		};
	}
}
