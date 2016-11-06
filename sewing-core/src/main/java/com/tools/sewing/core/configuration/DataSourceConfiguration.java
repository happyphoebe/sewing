package com.tools.sewing.core.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
@EnableConfigurationProperties
public class DataSourceConfiguration {

	private final static Logger logger = LoggerFactory.getLogger(DataSourceConfiguration.class);
	
    @Bean(name="sewingDataSource")
    @Qualifier("sewingDataSource")
    @Primary  
    @ConfigurationProperties(prefix="datasource.sewing", locations = "classpath:core-${spring.profiles.active}.properties")
    public DataSource primaryDataSource() {
    	logger.info("-------------------- datasource.sewing init ---------------------");
        return DataSourceBuilder.create().build();  
    }
    
    @Bean(name="extraDataSource")
    @Qualifier("extraDataSource")
    @ConfigurationProperties(prefix="datasource.extra", locations = "classpath:core-${spring.profiles.active}.properties")
    public DataSource extraDataSource() {
    	logger.info("-------------------- datasource.extra init ---------------------");
        return DataSourceBuilder.create().build();
    }

}
