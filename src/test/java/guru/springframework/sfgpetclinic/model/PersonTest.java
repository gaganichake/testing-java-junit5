package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.ModelTests;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//@Tag("model")
class PersonTest implements ModelTests {

    @Test
    void groupedAssertions(){
        // give
         Person person = new Person(1L, "Joe", "Noe");

        //then
        assertAll("Test Property Set",
                () -> assertEquals("Joe", person.getFirstName()),
                        () -> assertEquals("Noe", person.getLastName()));
        //Also, if at least one assertion fails, entire test case fails.
    }

    @Test
    void groupedAssertionsMessage(){
        // give
        Person person = new Person(1L, "Joe", "Noe");

        //then
        assertAll("Test Property Set",
                () -> assertEquals("Joe", person.getFirstName(), "First Name Failed"),
                () -> assertEquals("Noe", person.getLastName(), "Last Name Failed"));
        //Only the failed assertion within the group will be displayed on the console with the message.
    }

    @RepeatedTest(10)
    @DisplayName("My Repeated Test")
    @Test
    void myRepeatedTest(){
        //TODO
    }

    // You can play with formatting
    @RepeatedTest(value = 10, name = "{displayName} : {currentRepetition} - {totalRepetitions}")
    @DisplayName("My Repeated Test")
    @Test
    void myRepeatedTestVersion2(){
        //TODO
    }

}