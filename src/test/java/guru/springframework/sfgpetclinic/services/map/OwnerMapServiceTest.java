package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.services.PetService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

//Using DisplayName to show Nested Test hierarchy
@DisplayName("Owner Map Service Test -")
class OwnerMapServiceTest {

    OwnerMapService ownerMapService;
    PetTypeService petTypeService;
    PetService petService;

    @BeforeEach
    void setUp() {
        petTypeService = new PetTypeMapService();
        petService = new PetMapService();
        ownerMapService = new OwnerMapService(petTypeService, petService);
    }

    @DisplayName("Verify Zero Owners")
    @Test
    void ownersAreZero(){
        int ownerCount = ownerMapService.findAll().size();
        assertThat(ownerCount).isZero();
    }

    // @Nested applies only to classes
    @DisplayName("Pet Type -")
    @Nested
    class TestCreatePetTypes {

        @BeforeEach
        void setUp() {
            petTypeService.save(new PetType(1L, "Dog"));
            petTypeService.save(new PetType(2L, "Cat"));
        }

        @DisplayName("Test Pet Type Count")
        @Test
        void testPetTypeCount(){
            int petTypeCount = petTypeService.findAll().size();
            assertThat(petTypeCount).isNotZero().isEqualTo(2);
        }

        @DisplayName("Save Owners Test -")
        @Nested
        class SaveOwnerTests {

            @BeforeEach
            void setUp() {
                ownerMapService.save(new Owner(1L, "Joe", "Buck"));
            }

            @DisplayName("Save Owner")
            @Test
            void saveOwner(){
                Owner owner = ownerMapService.save(new Owner(2L, "Joe", "Buck"));
                assertThat(owner).isNotNull();
            }

            @DisplayName("Find Owner Tests -")
            @Nested
            class FindOwnerTests {

                @DisplayName("Owner Found")
                @Test
                void findOwner(){

                    Owner owner = ownerMapService.findById(1L);
                    assertThat(owner).isNotNull();
                }

                @DisplayName("Owner Not Found")
                @Test
                void findOwnerNotFound(){
                    Owner owner = ownerMapService.findById(2L);// @BeforeEach clean-up '2L'
                    assertThat(owner).isNull();
                }
            }
        }
    }

    @DisplayName("Verify Still Zero Owners")
    @Test
    void ownersAreStillZero() {
        int ownerCount = ownerMapService.findAll().size();
        assertThat(ownerCount).isZero();
    }

//    @Test
//    void findAll() {
//    }
//
//    @Test
//    void findById() {
//    }
//
//
//    @Test
//    void save() {
//    }
//
//    @Test
//    void delete() {
//    }
//
//    @Test
//    void deleteById() {
//    }
//
//    @Test
//    void findByLastName() {
//    }
//
//    @Test
//    void findAllByLastNameLike() {
//    }
}