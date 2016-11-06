package com.tools.sewing.core.configuration;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by phoebe.yao on 2016/11/5.
 */
@Configuration
@AutoConfigureAfter(MybatisSewingConfiguration.class)
public class MyBatisMapperScannerConfig {

    @Bean(name="apiMapperScannerConfigurer")
    public MapperScannerConfigurer apiMapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        mapperScannerConfigurer.setBasePackage("com.tools.sewing.core.mapper");
        return mapperScannerConfigurer;
    }

}
