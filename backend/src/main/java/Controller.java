import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @RequestMapping("/tijana")
    public String sayHi(){
        return "Hello World!";
    }
}
