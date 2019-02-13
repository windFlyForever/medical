package com.remamed.medical;


import org.apache.log4j.Logger;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.remamed.medical"})
@MapperScan("com.remamed.medical.mapper")
public class MedicalProApplication {

	private static Logger logger=Logger.getLogger(MedicalProApplication.class);

	public static void main(String[] args) {

		SpringApplication.run(MedicalProApplication.class, args);
		logger.info("项目启动成功-------------------trr");
	}

}

