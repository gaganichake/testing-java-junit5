package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.ModelRepeatedTest;
import org.junit.jupiter.api.*;

@Tag("model_repeated")
public class PersonRepeatedTest implements ModelRepeatedTest {

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
        //System.out.println(testInfo.getDisplayName() + ": " + repeatedInfo.getCurrentRepetition() + " - " + repeatedInfo.getTotalRepetitions());
    }

    @RepeatedTest(value = 5, name = "{displayName} : {currentRepetition} | {totalRepetitions}")
    @DisplayName("My Repeated Test Assignment")
    void myRepeatedTestAssignment(){
        //TODO
    }
}
