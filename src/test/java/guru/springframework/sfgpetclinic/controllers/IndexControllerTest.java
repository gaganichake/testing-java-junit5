package guru.springframework.sfgpetclinic.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class IndexControllerTest {

    IndexController controller;

    @BeforeEach
    void setUp() {
        controller = new IndexController();
    }

    // Give a more meaningful name to you test. It will be displayed in the console logs as well.
    @DisplayName("Test Proper View name is returned for index page")
    @Test
    void index() {
        assertEquals("index", controller.index());
        //assertEquals("indexSSS", controller.index(), "Wrong View Returned");
        assertEquals("index", controller.index(), "Wrong View Returned");
    }

    @Test
    @DisplayName("Test Handler")
    void oopsHandler() {

        assertThrows(FileNotFoundException.class, () -> controller.oopsHandler());//Lambda save us from Exception handling
        //assertThrows(FileNotFoundException.class, controller.oopsHandler());// also try this

        //assertEquals("zzzz", controller.oopsHandler(), () -> "This is a very expensive message to build for my test. Using Lambda expression llows JUnit5 to evaluate it only in a failure condition");
        //assertEquals("notimplemented", controller.oopsHandler(), () -> "This is a very expensive message to build for my test. Using Lambda expression llows JUnit5 to evaluate it only in a failure condition");

    }
}