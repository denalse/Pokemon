package sg.edu.nus.iss.app.day8Pokemon.model;

import java.util.LinkedList;
import java.util.List;

public class pokemonModel {
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<String> getImages() {
        return images;
    }
    public void setImages(List<String> images) {
        this.images = images;
    }
    private List<String> images = new LinkedList<>();

}
