package skill.jobs.database;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AllJobs {

    @SerializedName("data")
    private List<JobsData> jobsData;

    public AllJobs(List<JobsData> jobsData) {
        this.jobsData = jobsData;
    }

    public List<JobsData> getJobsData() {
        return jobsData;
    }
}