package skill.jobs.Fragment;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

import skill.jobs.JobInfoViewerActivity;
import skill.jobs.R;
import skill.jobs.RecyclerView.Adapter.JobsContainerAdapter;
import skill.jobs.RecyclerView.Helper.JobsContainerHelper;

public class FullTimeJobsFragment extends Fragment {
    private View view;
    private RecyclerView mRecyclerViewFeatureJobs;
    private List<JobsContainerHelper> jobsList;
    private BaseQuickAdapter mFeatureJobsAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_full_time_jobs, container, false);

        mRecyclerViewFeatureJobs = view.findViewById(R.id.recycler_view_full_time_jobs);
        mRecyclerViewFeatureJobs.setLayoutManager(new LinearLayoutManager(getContext()));

        initSampleData();
        featureJobsAdapter();

        return view;
    }

    private void initSampleData() {
        jobsList = new ArrayList<>();
        for (int i = 1; i <= 1000; i++) {
            JobsContainerHelper jobs = new JobsContainerHelper(R.mipmap.ic_launcher,
                    "Company Full Time"+i,
                    "Vacancy ",
                    "Location ",
                    "Dead Line ",
                    "Experience",
                    "Job Type",
                    "Salary");
            jobsList.add(jobs);
        }
    }

    @SuppressWarnings("unchecked")
    private void featureJobsAdapter() {
        mFeatureJobsAdapter = new JobsContainerAdapter(R.layout.example_layout_jobs, jobsList);
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

        mFeatureJobsAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View v, int position) {
                switch (v.getId()) {
                    case R.id.menu_favorite:
                        Toast.makeText(getContext(), "Removed from Favorite", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.menu_not_favorite:
                        Toast.makeText(getContext(), "Added to Favorite", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu_share_job:
                        Toast.makeText(getContext(), "Share", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }

}
