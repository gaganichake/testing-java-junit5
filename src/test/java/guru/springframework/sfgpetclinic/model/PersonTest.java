package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.ModelTests;
import org.junit.jupiter.api.*;

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
    void myRepeatedTest(){
        //TODO
    }

    // You can play with formatting
    @RepeatedTest(value = 10, name = "{displayName} : {currentRepetition} - {totalRepetitions}")
    @DisplayName("My Repeated Test")
    void myRepeatedTestVersion2(){
        //TODO
    }

    @RepeatedTest(5)
    @DisplayName("My Repeated Test With Dependency Injection")
    void myRepeatedTestWithDependencyInjection(TestInfo testInfo, RepetitionInfo repeatedInfo){
        System.out.println(testInfo.getDisplayName() + ": " + repeatedInfo.getCurrentRepetition() + " - " + repeatedInfo.getTotalRepetitions());
    }

}