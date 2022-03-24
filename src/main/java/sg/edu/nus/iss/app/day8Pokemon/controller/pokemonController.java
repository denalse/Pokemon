package sg.edu.nus.iss.app.day8Pokemon.controller;

import java.util.ArrayList;

import org.slf4j.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sg.edu.nus.iss.app.day8Pokemon.service.pokemonService;

@Controller
@RequestMapping(path="/pokemon")
public class pokemonController {
    private Logger logger = LoggerFactory.getLogger(pokemonController.class);
    
    @Autowired
    private pokemonService pokemonSvc;

    @GetMapping
    public String showSearchPage(){
        return "index";
    }

    @GetMapping("/search")
    public String search(
        @RequestParam (name= "pokemon_name")  String pokemonName, Model model) {

        ArrayList<String> result = pokemonSvc.getPokemonByName(pokemonName);
        logger.info(" Result >>> " + "\r\n" + result);
        System.out.printf(">>>>>>>> %s\n", result);

        // String result2 = pokemonSvc.getPokemonByName(pokemonName);
        // logger.info("Result2 >>> " + result2);
        // System.out.printf(">>>>>>>> %s\n \r\n", result2);

        model.addAttribute("pokemonName", pokemonName.toUpperCase());
        model.addAttribute("image", result);
        // model.addAttribute("image2", result2);


        return "searchResult";
    }



}
