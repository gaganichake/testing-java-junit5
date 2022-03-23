package guru.springframework.sfgpetclinic.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import java.io.FileNotFoundException;
import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

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

    @Disabled("Disabling the failed test case of Timeout")
    @Test
    void testTimeout(){
        assertTimeout(Duration.ofMillis(100), () -> {
            Thread.sleep(5000);// Simulating the behaviour that some code finished execution in 5 seconds
            System.out.println("I will run for full 5 seconds even if code does not finish execution in 100 milliseconds");
        });
    }

    @Disabled("Disabling the failed test case of Preemptive Timeout")
    @Test
    void testTimeoutPremp(){
        assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
            Thread.sleep(5000);// Simulating the behaviour that some code finished execution in 5 seconds
            System.out.println("I will try to terminate immediately if code does not finish execution in 100 milliseconds");
        });
    }

    // With Assumptions tests are aborted if they fail and not counted as failed
    @Test
    void testAssumptionProdTrue(){

        assumeTrue("Prod".equalsIgnoreCase(System.getenv("SERVER")));// Frequently used to test running environment
    }

    // With Assumptions tests are aborted if they fail and not counted as failed
    @Test
    void testAssumptionQATrue(){

        assumeTrue("QA".equalsIgnoreCase("QA"));
    }

    @EnabledOnOs(OS.MAC)
    @Test
    void testMeOnMacOS(){

    }

    @EnabledOnOs(OS.WINDOWS)
    @Test
    void testMeOnWindows(){

    }

    @EnabledOnJre(JRE.JAVA_8)
    @Test
    void testMeOnJava8(){

    }

    @EnabledOnJre(JRE.JAVA_11)
    @Test
    void testMeOnJava11(){

    }

    @EnabledIfEnvironmentVariable(named = "USER", matches = "jt")
    @Test
    void testIfUserJT(){

    }

    @EnabledIfEnvironmentVariable(named = "USER", matches = "gaganichake")
    @Test
    void testIfUserGagan(){

    }

    @Test
    void testUsingAssertj(){
        assertThat(controller.index()).isEqualTo("index");
    }
}