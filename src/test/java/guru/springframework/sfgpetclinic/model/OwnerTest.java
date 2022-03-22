package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OwnerTest {

    @Test
    void dependentAssertion(){

        Owner owner = new Owner(1L, "Joe", "Noe");
        owner.setCity("Chicago");
        owner.setTelephone("234234234");

        // We are asserting the super class properties and bases class properties in groups but together.
        assertAll("Dependent Properrty Set",
                () -> assertAll("Person Properties",
                        () -> assertEquals("Joe", owner.getFirstName(), "First name did not match"),
                        () -> assertEquals("Noe", owner.getLastName(), "Last name did not match")),
                () -> assertAll("Owner Properties",
                        () -> assertEquals("Chicago", owner.getCity(), "City did Not Match"),
                        () -> assertEquals("234234234", owner.getTelephone(), "Telephone did not match"))
        );
    }
}