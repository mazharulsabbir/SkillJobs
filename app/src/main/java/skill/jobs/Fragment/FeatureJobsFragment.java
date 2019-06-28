package skill.jobs.Fragment;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

import skill.jobs.R;
import skill.jobs.RecyclerView.JobsContainerAdapter;
import skill.jobs.RecyclerView.JobsContainerHelper;

public class FeatureJobsFragment extends Fragment {
    private View view;
    private RecyclerView mRecyclerViewFeatureJobs;
    private List<JobsContainerHelper> jobsList;
    private BaseQuickAdapter mFeatureJobsAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_feature_jobs, container, false);

        mRecyclerViewFeatureJobs = view.findViewById(R.id.recycler_view_feature_job);
        mRecyclerViewFeatureJobs.setLayoutManager(new LinearLayoutManager(getContext()));

        initSampleData();
        featureJobsAdapter();

        return view;
    }

    private void initSampleData() {
        jobsList = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            JobsContainerHelper jobs = new JobsContainerHelper(R.mipmap.ic_launcher,
                    "Company Feature" + i,
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
        //jobsList.clear();
        mFeatureJobsAdapter = new JobsContainerAdapter(R.layout.example_layout_jobs, jobsList);
        mFeatureJobsAdapter.isFirstOnly(false);
        mFeatureJobsAdapter.openLoadAnimation();

        mFeatureJobsAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Toast.makeText(getActivity(), "onItemClick" + position, Toast.LENGTH_SHORT).show();

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

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mRecyclerViewFeatureJobs.setAdapter(mFeatureJobsAdapter);
            }
        }, 200);
    }

}
