package skill.jobs.database;

import com.google.gson.annotations.SerializedName;

public class JobsData {
    private int id;
    private String slug,jobTitle,companyName;
    private boolean isFavorite;

    @SerializedName("jobDeadline")
    private JobDeadline jobDeadline;

    public JobsData() {
    }

    public JobsData(int id, String slug, String jobTitle, String companyName, JobDeadline jobDeadline) {
        this.id = id;
        this.slug = slug;
        this.jobTitle = jobTitle;
        this.companyName = companyName;
        this.jobDeadline = jobDeadline;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
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

    public JobDeadline getJobDeadline() {
        return jobDeadline;
    }
}
