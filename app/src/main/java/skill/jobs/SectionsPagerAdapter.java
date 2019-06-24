package skill.jobs;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import skill.jobs.Fragment.FeatureJobsFragment;
import skill.jobs.Fragment.FullTimeJobsFragment;
import skill.jobs.Fragment.GlobalJobsFragment;
import skill.jobs.Fragment.GovernmentJobsFragment;
import skill.jobs.Fragment.PartTimeJobsFragment;
import skill.jobs.Fragment.RecentJobsFragment;

public class SectionsPagerAdapter extends FragmentPagerAdapter {
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
            default:
                fragment = new FeatureJobsFragment();
        }

        return fragment;
    }

    @Override
    public int getCount() {
        return 6;
    }
}
