/*
 * package appsuite.security;
 * 
 * import javax.sql.DataSource;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.core.annotation.Order; import
 * org.springframework.security.config.annotation.authentication.builders.
 * AuthenticationManagerBuilder; import
 * org.springframework.security.config.annotation.web.builders.HttpSecurity;
 * import org.springframework.security.config.annotation.web.configuration.
 * EnableWebSecurity; import
 * org.springframework.security.config.annotation.web.configuration.
 * WebSecurityConfigurerAdapter; import
 * org.springframework.security.web.AuthenticationEntryPoint;
 * 
 * @Order(2)
 * 
 * @Configuration
 * 
 * @EnableWebSecurity public class SpringDBSecurityConfig extends
 * WebSecurityConfigurerAdapter {
 * 
 * @Autowired private AuthenticationEntryPoint authEntryPoint;
 * 
 * @Autowired private DataSource dataSource;
 * 
 * @Override protected void configure(HttpSecurity http) throws Exception {
 * http.csrf().disable().authorizeRequests() .anyRequest().authenticated()
 * .and().httpBasic() .authenticationEntryPoint(authEntryPoint); }
 * 
 * @Autowired public void configureGlobal(AuthenticationManagerBuilder auth)
 * throws Exception {
 * //auth.inMemoryAuthentication().withUser("admin").password("admin").roles(
 * "USER"); auth.jdbcAuthentication().dataSource(dataSource); } }
 */