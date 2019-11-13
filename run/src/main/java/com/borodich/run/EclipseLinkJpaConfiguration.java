package com.borodich.run;

import org.eclipse.persistence.config.PersistenceUnitProperties;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.orm.jpa.JpaBaseConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.autoconfigure.transaction.TransactionManagerCustomizers;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.vendor.AbstractJpaVendorAdapter;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;
import org.springframework.transaction.jta.JtaTransactionManager;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

//@Configuration
public class EclipseLinkJpaConfiguration extends JpaBaseConfiguration {

    @Autowired
    protected EclipseLinkJpaConfiguration(DataSource dataSource, JpaProperties properties,
	    ObjectProvider<JtaTransactionManager> jtaTransactionManagerProvider,
	    ObjectProvider<TransactionManagerCustomizers> transactionManagerCustomizers) {
	super(dataSource, properties, jtaTransactionManagerProvider, transactionManagerCustomizers);
    }

    @Override
    protected AbstractJpaVendorAdapter createJpaVendorAdapter() {
	return new EclipseLinkJpaVendorAdapter();
    }

    @Override
    protected Map<String, Object> getVendorProperties() {
	Map<String, Object> map = new HashMap<>();
	map.put(PersistenceUnitProperties.WEAVING, "static");
	map.put(PersistenceUnitProperties.DDL_GENERATION, "none");
	return map;
    }
}