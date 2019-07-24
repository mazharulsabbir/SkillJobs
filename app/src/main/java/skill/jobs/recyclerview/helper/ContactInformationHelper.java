package skill.jobs.recyclerview.helper;

public class ContactInformationHelper {
    private String contactTitle, contact;

    public ContactInformationHelper() {
    }

    public ContactInformationHelper(String contactTitle, String contact) {
        this.contactTitle = contactTitle;
        this.contact = contact;
    }

    public String getContactTitle() {
        return contactTitle;
    }

    public void setContactTitle(String contactTitle) {
        this.contactTitle = contactTitle;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
