package pl.narodzinyprogramsity.readers;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;
import pl.narodzinyprogramsity.models.Transfer;
import pl.narodzinyprogramsity.parsers.TransferParser;
import pl.narodzinyprogramsity.repository.TransferRepository;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class TransferReaderTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private TransferRepository repository;
    private TransferReader spyReader;

    @Before
    public void setUp() {
        repository = new TransferRepository();

        spyReader = Mockito.spy(new TransferReader(repository, new TransferParser()));
        when(spyReader.getFileDir()).thenReturn("./test-resources/test-transfers.txt");
    }

    @Test
    public void readTest() throws IOException {
        spyReader.read();

        List<Transfer> transfers = repository.getAll();

        assertThat(transfers).isNotEmpty();
        assertThat(transfers.size()).isEqualTo(10);
    }

    @Test
    public void wrongDirFileTest() throws IOException {
        when(spyReader.getFileDir()).thenReturn("wrong file dir test");

        thrown.expect(IOException.class);

        spyReader.read();
    }
}