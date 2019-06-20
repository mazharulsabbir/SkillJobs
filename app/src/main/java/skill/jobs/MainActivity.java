package skill.jobs;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.List;

import skill.jobs.RecyclerView.Jobs;

//import com.chad.library.adapter.base.BaseQuickAdapter;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_service_black);

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        SectionsPagerAdapter mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        ViewPager mViewPager = findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        final TabLayout tabLayout = findViewById(R.id.tabs);
        BottomNavigationView bottomNavigation = findViewById(R.id.navigation_view);


        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_Dashboard:
                        toolbar.setTitle("Dashboard");
                        return true;

                    case R.id.nav_jobs:
                        toolbar.setTitle("Jobs");
                        return true;

                    case R.id.nav_Training:
                        toolbar.setTitle("Training");
                        return true;

                    case R.id.nav_Profile:
                        toolbar.setTitle("Profile");
                        return true;

                    case R.id.nav_Services:
                        toolbar.setTitle("Services");
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
    }


}
