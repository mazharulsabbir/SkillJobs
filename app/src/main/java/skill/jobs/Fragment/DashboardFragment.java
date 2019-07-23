package skill.jobs.Fragment;


import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
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
import skill.jobs.Database.JobsReq;
import skill.jobs.Database.JsonPlaceHolderApi;
import skill.jobs.JobInfoViewerActivity;
import skill.jobs.LoginActivity;
import skill.jobs.R;
import skill.jobs.RecyclerView.Adapter.JobsQuickAdapter;
import skill.jobs.RecyclerView.Adapter.TrendingCourseQuickAdapter;
import skill.jobs.RecyclerView.Helper.JobsHelper;
import skill.jobs.RecyclerView.Helper.TrendingCourses;
import skill.jobs.RegistrationActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class DashboardFragment extends Fragment implements View.OnClickListener {
    private View view;
    private RecyclerView mRecyclerViewFeatureJobs;
    private RecyclerView mRecyclerViewTrendingCourses;

    private List<JobsHelper> jobsList;
    private List<TrendingCourses> courses;

    private BaseQuickAdapter mFeatureJobsAdapter;
    private BaseQuickAdapter mTrendingCoursesAdapter;

    String content = "";


    public DashboardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        stringUrlDesign();

        initSampleData();
        initRecyclerViews();
        featureJobsAdapter();

        trendingCourseAdapter();

        return view;
    }

    private void initSampleData() {

        courses = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            TrendingCourses course = new TrendingCourses("Title ", "Duration", "Fees");
            courses.add(i, course);
        }
        jobs();
    }

    private void jobs() {
        jobsList = new ArrayList<>();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://test.skill.jobs/api/jobs/0/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        Call<List<JobsReq>> call = jsonPlaceHolderApi.getJobs();

        call.enqueue(new Callback<List<JobsReq>>() {
            @Override
            public void onResponse(Call<List<JobsReq>> call, Response<List<JobsReq>> response) {

                if (!response.isSuccessful()) {
                    Toast.makeText(getContext(), "Code: " + response.code(), Toast.LENGTH_LONG).show();
                    return;
                }

                List<JobsReq> jobs = response.body();

                for (JobsReq job : jobs) {

                    JobsHelper jobsHelper = new JobsHelper(R.drawable.ic_company,
                            job.getCompanyName(),
                            job.getJobTitle(),
                            job.getTimezone(),
                            job.getDate());
                    jobsList.add(jobsHelper);

                }
            }

            @Override
            public void onFailure(Call<List<JobsReq>> call, Throwable t) {
                //textViewResult.setText(t.getMessage());
                Toast.makeText(getContext(), "Message: " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void initRecyclerViews() {
        mRecyclerViewFeatureJobs = view.findViewById(R.id.recycler_view_feature_job);
        mRecyclerViewTrendingCourses = view.findViewById(R.id.recycler_view_trending_course);

        //horizontal recycler view
//        LinearLayoutManager layoutManager
//                = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);

        mRecyclerViewFeatureJobs.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerViewTrendingCourses.setLayoutManager(new LinearLayoutManager(getContext()));

        mRecyclerViewFeatureJobs.setHasTransientState(true);

    }

    @SuppressWarnings("unchecked")
    private void featureJobsAdapter() {

        mFeatureJobsAdapter = new JobsQuickAdapter(R.layout.example_job, jobsList);
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

    private void stringUrlDesign() {
        String text = "Login or Register";
        TextView textView = view.findViewById(R.id.textView6);

        SpannableString ss = new SpannableString(text);

        ClickableSpan clickableSpanSignIn = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                startActivity(new Intent(getActivity(), LoginActivity.class));
            }

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(Color.BLACK);
                ds.setUnderlineText(false);
            }
        };


        ClickableSpan clickableSpan1 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                startActivity(new Intent(getActivity(), RegistrationActivity.class));
            }

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(Color.BLACK);
                ds.setUnderlineText(false);
            }
        };


        ss.setSpan(clickableSpanSignIn, 0, 5, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setText(ss);
        textView.setMovementMethod(LinkMovementMethod.getInstance());


        ss.setSpan(clickableSpan1, 9, 17, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setText(ss);
        textView.setMovementMethod(LinkMovementMethod.getInstance());

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

        }
    }
}
