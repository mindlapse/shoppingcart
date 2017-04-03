package shopcart.zuul.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import shopcart.zuul.model.User;
import shopcart.zuul.svc.CustomUserDetailsService;

import javax.servlet.http.HttpSession;

@RestController
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private CustomUserDetailsService loginService;

    @PostMapping(path="/test")
    public void test(@AuthenticationPrincipal User user, HttpSession session, @RequestHeader HttpHeaders headers) {
        logger.info(user.toString());
        logger.info(headers.toString());
    }


    @GetMapping(path="/t1")
    public String test(@AuthenticationPrincipal User user) {
        logger.info(user.toString());
        return "t1";

    }

    @GetMapping(path="/t2")
    public String test() {
        return "t2";
    }
}
