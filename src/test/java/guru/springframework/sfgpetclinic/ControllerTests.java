package guru.springframework.sfgpetclinic;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestInstance;

@Tag("controller")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public interface ControllerTests {

    // Try to run this without @TestInstance configured. @BeforeAll method must be static.
    @BeforeAll
    default void setUpAll() {
        System.out.println("Lets do something here Before All test run under controller. This default Interface method can be useful");
    }
}
