package skill.jobs.fragment;

import android.graphics.Paint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import skill.jobs.database.UpCourseApi;
import skill.jobs.database.Upcourse;
import skill.jobs.R;
import skill.jobs.recyclerview.adapter.UpCommingCourseAdapter;
import skill.jobs.recyclerview.helper.UpcommingCourse;

public class UpcommingCourseFragment extends Fragment  {

   View view;
    private List<UpcommingCourse> courses;
    private BaseQuickAdapter mUpCommingCoursesAdapter;

    private RecyclerView mRecyclerViewUpcomingCourse;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_upcomming_course, container, false);

        //initialcourse();
        ApiData();
        initialRecyclerview();
        UpCommingCoursesAdapter();

        return view;
    }

    private void ApiData() {


        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl(UpCourseApi.Base_Url)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();


        UpCourseApi mapi=retrofit.create(UpCourseApi.class);
        Call<List<Upcourse>> call= mapi.getUpcourses();


        call.enqueue(new Callback<List<Upcourse>>() {
            @Override
            public void onResponse(Call<List<Upcourse>> call, Response<List<Upcourse>> response) {

                if(!response.isSuccessful()) {
                    Log.d("RESPOSE ERROR : ",response.message());
                }


                List<Upcourse> data=response.body();
                courses =new ArrayList<>();


                for(Upcourse upcourse : data){

                    UpcommingCourse course =new UpcommingCourse(
                            upcourse.getName(),
                            "10-4-19",
                            "5-5-19",
                            "48",
                            "5000",
                            "8000"

                    );

                    courses.add(course);

                }

                Log.d("Success: ","yes");

            }

            @Override
            public void onFailure(Call<List<Upcourse>> call, Throwable t) {

                Log.d("API FAILED: ",t.getMessage());
            }
        });

    }


    private void initialRecyclerview() {
        mRecyclerViewUpcomingCourse= view.findViewById(R.id.upcomming_course_recyclerview);
        mRecyclerViewUpcomingCourse.setLayoutManager(new LinearLayoutManager(getContext()));

    }



    private void initialcourse() {
        courses =new ArrayList<>();
        for (int i=0;i<10;i++) {
            UpcommingCourse course = new UpcommingCourse(
                    "COURSE TITLE",
                    "10-4-19",
                    "5-5-19",
                    "48",
                    "5000",
                    "8000");
            courses.add(course);
        }

    }
    private void UpCommingCoursesAdapter() {
        mUpCommingCoursesAdapter=new UpCommingCourseAdapter(R.layout.design_upcoming_course,courses);
        mUpCommingCoursesAdapter.isFirstOnly(false);
        mUpCommingCoursesAdapter.openLoadAnimation();

        mRecyclerViewUpcomingCourse.setAdapter(mUpCommingCoursesAdapter);




        mUpCommingCoursesAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View v, int position) {
                switch (v.getId()) {

                    case R.id.enrollButton:
                        Toast.makeText(getContext(), "Share", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

    }

    private void texturl() {
        TextView previous_price = view.findViewById(R.id.previous_price_upcomming_course);
        previous_price.setPaintFlags(previous_price.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);


    }




}
