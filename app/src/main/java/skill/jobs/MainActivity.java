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

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import skill.jobs.Fragment.BottomSheetProductsAndServices;
import skill.jobs.Fragment.DashboardFragment;
import skill.jobs.Fragment.JobsFragment;
import skill.jobs.Fragment.TrainingFragment;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private String ACTIVE_FRAGMENT = "";

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

        if (savedInstanceState == null) {
            toolbar.setTitle("DASHBOARD");
            ACTIVE_FRAGMENT = "DASHBOARD";

            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();

            transaction.replace(R.id.fragment_container, new DashboardFragment()).commit();
            fragmentManager.executePendingTransactions();
        }


        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_Dashboard:
                        if (!ACTIVE_FRAGMENT.equals("DASHBOARD")) {
                            toolbar.setTitle("DASHBOARD");
                            openFragment(new DashboardFragment(), "DASHBOARD");
                        }
                        return true;

                    case R.id.nav_jobs:
                        if (!ACTIVE_FRAGMENT.equals("JOBS")) {
                            toolbar.setTitle("JOBS");
                            openFragment(new JobsFragment(), "JOBS");
                        }

                        return true;

                    case R.id.nav_Training:
                        if (!ACTIVE_FRAGMENT.equals("TRAINING")) {
                            toolbar.setTitle("TRAINING");
                            openFragment(new TrainingFragment(), "TRAINING");
                        }
                        return true;

                    case R.id.nav_Profile:
                        toolbar.setTitle("PROFILE");
                        return true;

                    case R.id.nav_Services:
                        toolbar.setTitle("SERVICES");
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

            case android.R.id.home:
                BottomSheetProductsAndServices sheet = new BottomSheetProductsAndServices();
                sheet.show(getSupportFragmentManager(), "BottomSheetDialog");

                return true;

            case R.id.nav_job_seeker:
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }
    }

    private void openFragment(final Fragment fragment, final String CURRENT_FRAGMENT) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.disallowAddToBackStack(); //to remove back fragment
        transaction.replace(R.id.fragment_container, fragment)
                .commit();
        fragmentManager.executePendingTransactions();

        ACTIVE_FRAGMENT = CURRENT_FRAGMENT;

    }

}
