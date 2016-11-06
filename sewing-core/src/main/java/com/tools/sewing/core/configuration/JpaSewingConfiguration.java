package com.tools.sewing.core.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef="entityManagerFactorySewingDataSource",
        transactionManagerRef="transactionManagerSewingDataSource",basePackages= { "com.tools.sewing.core.dao.sewing" })
public class JpaSewingConfiguration {

    @Autowired
    private JpaProperties jpaProperties;

    @Autowired
    @Qualifier("sewingDataSource")
    private DataSource dataSource;

    private Map<String, String> getVendorProperties(DataSource dataSource) {
        return jpaProperties.getHibernateProperties(dataSource);
    }

    @Bean(name = "entityManagerFactorySewingDataSource")
    @Primary
    public LocalContainerEntityManagerFactoryBean entityManagerFactorySewingDataSource (EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(dataSource)
                .properties(getVendorProperties(dataSource))
                .packages("com.tools.sewing.core.po.sewing")
                .persistenceUnit("sewingDataSourcePersistenceUnit")
                .build();
    }

    @Bean(name = "entityManagerSewingDataSource")
    @Primary
    public EntityManager entityManagerSewingDataSource(EntityManagerFactoryBuilder builder) {
        return entityManagerFactorySewingDataSource(builder).getObject().createEntityManager();
    }

    @Bean(name = "transactionManagerSewingDataSource")
    @Primary
    PlatformTransactionManager transactionManagerSewingDataSource(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactorySewingDataSource(builder).getObject());
    }
}
