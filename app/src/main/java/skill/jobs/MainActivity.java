package skill.jobs;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

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


        BottomNavigationView bottomNavigation = findViewById(R.id.navigation_view);


        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_Dashboard:
                        toolbar.setTitle("Dashboard");
                        return true;

                    case R.id.nav_jobs:
                        toolbar.setTitle("JOBS");
                        fragmentJobs();
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


        BottomNavigationView bottomNavigationView = findViewById(R.id.navigation_view);
        BadgeDrawable badge = bottomNavigationView.showBadge(R.id.nav_jobs);
        badge.setNumber(1000);
        badge.setMaxCharacterCount(4);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.nav_job_seeker:
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }
    }

    private void fragmentJobs() {
        SectionsPagerAdapter mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        ViewPager mViewPager = findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        final TabLayout tabLayout = findViewById(R.id.tabs);
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));
    }

    private void openFragment(final Fragment fragment) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_right, R.anim.pop_enter, R.anim.pop_exit);
        transaction.disallowAddToBackStack(); //to remove back fragment

        transaction.replace(R.id.fragment_container, fragment).commit();
        fragmentManager.executePendingTransactions();
        //activeFragment = fragmentName;
    }

}
