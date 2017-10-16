package com.crm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.crm")
@MapperScan("com.crm.biz.*.dao")
public class CrmApplication {

	public static void main(String[] args) {

		SpringApplication.run(CrmApplication.class, args);
	}
}