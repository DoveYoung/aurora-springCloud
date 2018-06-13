package com.aurora.provider.user.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;


/**
 * 自动检测现有的数据源。
 * 将创建并注册的一个实例的SqlSessionFactory传递一个数据源作为使用输入SqlSessionFactoryBean的。
 * 将创建并注册SqlSessionFactory的SqlSessionTemplate实例。
 * 自动扫描您的映射器，将它们链接到SqlSessionTemplate并将它们注册到Spring上下文，以便将它们注入到bean中。
 * @author BYG
 *
 */

@Configuration
public class MybatisConfig {

	
	@Bean
    public DataSourceTransactionManager transactionManager() throws Exception {
		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
		transactionManager.setDataSource(dataSource());
		return transactionManager;
    }
	
	@Bean
	protected DruidDataSource  dataSource() throws Exception {
		
		final String driverClassName = "com.mysql.jdbc.Driver";
		//本地
		final String url = "jdbc:mysql://localhost:3306/aurora?useUnicode=true&characterEncoding=UTF-8&characterSetResults=UTF-8";
		final String username = "root";
		//password=123456;下面为druid加密后的密码
		final String password = "Biyu5YzU+6sxDRbmWEa3B2uUcImzDo0BuXjTlL505+/pTb+/0Oqd3ou1R6J8+9Fy3CYrM18nBDqf6wAaPgUGOg==";    	
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		dataSource.setFilters("wall,config");
//		dataSource.setProxyFilters(proxyFilters());
		dataSource.setConnectionProperties("config.decrypt=true");
		dataSource.setMaxActive(20);
		dataSource.setInitialSize(1);
		dataSource.setMaxWait(60000);
		dataSource.setMinIdle(1);
		dataSource.setTimeBetweenEvictionRunsMillis(60000);
		dataSource.setMinEvictableIdleTimeMillis(300000);
		dataSource.setValidationQuery("SELECT 'x'");
		dataSource.setTestOnBorrow(false);
		dataSource.setTestWhileIdle(true);
		dataSource.setTestOnReturn(false);
		dataSource.setMaxOpenPreparedStatements(50);
//		dataSource.setStatLogger(new MyDruidLogger());
		dataSource.setTimeBetweenLogStatsMillis(30000000);
		dataSource.setRemoveAbandoned(true);
		dataSource.setRemoveAbandonedTimeout(1800);
		dataSource.setLogAbandoned(true);
		return dataSource;
	}
	
	@Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
//		PathMatchingResourcePatternResolver pathMatchingResourcePatternResolver = new PathMatchingResourcePatternResolver();        
//        String mapperLocationsPath = "classpath:com/aurorascm/**/*.xml";
//        sqlSessionFactoryBean.setMapperLocations(pathMatchingResourcePatternResolver.getResources(mapperLocationsPath));
        sqlSessionFactoryBean.setDataSource(dataSource());
        sqlSessionFactoryBean.setTypeAliasesPackage("com.aurora.provider.entity");
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setMapUnderscoreToCamelCase(true);
        configuration.setDefaultFetchSize(100);
        configuration.setDefaultStatementTimeout(30);
        sqlSessionFactoryBean.setConfiguration(configuration);
		return sqlSessionFactoryBean.getObject();
    }
	
	@Bean
    public SqlSessionTemplate sqlSessionTemplate() throws Exception {
		SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory());
		return sqlSessionTemplate;
    }
	
	/**
	 * druid proxyFilters
	 * @return
	 * @throws Exception
	 */
//    public List<Filter> proxyFilters() throws Exception {
//    	
//    	List<Filter> pFilters = new ArrayList<>();
//    	StatFilter stat = new StatFilter();
//    	stat.setSlowSqlMillis(300);
//    	stat.setLogSlowSql(true);
//    	stat.setMergeSql(true);
//    	Log4jFilter log = new Log4jFilter();
//    	log.setStatementExecutableSqlLogEnable(true);
//    	pFilters.add(stat);
//    	pFilters.add(log);
//		return pFilters;
//        
//    }
	
}
