package oktenweb.configurations;

import oktenweb.services.UserService;
import oktenweb.models.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.annotation.PostConstruct;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class AdminAuthFilter extends GenericFilterBean {
    @Autowired
    private UserService userService;
    @PostConstruct
    private void init(){
        List<Role> roles = new ArrayList<>();
        roles.add(Role.ROLE_USER);
        userService.save(User.builder()
                .username("user")
                .password("password")
                .authorities(roles)
                .accountNonExpired(true)
                .accountNonLocked(true)
                .credentialsNonExpired(true)
                .enabled(true)
                .build());
    }
    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        Authentication holder =
                SecurityContextHolder.getContext().setAuthentication(new UserAuthentication());
        filterChain.doFilter(servletRequest, servletResponse);

    }
}
