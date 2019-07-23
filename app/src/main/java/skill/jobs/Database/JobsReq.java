package skill.jobs.Database;

import com.google.gson.annotations.SerializedName;

public class JobsReq {

    @SerializedName("id")
    private int jobId;

    private String jobTitle,companyName;

    //job dead line
    private int timezone_type;
    private String date,timezone;

    public int getJobId() {
        return jobId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getCompanyName() {
        return companyName;
    }

    public int getTimezone_type() {
        return timezone_type;
    }

    public String getDate() {
        return date;
    }

    public String getTimezone() {
        return timezone;
    }
}