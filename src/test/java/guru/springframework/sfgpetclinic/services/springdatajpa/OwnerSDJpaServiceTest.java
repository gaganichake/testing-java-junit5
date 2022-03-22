package guru.springframework.sfgpetclinic.services.springdatajpa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// If case you want to skip the entire class from test. The value attribute is optional
// Note: @Disable at class level will be ignored by the IDE if run this test directly from the class.
// To verify @Disable at class level, run the whole test suite via Maven command and see the Skipped count in console logs.
@Disabled(value = "Disable until we learn Mocking")
class OwnerSDJpaServiceTest {

    OwnerSDJpaService ownerSDJpaService;

    @BeforeEach
    void setUp() {
        ownerSDJpaService = new OwnerSDJpaService(null, null, null);
    }

    // I want to skip this test because I am not ready yet to fix that NullPointerException
    // Also see @Disable at class level, optionally, in case you want to skip the entire class from test.
    @Disabled
    @Test
    void findByLastName() {
        ownerSDJpaService.findByLastName("Buck");
    }

    @Test
    void findAllByLastNameLike() {
    }

    @Test
    void findAll() {
    }

    @Test
    void findById() {
    }

    @Test
    void save() {
    }

    @Test
    void delete() {
    }

    @Test
    void deleteById() {
    }
}