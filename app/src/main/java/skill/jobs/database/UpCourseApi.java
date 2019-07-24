package skill.jobs.database;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UpCourseApi {

String Base_Url="http://training.skill.jobs/api/v1/";


  @GET("/courses")

    Call<List<Upcourse>> getUpcourses();

}
