package skill.jobs;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import skill.jobs.Fragment.JobsFragment;

public class SectionsPagerAdapter extends FragmentPagerAdapter {

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a JobsFragment (defined as a static inner class below).
        Fragment fragment = new JobsFragment();
        return fragment;
    }

    @Override
    public int getCount() {
        // Show 6 total pages.
        return 6;
    }
}
