package pl.narodzinyprogramsity.parsers;

import pl.narodzinyprogramsity.models.Agency;
import pl.narodzinyprogramsity.exceptions.NotCorrectLineException;

public class AgencyParser extends BaseFeedParser<Agency> {


    private static final int AGENCY_NAME = 0;
    private static final int AGENCY_URL = 1;
    private static final int AGENCY_TIMEZONE = 2;
    private static final int AGENCY_LANG = 3;
    private static final int AGENCY_PHONE = 4;

    private static final int AGENCY_ELEMENTS = 5;

    public AgencyParser() {
        super(AGENCY_ELEMENTS);

    }

    @Override
    public Agency parseTo(String line) throws NotCorrectLineException {
        super.parseTo(line);
        Agency agency = new Agency();
        agency.setAgencyName(splitFeedInfo[AGENCY_NAME]);
        agency.setAgencyUrl(splitFeedInfo[AGENCY_URL]);
        agency.setAgencyTimezone(splitFeedInfo[AGENCY_TIMEZONE]);
        agency.setAgencyLang(splitFeedInfo[AGENCY_LANG]);
        agency.setAgencyPhone(splitFeedInfo[AGENCY_PHONE]);
        return agency;
    }
}
