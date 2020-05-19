package rs.in.andric.demo.PraksaPrvi.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@CrossOrigin("http://localhost:4200")
public class LoginController {

    @GetMapping
    public String login(){
        return "Successfully!";
    }

}
