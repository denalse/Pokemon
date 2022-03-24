package sg.edu.nus.iss.app.day8Pokemon.service;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import org.slf4j.*;

import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;



@Service
public class pokemonService {
    Logger logger = LoggerFactory.getLogger(pokemonService.class);

    public ArrayList<String> getPokemonByName(String pokemonName) {
        
    
        String url = "https://pokeapi.co/api/v2/pokemon/" + pokemonName;
        
        RequestEntity<Void> req = RequestEntity
            .get(url)
            .accept(MediaType.APPLICATION_JSON)
            .build();
        

        RestTemplate template = new RestTemplate();
        ///String globalImg="test";
        ResponseEntity<String> resp = template.exchange(req, String.class);
        try (InputStream is = new ByteArrayInputStream(resp.getBody().getBytes())) {
            JsonReader reader = Json.createReader(is);
            JsonObject object = reader.readObject();
           
            System.out.println(object.getJsonObject("sprites").getJsonObject("versions").getJsonObject("generation-i").getJsonObject("red-blue").getJsonString("front_default"));
            String image = object.getJsonObject("sprites")
                .getJsonObject("versions") //key
                .getJsonObject("generation-i") //key
                .getJsonObject("red-blue") //key
                .getString("front_default"); //value
                System.out.printf("\r\n img>>> %s\n", image);

                //get string because is the last part which is the url which is the key
               //globalImg = image;
            System.out.println(" ");

            System.out.println(object.getJsonObject("sprites").getJsonObject("versions").getJsonObject("generation-ii").getJsonObject("crystal").getJsonString("front_shiny"));
            String image2 = object.getJsonObject("sprites")
                .getJsonObject("versions") //key
                .getJsonObject("generation-ii") //key
                .getJsonObject("crystal") //key
                .getString("back_shiny");
                System.out.printf("\r\n img>>> %s\n", image2);

            // System.out.println(object.getJsonObject("sprites").getJsonObject("versions").getJsonObject("generation-ii").getJsonObject("crystal").getJsonString("front_default"));
            String image3 = object.getJsonObject("sprites")
                .getJsonObject("versions") //key
                .getJsonObject("generation-iii") //key
                .getJsonObject("emerald") //key
                .getString("front_default");
                System.out.printf(">img>>> %s\n", image3);

            // System.out.println(object.getJsonObject("sprites").getJsonObject("versions").getJsonObject("generation-ii").getJsonObject("crystal").getJsonString("front_default"));
            String image4 = object.getJsonObject("sprites")
                .getJsonObject("versions") //key
                .getJsonObject("generation-iv") //key
                .getJsonObject("diamond-pearl") //key
                .getString("back_shiny");
            System.out.printf(">img>>> %s\n", image4);

            // System.out.println(object.getJsonObject("sprites").getJsonObject("versions").getJsonObject("generation-ii").getJsonObject("crystal").getJsonString("front_default"));
            String image5 = object.getJsonObject("sprites")
                .getJsonObject("versions") //key
                .getJsonObject("generation-ii") //key
                .getJsonObject("crystal") //key
                .getString("front_default");
                System.out.printf(">img>>> %s\n", image5);

            ArrayList<String> pokemonUrl = new ArrayList<String>();
            pokemonUrl.add(image);
            pokemonUrl.add(image2);
            pokemonUrl.add(image3);
            pokemonUrl.add(image4);
            pokemonUrl.add(image5);
            System.out.println("URL >>>>>" + pokemonUrl);
        
            logger.info("\r\n Image >>> " + image);
            logger.info("Image2 >>> " + image2);
            logger.info("Image >>> " + image3);
            // logger.info("Image >>> " + image4);
            // logger.info("Image >>> " + image5);

            return pokemonUrl;
            // return image + image2 + image3 + image4 + image5;

        } catch (Exception ex) {
           // System.out.printf("ERROR >>>>> ");
           ex.printStackTrace();
        }
        // System.out.printf(">outsidetryblock>>>");
            return null;
    }
    
}