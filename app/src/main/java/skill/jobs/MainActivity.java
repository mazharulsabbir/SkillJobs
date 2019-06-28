package skill.jobs;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import skill.jobs.Fragment.BottomSheetProductsAndServices;
import skill.jobs.Fragment.DashboardFragment;
import skill.jobs.Fragment.FavoriteJobsFragment;
import skill.jobs.Fragment.JobsFragment;
import skill.jobs.Fragment.TrainingFragment;
import skill.jobs.Fragment.WelcomeProfileFragment;

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

                    case R.id.nav_favorite_jobs:
                        if (!ACTIVE_FRAGMENT.equals("FAV_JOBS")) {
                            toolbar.setTitle("FAVORITES");
                            openFragment(new FavoriteJobsFragment(), "FAV_JOBS");

                        }
                        return true;

                    case R.id.nav_Training:
                        if (!ACTIVE_FRAGMENT.equals("TRAINING")) {
                            toolbar.setTitle("TRAINING");
                            openFragment(new TrainingFragment(), "TRAINING");
                        }
                        return true;

                    case R.id.nav_Profile:
                        if (!ACTIVE_FRAGMENT.equals("PROFILE")) {
                            toolbar.setTitle("PROFILE");
                            openFragment(new WelcomeProfileFragment(), "PROFILE");
                        }
                        return true;
                }
                return false;
            }
        });


        BadgeDrawable badge = bottomNavigation.showBadge(R.id.nav_jobs);
        badge.setNumber(1000);
        badge.setMaxCharacterCount(4);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        MenuItem searchItem = menu.findItem(R.id.search_job);
        SearchView searchView = (SearchView) searchItem.getActionView();

        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);
        searchView.setQueryHint("Search..");

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                startActivity(new Intent(MainActivity.this, SearchResultActivity.class));
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case android.R.id.home:
                BottomSheetProductsAndServices sheet = new BottomSheetProductsAndServices();
                sheet.show(getSupportFragmentManager(), "BottomSheetDialog");
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
