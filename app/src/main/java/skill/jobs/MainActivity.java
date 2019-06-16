package skill.jobs;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

//import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import skill.jobs.RecyclerView.Jobs;
import skill.jobs.RecyclerView.QuickAdapter;

public class MainActivity extends AppCompatActivity {
    /**
     * The {@link PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    private RecyclerView mRecyclerView;
    private List<Jobs> jobsList;
    private BottomNavigationView bottomNavigation;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = findViewById(R.id.tabs);
        bottomNavigation=findViewById(R.id.navigation_view);


        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_Dashboard:
                        Toast.makeText(MainActivity.this, "nav_Dashboard", Toast.LENGTH_SHORT).show();
                        return true;

                    case R.id.nav_jobs:
                        Toast.makeText(MainActivity.this, "nav_jobs", Toast.LENGTH_SHORT).show();

                        return true;

                    case R.id.nav_Training:
                        Toast.makeText(MainActivity.this, "nav_Training", Toast.LENGTH_SHORT).show();

                        return true;

                    case R.id.nav_Profile:
                        startActivity(new Intent(MainActivity.this,JobSeekerActivity.class));

                        return true;

                    case R.id.nav_Services:
                        Toast.makeText(MainActivity.this, "nav_Services", Toast.LENGTH_SHORT).show();

                        return true;
                }
                return false;
            }
        });



        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

        BottomNavigationView bottomNavigationView = findViewById(R.id.navigation_view);
        BadgeDrawable badge = bottomNavigationView.showBadge(R.id.nav_jobs);
        badge.setNumber(1000);
        badge.setMaxCharacterCount(4);

//        initView();
//        initData();
//        initAdapter();
    }

    private void initView() {
        mRecyclerView = findViewById(R.id.recycler_view_jobs_container);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @SuppressWarnings("unchecked")
//    private void initAdapter() {
//        BaseQuickAdapter homeAdapter = new QuickAdapter(jobsList);
//
//        mRecyclerView.setAdapter(homeAdapter);
//    }

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
