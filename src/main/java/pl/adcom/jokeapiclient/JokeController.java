package pl.adcom.jokeapiclient;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class JokeController {

    RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/joke")
    public String getJokes(Model model){
        Joke forObject = restTemplate.getForObject("http://api.icndb.com/jokes/random/12", Joke.class);
        model.addAttribute("jokes", forObject);
        return "Index";
    }
}
