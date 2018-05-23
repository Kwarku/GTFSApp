package pl.narodzinyprogramsity.models;

import pl.narodzinyprogramsity.utils.TextUtils;

import java.util.Objects;

public class Agency extends FeedModel {
    public static Agency NOT_FOUND = new Agency();

    private String agencyName;
    private String agencyUrl;
    private String agencyTimezone;
    private String agencyLang;
    private String agencyPhone;

    public Agency() { super(TextUtils.EMPTY_STRING);}

    public Agency(String agencyName,
                  String agencyUrl,
                  String agencyTimezone,
                  String agencyLang,
                  String agencyPhone) {

        super(TextUtils.EMPTY_STRING);
        this.agencyName = agencyName;
        this.agencyUrl = agencyUrl;
        this.agencyTimezone = agencyTimezone;
        this.agencyLang = agencyLang;
        this.agencyPhone = agencyPhone;
    }

    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    public String getAgencyUrl() {
        return agencyUrl;
    }

    public void setAgencyUrl(String agencyUrl) {
        this.agencyUrl = agencyUrl;
    }

    public String getAgencyTimezone() {
        return agencyTimezone;
    }

    public void setAgencyTimezone(String agencyTimezone) {
        this.agencyTimezone = agencyTimezone;
    }

    public String getAgencyLang() {
        return agencyLang;
    }

    public void setAgencyLang(String agencyLang) {
        this.agencyLang = agencyLang;
    }

    public String getAgencyPhone() {
        return agencyPhone;
    }

    public void setAgencyPhone(String agencyPhone) {
        this.agencyPhone = agencyPhone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Agency agency = (Agency) o;
        return Objects.equals(agencyName, agency.agencyName) &&
                Objects.equals(agencyUrl, agency.agencyUrl) &&
                Objects.equals(agencyTimezone, agency.agencyTimezone) &&
                Objects.equals(agencyLang, agency.agencyLang) &&
                Objects.equals(agencyPhone, agency.agencyPhone);
    }

    @Override
    public int hashCode() {

        return Objects.hash(agencyName,
                agencyUrl,
                agencyTimezone,
                agencyLang,
                agencyPhone);
    }

    @Override
    public String toString() {
        return "Agency{" +
                "id='" + id + '\'' +
                ", agencyName='" + agencyName + '\'' +
                ", agencyUrl='" + agencyUrl + '\'' +
                ", agencyTimezone='" + agencyTimezone + '\'' +
                ", agencyLang='" + agencyLang + '\'' +
                ", agencyPhone='" + agencyPhone + '\'' +
                '}';
    }
}
