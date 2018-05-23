package pl.narodzinyprogramsity.readers;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;
import pl.narodzinyprogramsity.models.Agency;
import pl.narodzinyprogramsity.parsers.AgencyParser;
import pl.narodzinyprogramsity.repository.AgencyRepository;

import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class AgencyReaderTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private AgencyReader agencyReader;
    private AgencyRepository agencyRepository;



    @Before
    public void setUp() {
        agencyRepository = new AgencyRepository();
        agencyReader = new AgencyReader(agencyRepository, new AgencyParser());
    }

    @Test
    public void readTest() throws IOException {
        agencyReader.read();
        List<Agency> agencies = agencyRepository.getAll();

        assertThat(agencies).isNotEmpty();
        assertThat(agencies.size()).isEqualTo(1);
        assertThat(agencies.get(0)).isInstanceOf(Agency.class);
    }

    @Test
    public void errorFileTest() throws IOException {
        AgencyReader spyReader = Mockito.spy(agencyReader);
        when(spyReader.getFileDir()).thenReturn("errorFile.txt");

        thrown.expect(NoSuchFileException.class);
        spyReader.read();
    }
}