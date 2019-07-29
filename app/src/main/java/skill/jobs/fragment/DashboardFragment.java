package skill.jobs.fragment;


import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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
import skill.jobs.JobInfoViewerActivity;
import skill.jobs.R;
import skill.jobs.database.AllJobs;
import skill.jobs.database.JobsData;
import skill.jobs.database.JsonPlaceHolderApi;
import skill.jobs.recyclerview.adapter.JobsQuickAdapter;
import skill.jobs.recyclerview.adapter.TrendingCourseQuickAdapter;
import skill.jobs.recyclerview.helper.JobsHelper;
import skill.jobs.recyclerview.helper.TrendingCourses;

/**
 * A simple {@link Fragment} subclass.
 */
public class DashboardFragment extends Fragment implements View.OnClickListener {
    private static final String TAG = "DashboardFragment";

    private View view;
    private RecyclerView mRecyclerViewFeatureJobs;
    private RecyclerView mRecyclerViewTrendingCourses;
    private List<JobsHelper> jobsList;
    private List<TrendingCourses> courses;
    private BaseQuickAdapter mFeatureJobsAdapter;
    private BaseQuickAdapter mTrendingCoursesAdapter;
    private List<JobsData> data;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        initRecyclerViews();

        initSampleData();
        trendingCourseAdapter();

        return view;
    }

    private void getResponse() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(JsonPlaceHolderApi.BASE_JOBS_URL)
                .addConverterFactory(GsonConverterFactory.create())//ScalarsConverterFactory.create()
                .build();

        JsonPlaceHolderApi api = retrofit.create(JsonPlaceHolderApi.class);

        Call<AllJobs> call = api.getAllJobs();
        call.enqueue(new Callback<AllJobs>() {
                         @Override
                         public void onResponse(Call<AllJobs> call, Response<AllJobs> response) {
                             if (!response.isSuccessful()) {
                                 Log.i(TAG, "onResponse: " + response.message() + ":" + response.code());
                             }

                             data = response.body().getJobsData();
                             featureJobsAdapter(data);
                         }

                         @Override
                         public void onFailure(Call<AllJobs> call, Throwable t) {
                             Log.e(TAG, "onFailure: ", t);
                         }
                     }
        );
    }

    private void initSampleData() {
        getResponse();

        courses = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            TrendingCourses course = new TrendingCourses("Title ", "Duration", "Fees");
            courses.add(i, course);
        }
    }

    private void initRecyclerViews() {
        mRecyclerViewFeatureJobs = view.findViewById(R.id.recycler_view_feature_job);
        mRecyclerViewTrendingCourses = view.findViewById(R.id.recycler_view_trending_course);
        mRecyclerViewFeatureJobs.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerViewTrendingCourses.setLayoutManager(new LinearLayoutManager(getContext()));

        mRecyclerViewFeatureJobs.setHasTransientState(true);

    }

    @SuppressWarnings("unchecked")
    private void featureJobsAdapter(List<JobsData> jobsData) {

        mFeatureJobsAdapter = new JobsQuickAdapter(R.layout.example_job, jobsData);
        mFeatureJobsAdapter.isFirstOnly(false);
        mFeatureJobsAdapter.openLoadAnimation();

        mRecyclerViewFeatureJobs.setAdapter(mFeatureJobsAdapter);

        mFeatureJobsAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {


                ImageView companyLogo = view.findViewById(R.id.imageView2);
                TextView companyName = view.findViewById(R.id.job_company_name),
                        vacancyName = view.findViewById(R.id.job_vacancy_name),
                        location = view.findViewById(R.id.job_location);

                Intent sharedIntent = new Intent(getActivity(), JobInfoViewerActivity.class);
                sharedIntent.putExtra("JOB_ID", data.get(position).getId());

                Pair[] pairs = new Pair[4];
                pairs[0] = new Pair<View, String>(companyLogo, "company_logo");
                pairs[1] = new Pair<View, String>(companyName, "company_name");
                pairs[2] = new Pair<View, String>(vacancyName, "vacancy_name");
                pairs[3] = new Pair<View, String>(location, "company_location");

                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(getActivity(), pairs);
                    startActivity(sharedIntent, options.toBundle());

                } else {
                    startActivity(sharedIntent);
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    private void trendingCourseAdapter() {

        mTrendingCoursesAdapter = new TrendingCourseQuickAdapter(R.layout.example_trending_course, courses);
        mTrendingCoursesAdapter.isFirstOnly(false);
        mTrendingCoursesAdapter.openLoadAnimation();
        setEmptyView(mTrendingCoursesAdapter);
        mRecyclerViewTrendingCourses.setAdapter(mTrendingCoursesAdapter);
    }

    private void setEmptyView(BaseQuickAdapter adapter) {
        View errorView = getLayoutInflater().inflate(
                R.layout.example_empty_jobs, (ViewGroup) mRecyclerViewFeatureJobs.getParent(), false);
        adapter.setEmptyView(errorView);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

        }
    }

}
