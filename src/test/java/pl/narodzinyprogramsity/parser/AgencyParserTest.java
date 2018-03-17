package pl.narodzinyprogramsity.parser;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import pl.narodzinyprogramsity.models.Agency;
import pl.narodzinyprogramsity.exceptions.NotCorrectLineException;

import static org.assertj.core.api.Assertions.assertThat;

public class AgencyParserTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    private AgencyParser agencyParser;
    private Agency testAgency;

    @Before
    public void setUp() {
        agencyParser = new AgencyParser();
        testAgency = new Agency("ZDiTM Szczecin", "http://www.zditm.szczecin.pl", "Europe/Warsaw", "pl", "91 480 04 03");
    }

    @Test
    public void agencyParseTest() throws NotCorrectLineException {
        Agency agency = agencyParser.parseTo("ZDiTM Szczecin,http://www.zditm.szczecin.pl,Europe/Warsaw,pl,91 480 04 03");

        assertThat(agency).isEqualTo(testAgency);
    }

    @Test
    public void agencyParseWrongLineTest() throws NotCorrectLineException {
        thrown.expect(NotCorrectLineException.class);
        thrown.expectMessage("This line is broken");

        agencyParser.parseTo("ZDiTM Szczecin,http://www.zditm.szczecin.pl,Europe/Warsaw,pl");
        agencyParser.parseTo("ZDiTM Szczecin,http://www.zditm.szczecin.pl,Europe/Warsaw,91 480 04 03");
    }

    @Test
    public void agencyParseEmptyLineTest() throws NotCorrectLineException {
        Agency agency = agencyParser.parseTo(",,,,");

        assertThat(agency.getId()).isBlank();
        assertThat(agency.getAgencyLang()).isBlank();
        assertThat(agency.getAgencyPhone()).isBlank();
        assertThat(agency.getAgencyTimezone()).isBlank();
        assertThat(agency.getAgencyUrl()).isBlank();
    }

}