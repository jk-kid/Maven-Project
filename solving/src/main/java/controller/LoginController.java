package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model; // ✅ Correct import

import Service.LoginService;
import domain.Login; // ✅ Use the same Login class as your entity

@Controller
public class LoginController {

    @Autowired
    private LoginService service;

    @GetMapping("/")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String processLogin(@RequestParam String username,
                               @RequestParam String password,
                               Model model) {
        Login user = service.log(username, password); // ✅ Use domain.Login
        if (user != null) {
            return "redirect:/welcome";
        } else {
            model.addAttribute("error", "Invalid username or password"); // ✅ No casting needed
            return "login";
        }
    }

    @GetMapping("/welcome")
    public String showWelcomePage() {
        return "welcome";
    }
}
