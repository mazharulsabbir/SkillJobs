package skill.jobs.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import skill.jobs.CourseDetailsActivity;
import skill.jobs.R;
import skill.jobs.database.AllTrainings;
import skill.jobs.database.JsonPlaceHolderApi;
import skill.jobs.database.TrainingApiHelper;
import skill.jobs.recyclerview.adapter.RunningCourseAdapter;

public class RunningCourseFragment extends Fragment {
    private static final String TAG = "RunningCourseFragment";

    View view;

    private BaseQuickAdapter mRunningCoursesAdapter;

    private RecyclerView mRecyclerViewRunningCourse;

    private List<TrainingApiHelper> trainingApiHelperList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_running_course, container, false);


        ApiData();
        initRecyclerView();


        return view;
    }

    private void ApiData() {


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(JsonPlaceHolderApi.BASE_TRAINING_URL)
                .addConverterFactory(GsonConverterFactory.create())//ScalarsConverterFactory.create()
                .build();

        JsonPlaceHolderApi api = retrofit.create(JsonPlaceHolderApi.class);

        Call<AllTrainings> call = api.getTrainings();

        call.enqueue(new Callback<AllTrainings>() {
            @Override
            public void onResponse(Call<AllTrainings> call, Response<AllTrainings> response) {
                if (!response.isSuccessful()) {
                    Log.i(TAG, "onResponse: " + response.message() + ":" + response.code());
                    Toast.makeText(getContext(), response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }

                trainingApiHelperList = new ArrayList<>();

                trainingApiHelperList = response.body().getTrainingApiHelper();

                RunningCoursesAdapter();
            }

            @Override
            public void onFailure(Call<AllTrainings> call, Throwable t) {

            }
        });
    }

    private void RunningCoursesAdapter() {
        mRunningCoursesAdapter = new RunningCourseAdapter(R.layout.design_running_course, trainingApiHelperList);
        mRunningCoursesAdapter.isFirstOnly(false);
        mRunningCoursesAdapter.openLoadAnimation();

        mRecyclerViewRunningCourse.setAdapter(mRunningCoursesAdapter);

        mRunningCoursesAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View v, int position) {

                TrainingApiHelper helper = trainingApiHelperList.get(position);

                Intent intent = new Intent(getActivity(), CourseDetailsActivity.class);
                intent.putExtra("Title", helper.getName());
                intent.putExtra("Summary", String.valueOf(helper.getSummary()));
                intent.putExtra("Detail", String.valueOf(helper.getDetail()));
                startActivity(intent);

            }
        });


    }


    private void initRecyclerView() {

        mRecyclerViewRunningCourse = view.findViewById(R.id.running_course_recyclerview);
        mRecyclerViewRunningCourse.setHasFixedSize(true);
        mRecyclerViewRunningCourse.setLayoutManager(new LinearLayoutManager(getContext()));
    }


}
