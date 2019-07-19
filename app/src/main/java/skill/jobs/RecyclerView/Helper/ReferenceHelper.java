package skill.jobs.RecyclerView.Helper;

public class ReferenceHelper {
    private String personName, designation, orgName, contactNo, emailAddress, relation;

    public ReferenceHelper() {
    }

    public ReferenceHelper(String personName, String designation, String orgName, String contactNo, String emailAddress, String relation) {
        this.personName = personName;
        this.designation = designation;
        this.orgName = orgName;
        this.contactNo = contactNo;
        this.emailAddress = emailAddress;
        this.relation = relation;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }
}
