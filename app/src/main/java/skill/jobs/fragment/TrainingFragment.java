package skill.jobs.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;

import skill.jobs.R;


public class TrainingFragment extends Fragment {

    private View view;


    public TrainingFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_training, container, false);


        setuptabview();


        return  view;
    }

    private void setuptabview() {
        PagerAdapter mSectionsPagerAdapter = new PagerAdapter(getFragmentManager());
        ViewPager viewPager=view.findViewById(R.id.CourseContainer);
        viewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout= view.findViewById(R.id.coursetab);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPager));

    }




    public class PagerAdapter extends FragmentStatePagerAdapter {
        private  Fragment fragment=null;

        public PagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    fragment = new UpcomingCourseFragment();
                    break;
                case 1:
                    fragment = new RunningCourseFragment();
                    break;

            }

            return fragment;
        }

        @Override
        public int getCount() {
            return 2;
        }
    }

}
