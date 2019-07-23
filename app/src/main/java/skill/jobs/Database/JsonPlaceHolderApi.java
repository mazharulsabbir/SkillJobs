package skill.jobs.Database;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {
    @GET("jobs")
    Call<List<JobsReq>> getJobs();

    @GET("posts")
    Call<List<Post>> getPosts();
}
