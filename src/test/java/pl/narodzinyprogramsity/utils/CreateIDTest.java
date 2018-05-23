package pl.narodzinyprogramsity.utils;

import org.junit.Ignore;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateIDTest {

    @Test @Ignore
    public void crateIdTest() {
        String first = CreateID.createId();
        String second = CreateID.createId();


        assertThat(first).isNotEmpty().isEqualTo("randomId1");
        assertThat(second).isNotEmpty().isEqualTo("randomId2");
    }
}