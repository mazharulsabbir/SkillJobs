package skill.jobs.Fragment;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

import skill.jobs.LoginActivity;
import skill.jobs.R;
import skill.jobs.RecyclerView.Jobs;
import skill.jobs.RecyclerView.JobsQuickAdapter;
import skill.jobs.RecyclerView.TrendingCourseQuickAdapter;
import skill.jobs.RecyclerView.TrendingCourses;
import skill.jobs.RegistrationActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class DashboardFragment extends Fragment {
    public static final int SLIDEIN_LEFT = 0x00000004;
    private static final String TAG = "DashboardFragment";
    private View view;
    private RecyclerView mRecyclerViewFeatureJobs;
    private RecyclerView mRecyclerViewTrendingCourses;
    private RecyclerView mRecyclerViewPartners;

    private List<Jobs> jobsList;
    private List<TrendingCourses> courses;

    private BaseQuickAdapter mFeatureJobsAdapter;
    private BaseQuickAdapter mTrendingCoursesAdapter;
    private BaseQuickAdapter mPartnersAdapter;


    public DashboardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        stringUrlDesign();

        return view;
    }

    @Override
    public void onStart() {
        initSampleData();
        initRecyclerViews();
        featureJobsAdapter();

        trendingCourseAdapter();

        super.onStart();
    }

    private void initSampleData() {
        jobsList = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            Jobs jobs = new Jobs("Company " + i,
                    "Vacancy " + i,
                    "Location " + i,
                    "Dead Line " + i, i);
            jobsList.add(jobs);
        }

        courses = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            TrendingCourses course = new TrendingCourses("Title ", "Duration", "Fees");
            courses.add(course);
        }
    }

    private void initRecyclerViews() {
        mRecyclerViewFeatureJobs = view.findViewById(R.id.recycler_view_feature_job);
        mRecyclerViewTrendingCourses = view.findViewById(R.id.recycler_view_trending_course);
        mRecyclerViewPartners = view.findViewById(R.id.recycler_view_partners);

        mRecyclerViewFeatureJobs.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerViewTrendingCourses.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerViewPartners.setLayoutManager(new GridLayoutManager(getContext(), 3));

    }

    @SuppressWarnings("unchecked")
    private void featureJobsAdapter() {
        jobsList.clear();
        mFeatureJobsAdapter = new JobsQuickAdapter(R.layout.example_job, jobsList);
        mFeatureJobsAdapter.isFirstOnly(false);
        mFeatureJobsAdapter.openLoadAnimation();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                mRecyclerViewFeatureJobs.setAdapter(mFeatureJobsAdapter);
                setEmptyView(mFeatureJobsAdapter);

            }
        }, 200);
    }

    @SuppressWarnings("unchecked")
    private void trendingCourseAdapter() {

        courses.clear();
        mTrendingCoursesAdapter = new TrendingCourseQuickAdapter(R.layout.example_trending_course, courses);
        mTrendingCoursesAdapter.isFirstOnly(false);
        mTrendingCoursesAdapter.openLoadAnimation();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                mRecyclerViewTrendingCourses.setAdapter(mTrendingCoursesAdapter);
                setEmptyView(mTrendingCoursesAdapter);

            }
        }, 200);
    }

    @SuppressWarnings("unchecked")
    private void partnersAdapter() {
        jobsList.clear();
        mFeatureJobsAdapter = new JobsQuickAdapter(R.layout.example_job, jobsList);
        mFeatureJobsAdapter.isFirstOnly(false);
        mFeatureJobsAdapter.openLoadAnimation();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                mRecyclerViewFeatureJobs.setAdapter(mFeatureJobsAdapter);
                setEmptyView(mFeatureJobsAdapter);

            }
        }, 200);
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

}
