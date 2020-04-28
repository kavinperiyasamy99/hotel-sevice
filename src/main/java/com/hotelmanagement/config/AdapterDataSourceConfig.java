package com.hotelmanagement.config;

import com.hotelmanagement.constant.AppConstant;
import com.hotelmanagement.io.DataSourceModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Map;





@Data
@NoArgsConstructor
@AllArgsConstructor
@Configuration
@Primary
@Slf4j
public class AdapterDataSourceConfig {



	@Value("${spring.profiles.active}")
	private String domain;
	
	@Value("${swagger.profile}")
	private String swaggerLibSwitch;
	
	@Autowired
	private Docket swaggerDocket;
	
	@Bean
	public synchronized DataSourceModel getDataSource() throws Exception {
		// if domain type is dev -> read from property file. If domain type is prod,
		// read from system environment.
		log.info("domain type : " + domain);
		DataSourceModel dataSourceModel = null;
		if (domain != null && !domain.isEmpty() && domain.equalsIgnoreCase("dev")) {
			log.info("DEV config proeprties start loading.");
			dataSourceModel = getDevelopmentDataSource();
			log.info("DEV config proeprties loaded.");
		} else {
			log.info("PROD config proeprties start loading.");
			dataSourceModel = getProductionDataSource();
			log.info("PROD config proeprties loaded.");
		}
		log.info("Swagger Docket Profile :: " + swaggerDocket.isEnabled());
		return dataSourceModel;
	}
	
	private DataSourceModel getProductionDataSource() {
		Map<String, String> env = System.getenv();
		swaggerLibSwitch = env.get(AppConstant.SWAGGER_PROFILE);
		if(swaggerLibSwitch!=null && !swaggerLibSwitch.isEmpty() && swaggerLibSwitch.equalsIgnoreCase("false")) {
			swaggerDocket.enable(false);
		}
		return DataSourceModel.builder()

				.build();
	}


	private DataSourceModel getDevelopmentDataSource() {
		if(swaggerLibSwitch!=null && !swaggerLibSwitch.isEmpty() && swaggerLibSwitch.equalsIgnoreCase("false")) {
			swaggerDocket.enable(false);
		}
		return DataSourceModel.builder()

				.build();
	}
	
}
