package skill.jobs.database;

public class JobsReq {
    private int id;
    private String slug,jobTitle,companyName,date,timezone_type,timezone;

    public JobsReq() {
    }

    public JobsReq(int id, String slug, String jobTitle, String companyName, String date, String timezone_type, String timezone) {
        this.id = id;
        this.slug = slug;
        this.jobTitle = jobTitle;
        this.companyName = companyName;
        this.date = date;
        this.timezone_type = timezone_type;
        this.timezone = timezone;
    }

    public void setId(int id) {
        this.id = id;
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
