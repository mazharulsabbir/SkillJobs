package skill.jobs.Fragment;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import skill.jobs.R;
import skill.jobs.RecyclerView.Jobs;
import skill.jobs.RecyclerView.QuickAdapter;
import skill.jobs.SectionsPagerAdapter;

public class JobsFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";
    public View rootView;
    private RecyclerView mRecyclerView;
    private List<Jobs> jobsList;
    private BaseQuickAdapter homeAdapter;

    public JobsFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static JobsFragment newInstance(int sectionNumber) {
        JobsFragment fragment = new JobsFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_jobs, container, false);

        SectionsPagerAdapter mSectionsPagerAdapter = new SectionsPagerAdapter(getFragmentManager());

        // Set up the ViewPager with the sections adapter.
        ViewPager mViewPager = rootView.findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        final TabLayout tabLayout = rootView.findViewById(R.id.tabs);
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    private void initView() {
        mRecyclerView = rootView.findViewById(R.id.recycler_view_feature_job);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @SuppressWarnings("unchecked")
    private void initAdapter() {
        homeAdapter = new QuickAdapter(jobsList);
        View errorView = getLayoutInflater().inflate(R.layout.example_empty_jobs, (ViewGroup) mRecyclerView.getParent(), false);
        homeAdapter.setEmptyView(errorView);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mRecyclerView.setAdapter(homeAdapter);
            }
        }, 200);
    }

    private void initData() {
        jobsList = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            Jobs jobs = new Jobs("Company " + i,
                    "Vacancy " + i,
                    "Location " + i,
                    "Dead Line " + i, i);
            jobsList.add(jobs);
        }
    }


}