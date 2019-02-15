package oktenweb.controllers;

import oktenweb.dao.UserDAO;
import oktenweb.models.User;
import oktenweb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/")
    public String getMainPage(Model model){
        Authentication holder = SecurityContextHolder.getContext().getAuthentication();
        Object details = holder.getDetails();
        User user = (User) holder.getPrincipal();
        model.addAttribute("username", user.getUsername());
        model.addAttribute("role", user.getAuthorities());


        return "index";
    }

    @RequestMapping("/form")
    public String getFormPage(){
        return "form";
    }
    @RequestMapping("/login")
    public String getLoginPage(){
        return "login";
    }

    @RequestMapping("/successURL")
    public String getSuccessPage(){
        return "index";
    }

    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/saveUser")
    public String saveUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword())); // to encode the pass
        userService.save(user);
        return "redirect:/login";
    }
}
