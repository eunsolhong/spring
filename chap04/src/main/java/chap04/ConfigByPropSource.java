package chap04;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

@Configuration
@PropertySources(@PropertySource("classpath:/db.properties"))
public class ConfigByPropSource {

   @Value("${db.driver}")
   private String driver;
   @Value("${db.jdbcUrl}")
   private String jdbcUrl;
   @Value("${db.user}")
   private String user;
   @Value("${db.password}")
   private String password;

   @Bean
   public static PropertySourcesPlaceholderConfigurer properties() {
      PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
      configurer.setLocation(new ClassPathResource("db.properties"));
      return configurer;
   }

   @Bean
   public ConnectionProvider connectionProvider() {
      JdbcConnectionProvider connectionProvider = new JdbcConnectionProvider();
      connectionProvider.setDriver(driver);
      connectionProvider.setUrl(jdbcUrl);
      connectionProvider.setUser(user);
      connectionProvider.setPassword(password);
      return connectionProvider;
   }
}