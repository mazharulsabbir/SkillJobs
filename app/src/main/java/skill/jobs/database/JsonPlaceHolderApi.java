package skill.jobs.database;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface JsonPlaceHolderApi {
    String BASE_JOBS_URL = "http://skill.jobs/api/";
    String BASE_TRAINING_URL = "http://training.skill.jobs/api/v1/";

    @GET("jobs")
    Call<AllJobs> getAllJobs();

    @GET("job/{id}")
    Call<String> getJobDetails(
            @Path("id") int jobId);

    @GET("courses")
    Call<AllTrainings> getTrainings();

}
