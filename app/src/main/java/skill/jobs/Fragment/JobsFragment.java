package skill.jobs.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import skill.jobs.R;

public class JobsFragment extends Fragment {
    private View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_jobs, container, false);

        setupTabView();

        return rootView;
    }

    @Override
    public void onStart() {
        setupTabView();
        super.onStart();
    }

    private void setupTabView() {
        SectionsPagerAdapter mSectionsPagerAdapter = new SectionsPagerAdapter(getFragmentManager());

        // Set up the ViewPager with the sections adapter.
        ViewPager mViewPager = rootView.findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = rootView.findViewById(R.id.tabs);
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    public class SectionsPagerAdapter extends FragmentStatePagerAdapter {
        private Fragment fragment = null;

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    fragment = new FeatureJobsFragment();
                    break;
                case 1:
                    fragment = new RecentJobsFragment();
                    break;
                case 2:
                    fragment = new FullTimeJobsFragment();
                    break;
                case 3:
                    fragment = new PartTimeJobsFragment();
                    break;
                case 4:
                    fragment = new GovernmentJobsFragment();
                    break;
                case 5:
                    fragment = new GlobalJobsFragment();
                    break;
            }

            return fragment;
        }

        @Override
        public int getCount() {
            return 6;
        }
    }
}