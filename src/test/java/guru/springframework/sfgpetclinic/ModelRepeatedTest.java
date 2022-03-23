package guru.springframework.sfgpetclinic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestInfo;

public interface ModelRepeatedTest {

    @BeforeEach
    default void setUp(TestInfo testInfo, RepetitionInfo repetitionInfo) {
        System.out.println("Running test - "
                + testInfo.getDisplayName()
                + " - " +  repetitionInfo.getCurrentRepetition()
                + " | " + repetitionInfo.getTotalRepetitions());
    }
}
