
package skill.jobs.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;

import skill.jobs.R;


public class ProfileImageJsFragment extends Fragment {
    View rootview;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.fragment_profile_image_js,container,false);
        setupTabView();
        return rootview;
    }

    private void setupTabView() {
        ProfileImageJsFragment.SectionsPagerAdapter mSectionsPagerAdapter = new ProfileImageJsFragment.SectionsPagerAdapter(getFragmentManager());

        // Set up the ViewPager with the sections adapter.
        ViewPager mViewPager = rootview.findViewById(R.id.Container_U_I);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = rootview.findViewById(R.id.tabLayout);
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
                    fragment = new UploadProfilePictureFragment();
                    break;
                case 1:
                    fragment = new UploadCoverPhotoFragment();
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

