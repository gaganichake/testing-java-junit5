package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.ModelTests;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;

//@Tag("model")
class OwnerTest implements ModelTests {

    @Test
    void dependentAssertion(){

        Owner owner = new Owner(1L, "Joe", "Noe");
        owner.setCity("Chicago");
        owner.setTelephone("234234234");

        // We are asserting the super class properties and bases class properties in groups but together.
        assertAll("Dependent Property Set",
                () -> assertAll("Person Properties",
                        () -> assertEquals("Joe", owner.getFirstName(), "First name did not match"),
                        () -> assertEquals("Noe", owner.getLastName(), "Last name did not match")),
                () -> assertAll("Owner Properties",
                        () -> assertEquals("Chicago", owner.getCity(), "City did Not Match"),
                        () -> assertEquals("234234234", owner.getTelephone(), "Telephone did not match"))
        );
    }

    // Hamcrest library is older that Assertj and not maintained anymore. Found in legacy code.
    @Test
    void testUsingHamcrest(){

        Owner owner = new Owner(1L, "Joe", "Noe");
        owner.setCity("Chicago");

        assertThat(owner.getCity(), is("Chicago"));
    }
}