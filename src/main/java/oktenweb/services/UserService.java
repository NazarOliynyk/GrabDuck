package oktenweb.services;

import oktenweb.models.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService{

    void save(User user);

    List<User> findAll();

    User findOneById(Integer id);

}

//package oktenweb.services;
//
//import oktenweb.dao.UserDAO;
//import oktenweb.models.Role;
//import oktenweb.models.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import javax.annotation.PostConstruct;
//import javax.validation.constraints.NotNull;
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class UserService implements UserDetailsService
//{
//
//    @Autowired
//    private UserDAO userDAO;
//    @Override
//    public UserDetails loadUserByUsername(@NotNull String userName) throws UsernameNotFoundException {
//
////        List<Role> roles = new ArrayList<>();
////        roles.add(Role.USER);
//
////        return User.builder()
////                .username("user")
////                .password("password")
////                .authorities(roles)
////                .accountNonExpired(true)
////                .accountNonLocked(true)
////                .credentialsNonExpired(true)
////                .enabled(true)
////                .build();
//       return userDAO.findByUsername(userName);
//    }
//
//    @PostConstruct
//    public void init(){
//        List<Role> roles = new ArrayList<>();
//        roles.add(Role.USER);
//       // if(!userDAO.findByUsername("user").isPresent())
//        userDAO.save(User.builder()
//                .username("user")
//                .password("password")
//                .authorities(roles)
//                .accountNonExpired(true)
//                .accountNonLocked(true)
//                .credentialsNonExpired(true)
//                .enabled(true)
//                .build());
//    }
//}
