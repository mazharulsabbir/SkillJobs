package skill.jobs.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import skill.jobs.R;
import skill.jobs.RecyclerView.Jobs;
import skill.jobs.RecyclerView.QuickAdapter;

public class PlaceholderFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";
    public View rootView;
    private RecyclerView mRecyclerView;
    private List<Jobs> jobsList;

    public PlaceholderFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static PlaceholderFragment newInstance(int sectionNumber) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_main, container, false);
//        TextView textView = rootView.findViewById(R.id.section_label);
//        textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));

        initView();
        initData();
        initAdapter();

        return rootView;
    }

    private void initView() {
        mRecyclerView = rootView.findViewById(R.id.recycler_view_jobs_container);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @SuppressWarnings("unchecked")
    private void initAdapter() {
        BaseQuickAdapter homeAdapter = new QuickAdapter(jobsList);
        mRecyclerView.setAdapter(homeAdapter);
    }

    private void initData() {
        jobsList = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            Jobs jobs = new Jobs("Company " + i,
                    "Vacancy " + i,
                    "Location " + i,
                    "Dead Line " + i, i);
            jobsList.add(jobs);
        }
    }

}