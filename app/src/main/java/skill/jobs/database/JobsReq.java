package skill.jobs.database;

public class JobsReq {
    private int id;
    private String slug,jobTitle,companyName,date,timezone_type,timezone;

    public void setId(int id) {
        this.id = id;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTimezone_type(String timezone_type) {
        this.timezone_type = timezone_type;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public int getId() {
        return id;
    }

    public String getSlug() {
        return slug;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getDate() {
        return date;
    }

    public String getTimezone_type() {
        return timezone_type;
    }

    public String getTimezone() {
        return timezone;
    }
}
