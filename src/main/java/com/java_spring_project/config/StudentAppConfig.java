package com.java_spring_project.config;

//import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.java_spring_project"})
public class StudentAppConfig implements WebMvcConfigurer{

	@Bean	
	public InternalResourceViewResolver viewResolver() {
	
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	@Bean
		public JdbcTemplate jdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());
			return jdbcTemplate;
	
	}

	@Bean
	public DataSource dataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/spring_java?useSSL=false");
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
	
		return dataSource;
	
}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
	
	
			registry
			.addResourceHandler("/reachResourcesFolders/**")
			.addResourceLocations("/resources/");
		
			registry
			.addResourceHandler("/reachResourcesImages/**")
			.addResourceLocations("/resources/images/");
			
	}
//	@Bean
	//public JavaMailSender getJavaMailSender() {
		//JavaMailSenderImpl javaMailSenderImpl = new JavaMailSenderImpl();
		//javaMailSenderImpl.setHost("smtp.gmail.com");
		//javaMailSenderImpl.setUsername("joyshreejavaspringproject@gmail.com");
		//javaMailSenderImpl.setPassword("javaspring");
		//javaMailSenderImpl.setPort(587);
		

		//Properties mailProperties = new Properties();
		//mailProperties.put("mail.smtp.starttls.enable", true);
		//mailProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");

		//javaMailSenderImpl.setJavaMailProperties(mailProperties);
		
		//return javaMailSenderImpl;
	//}
}
