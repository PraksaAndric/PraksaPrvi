package rs.in.andric.demo.PraksaPrvi.Controller;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@CrossOrigin("http://localhost:4200")
public class LoginController {

    private static Logger logger = LogManager.getLogger();

    @GetMapping
    public String login(){
        logger.info("Successfully login!");
        return "Successfully!";
    }

}
