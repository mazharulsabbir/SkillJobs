package skill.jobs.database;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {
    @GET("jobs")
    Call<String> getJobs();


    @GET("courses")
    Call<String> getUpcourses();

}
