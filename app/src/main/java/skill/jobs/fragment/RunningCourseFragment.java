package skill.jobs.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import skill.jobs.CourseDetailsActivity;
import skill.jobs.R;
import skill.jobs.database.JsonPlaceHolderApi;
import skill.jobs.database.RunCourse;
import skill.jobs.recyclerview.adapter.RunningCourseAdapter;
import skill.jobs.recyclerview.helper.RunningCourseHelper;
import skill.jobs.recyclerview.helper.UpcommingCourse;

public class RunningCourseFragment extends Fragment {
    View view;

    private List<RunningCourseHelper> RunnigCourses;

    private BaseQuickAdapter mRunningCoursesAdapter;

    private RecyclerView mRecyclerViewRunningCourse;
    ArrayList<RunCourse> retroModelArrayList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_running_course, container, false);


        ApiData();
        initRecyclerView();




        return view;
    }
    private void ApiData() {


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://training.skill.jobs/api/v1/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();


        JsonPlaceHolderApi mapi = retrofit.create(JsonPlaceHolderApi.class);
        Call<String> call = mapi.getUpcourses();

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.i("Response: ", response.body());
                if (!response.isSuccessful()) return;

                if (response.body() != null) {
                    Log.i("onSuccess", response.body());

                    String jsonResponse = response.body();
                    getJobLists(jsonResponse);

                } else {
                    Log.i("onEmptyResponse", "Returned empty response");
                }

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

                Toast.makeText(getContext(), t.getMessage() + "", Toast.LENGTH_SHORT).show();
                Log.i("Response error: ", t.getMessage());
            }
        });


    }

    private void getJobLists(String response) {
        try {
            //getting the whole json object from the response
            JSONObject obj = new JSONObject(response);
            retroModelArrayList= new ArrayList<>();
            JSONArray dataArray = obj.getJSONArray("data");
            RunnigCourses = new ArrayList<>();

            for (int i = 0; i < dataArray.length(); i++) {
                RunCourse runCourse = new RunCourse();
                JSONObject jsonObject = dataArray.getJSONObject(i);

                runCourse.setName(jsonObject.getString("name"));
                runCourse.setSummary(jsonObject.getString("summary"));
                runCourse.setDetail(jsonObject.getString("detail"));

                retroModelArrayList.add(runCourse);
            }

            for (int j = 0; j < retroModelArrayList.size(); j++) {
                RunningCourseHelper helper = new RunningCourseHelper(
                        retroModelArrayList.get(j).getName() + "",
                        "48 ");

                RunnigCourses.add(helper);

            }

            RunningCoursesAdapter();

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }



    private void RunningCoursesAdapter() {
        mRunningCoursesAdapter=new RunningCourseAdapter(R.layout.design_running_course,RunnigCourses);
        mRunningCoursesAdapter.isFirstOnly(false);
        mRunningCoursesAdapter.openLoadAnimation();
        mRecyclerViewRunningCourse.setAdapter(mRunningCoursesAdapter);

        mRunningCoursesAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View v, int position) {


                Intent intent=new Intent(getActivity(), CourseDetailsActivity.class);
                intent.putExtra("Title",retroModelArrayList.get(position).getName());
                intent.putExtra("Summary",retroModelArrayList.get(position).getSummary());
                intent.putExtra("Detail",retroModelArrayList.get(position).getDetail());
                startActivity(intent);

            }
        });


    }




    private void initRecyclerView() {

        mRecyclerViewRunningCourse=view.findViewById(R.id.running_course_recyclerview);
        mRecyclerViewRunningCourse.setLayoutManager(new LinearLayoutManager(getContext()));
    }


}
