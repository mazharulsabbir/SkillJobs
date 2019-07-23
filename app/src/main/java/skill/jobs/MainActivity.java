package skill.jobs;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
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
import skill.jobs.Fragment.ProfileFragment;
import skill.jobs.Fragment.TrainingFragment;
import skill.jobs.JobSeeker.EditJobSeekerProfile;
import skill.jobs.JobSeeker.JobSeekerActivity;

public class MainActivity extends AppCompatActivity {

    private String ACTIVE_FRAGMENT = "";
    private FrameLayout frameLayout;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*TOOLBAR SEGMENT*/
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_service_black);

        /*BOTTOM NAVIGATION BAR SEGMENT*/
        BottomNavigationView bottomNavigation = findViewById(R.id.navigation_view);

        if (savedInstanceState == null) {
            ACTIVE_FRAGMENT = "DASHBOARD";

            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.fragment_container, new DashboardFragment()).commit();
            fragmentManager.executePendingTransactions();
        }

        /*BOTTOM NAVIGATION ITEM CLICK LISTENER*/
        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.nav_Dashboard:
                        if (!ACTIVE_FRAGMENT.equals("DASHBOARD")) {
                            openFragment(new DashboardFragment(), "DASHBOARD");
                        }
                        return true;

                    case R.id.nav_jobs:

                        if (!ACTIVE_FRAGMENT.equals("JOBS")) {
                            openFragment(new JobsFragment(), "JOBS");
                        }
                        return true;

                    case R.id.nav_favorite_jobs:
                        if (!ACTIVE_FRAGMENT.equals("FAV_JOBS")) {
                            openFragment(new FavoriteJobsFragment(), "FAV_JOBS");

                        }
                        return true;

                    case R.id.nav_Training:
                        if (!ACTIVE_FRAGMENT.equals("TRAINING")) {
                            openFragment(new TrainingFragment(), "TRAINING");
                        }
                        return true;

                    case R.id.nav_Profile:
                        if (!ACTIVE_FRAGMENT.equals("PROFILE")) {
                            openFragment(new ProfileFragment(), "PROFILE");
                        }
                        return true;
                }

                return false;
            }
        });

        /*MANAGE BADGE OF BOTTOM NAVIGATION ITEMS*/
        BadgeDrawable badge = bottomNavigation.showBadge(R.id.nav_jobs);
        badge.setNumber(120);
        badge.setMaxCharacterCount(4);
        badge.setBackgroundColor(Color.BLUE);
        badge.setBadgeTextColor(Color.WHITE);

        /*MAINTAIN CHILD POSITION OF FRAME LAYOUT SEGMENT*/
        frameLayout = findViewById(R.id.fragment_container);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        //to visible menu item icon
        if (menu instanceof MenuBuilder) {
            MenuBuilder m = (MenuBuilder) menu;
            m.setOptionalIconsVisible(true);
        }


        MenuItem searchItem = menu.findItem(R.id.search_job);
        SearchView searchView = (SearchView) searchItem.getActionView();

        searchView.setMaxWidth(Integer.MAX_VALUE);
        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);
        searchView.setQueryHint("Try, Android Developer?");

        //TODO: ADD SUGGESTED SEARCH, RECENT SEARCH QUERY ON searchView ... modify searchable.xml

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

            case R.id.menu_job_seeker_profile:
                startActivity(new Intent(MainActivity.this, JobSeekerActivity.class));
                return true;

            case R.id.menu_edit_profile:
                startActivity(new Intent(this, EditJobSeekerProfile.class));
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onSearchRequested() {
        return super.onSearchRequested();
    }

    @SuppressLint("NewApi")
    private void openFragment(final Fragment fragment, final String CURRENT_FRAGMENT) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.disallowAddToBackStack(); //to remove back fragment
//        transaction.addToBackStack(CURRENT_FRAGMENT);
        transaction.replace(R.id.fragment_container, fragment)
                .commit();
        fragmentManager.executePendingTransactions();

        ACTIVE_FRAGMENT = CURRENT_FRAGMENT;

    }

}
