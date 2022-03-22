package guru.springframework.sfgpetclinic.controllers;

import java.io.FileNotFoundException;

public class IndexController {

    public String index(){

        return "index";
    }

    public String oopsHandler() throws FileNotFoundException {

        throw new FileNotFoundException();

    }
}
