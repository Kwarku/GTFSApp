package pl.narodzinyprogramsity.parsers;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import pl.narodzinyprogramsity.exceptions.NotCorrectLineException;
import pl.narodzinyprogramsity.modelType.TransferType;
import pl.narodzinyprogramsity.models.Transfer;
import pl.narodzinyprogramsity.utils.CreateTransfer;

import static org.assertj.core.api.Assertions.assertThat;

public class TransferParserTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private Transfer testTransfer;
    private TransferParser parser;


    @Before
    public void setUp() {
        testTransfer = CreateTransfer.createTestTransfer();
        parser = new TransferParser();
    }

    @Test
    public void parseTest() throws NotCorrectLineException {
        Transfer transfer = parser.parseTo("10221,10112,2,320");

        assertThat(transfer).isEqualTo(testTransfer);
    }

    @Test
    public void parseBrokenLineTest() throws NotCorrectLineException {
        thrown.expect(NotCorrectLineException.class);

        parser.parseTo("10221,10112,2");
        parser.parseTo("10221,10112,320");
        parser.parseTo("2,320");
    }

    @Test
    public void parseEmptyLineTest() throws NotCorrectLineException {
        Transfer transfer = parser.parseTo(",,,");

        assertThat(transfer).isNotNull().isNotEqualTo(testTransfer);
        assertThat(transfer.getFromStopId()).isBlank();
        assertThat(transfer.getToStopId()).isBlank();
        assertThat(transfer.getMinTransferTime()).isBlank();
        assertThat(transfer.getTransferType()).isEqualByComparingTo(TransferType.RECOMMENDED);
    }
}