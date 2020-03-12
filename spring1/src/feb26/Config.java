package feb26;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feb24.AuthFailLogger;
import feb24.AuthenticationService;
import feb24.PasswordChangeService;
import feb24.User;
import feb24.UserRepository;

@Configuration
public class Config {

	@Bean
	public User user1() {
		return new User("bkchoi", "1234");
	}

	@Bean(name = "user2")
	public User user() {
		return new User("madvirus", "qwer");
	}

	@Bean
	public UserRepository userRepository() {
		UserRepository userRepo = new UserRepository();
		userRepo.setUsers(Arrays.asList(user1(), user()));
		return userRepo;
	}

	@Bean
	public PasswordChangeService pwChangSvc() {
		return new PasswordChangeService(userRepository());
	}

	@Bean
	public AuthFailLogger authFailLogger() {
		AuthFailLogger logger = new AuthFailLogger();
		logger.setThreshold(2);
		return logger;
	}

	@Bean
	public AuthenticationService authenticationService() {
		AuthenticationService authSvc = new AuthenticationService();
		authSvc.setFailLogger(authFailLogger());
		authSvc.setUserRepository(userRepository());
		return authSvc;
	}

}
