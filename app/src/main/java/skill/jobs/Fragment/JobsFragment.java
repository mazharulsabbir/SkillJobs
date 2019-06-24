package skill.jobs.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import skill.jobs.R;
import skill.jobs.SectionsPagerAdapter;

public class JobsFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    public JobsFragment() {
    }

    public static JobsFragment newInstance(int sectionNumber) {
        JobsFragment fragment = new JobsFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView;
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

}