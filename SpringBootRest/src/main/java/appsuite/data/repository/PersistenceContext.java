/*
 * package appsuite.data.repository;
 * 
 * import javax.sql.DataSource;
 * 
 * import org.hibernate.cfg.Environment; import
 * org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration;
 * 
 * @Configuration class PersistenceContext {       @Bean(destroyMethod =
 * "close")     DataSource dataSource(Environment env) {         HikariConfig
 * dataSourceConfig = new HikariConfig();
 *         dataSourceConfig.setDriverClassName(env.getRequiredProperty(
 * "db.driver"));
 *         dataSourceConfig.setJdbcUrl(env.getRequiredProperty("db.url"));
 *         dataSourceConfig.setUsername(env.getRequiredProperty("db.username"));
 *         dataSourceConfig.setPassword(env.getRequiredProperty("db.password"));
 *           return new HikariDataSource(dataSourceConfig);     }      
 *     //Add the other beans here }
 */