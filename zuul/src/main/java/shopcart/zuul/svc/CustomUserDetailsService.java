package shopcart.zuul.svc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import shopcart.zuul.model.User;
import shopcart.zuul.repo.UserRepository;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component
@Qualifier("custom")
public class CustomUserDetailsService implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder pw;

    @Override
    public UserDetails loadUserByUsername(String loginName) throws UsernameNotFoundException {

        User user = userRepository.findOne(loginName);
        logger.info("Loading user " + loginName + " from Mongo ");

        if (user == null) {
            logger.warn("User " + loginName + " not found");
            throw new UsernameNotFoundException(loginName);
        }
        return user;
    }

    @PostConstruct
    public void setupUsers() {

        userRepository.save(Arrays.asList(
            new User("dave", pw.encode("atlantis"), "Dave MacDonald"),
            new User("buzz", pw.encode("moon"), "Buzz Aldrin")
        ));

    }

}
