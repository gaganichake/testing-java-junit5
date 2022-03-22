package guru.springframework.sfgpetclinic.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IndexControllerTest {

    IndexController controller;

    @BeforeEach
    void setUp() {
        controller = new IndexController();
    }

    @Test
    void index() {
        assertEquals("index", controller.index());
        //assertEquals("indexSSS", controller.index(), "Wrong View Returned");
        assertEquals("index", controller.index(), "Wrong View Returned");
    }

    @Test
    void oopsHandler() {
        //assertEquals("zzzz", controller.oopsHandler(), () -> "This is a very expensive message to build for my test. Using Lambda expression llows JUnit5 to evaluate it only in a failure condition");
        assertEquals("notimplemented", controller.oopsHandler(), () -> "This is a very expensive message to build for my test. Using Lambda expression llows JUnit5 to evaluate it only in a failure condition");

    }
}