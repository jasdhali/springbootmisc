package com.spring.indicators;

import javax.sql.DataSource;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.jdbc.DataSourceHealthIndicator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class IndicatorConfig {

	@Autowired(required = false)
	private DataSource dataSource;

	@Bean
	@Primary
	public DataSourceHealthIndicator dataSourceHealthIndicator() {
	    return new DataSourceHealthIndicator(dataSource, "SELECT 'xyz' FROM DUAL");
	}
}
