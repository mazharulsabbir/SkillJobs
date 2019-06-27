package skill.jobs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import skill.jobs.Fragment.JobAgentFragment;
import skill.jobs.Fragment.PofileDetailsJS;
import skill.jobs.Fragment.ProfileImageJS;

public class JobSeekerActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_seeker);
        drawerLayout=findViewById(R.id.drawer_layout);
        NavigationView navigationView=findViewById(R.id.nav_view_JS);
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_open,R.string.navigation_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        getSupportFragmentManager().beginTransaction().replace(R.id.Fragment_Container,new PofileDetailsJS()).commit();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_ProfileDetails_JS:
                        getSupportFragmentManager().beginTransaction().replace(R.id.Fragment_Container,new PofileDetailsJS()).commit();
                        break;
                    case R.id.nav_ProfileImage_JS:
                        getSupportFragmentManager().beginTransaction().replace(R.id.Fragment_Container,new ProfileImageJS()).commit();
                        break;


                    case R.id.nav_CreateJobAgent_JS:
                        getSupportFragmentManager().beginTransaction().replace(R.id.Fragment_Container,new JobAgentFragment()).commit();
                        break;

                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START))
            drawerLayout.closeDrawer(GravityCompat.START);
        else
        super.onBackPressed();
    }
}
