package com.tools.sewing.core.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
@EnableJpaRepositories(entityManagerFactoryRef="entityManagerFactoryExtraDataSource",
	transactionManagerRef="transactionManagerExtraDataSource",basePackages= { "com.tools.sewing.core.dao.extra" })
public class JpaExtraConfiguration {

	@Autowired
    private JpaProperties jpaProperties;

    @Autowired
    @Qualifier("extraDataSource")
    private DataSource dataSource;

    private Map<String, String> getVendorProperties(DataSource dataSource) {
        return jpaProperties.getHibernateProperties(dataSource);
    }

    @Bean(name = "entityManagerFactoryExtraDataSource")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryExtraDataSource (EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(dataSource)
                .properties(getVendorProperties(dataSource))
                .packages("com.tools.sewing.core.po.extra")
                .persistenceUnit("extraDataSourcePersistenceUnit")
                .build();
    }

    @Bean(name = "entityManagerExtraDataSource")
    public EntityManager entityManagerExtraDataSource(EntityManagerFactoryBuilder builder) {
        return entityManagerFactoryExtraDataSource(builder).getObject().createEntityManager();
    }

    @Bean(name = "transactionManagerExtraDataSource")
    PlatformTransactionManager transactionManagerPrimary(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactoryExtraDataSource(builder).getObject());
    }
}
