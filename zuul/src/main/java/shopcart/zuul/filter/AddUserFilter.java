package shopcart.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import shopcart.zuul.model.User;

@Component
public class AddUserFilter extends ZuulFilter {

    private static final String HEADER_USER = "USER";

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext rc = RequestContext.getCurrentContext();

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Object myUser = (auth != null) ? auth.getPrincipal() : null;

        if (myUser != null && myUser instanceof User) {
            User user = (User) myUser;

            rc.addZuulRequestHeader(HEADER_USER, user.getUsername());
        }
        return null;
    }
}