package skill.jobs;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

import skill.jobs.RecyclerView.Adapter.JobDetailsViewAdapter;
import skill.jobs.RecyclerView.Helper.JobDetailsViewHelper;

public class JobInfoViewerActivity extends AppCompatActivity {

    private String[] title = {"Title", "Job Type", "Job Experience", "Gender", "Posted On", "Last Date", "No Of Vacancies", "Location", "Salary"};
    private RecyclerView mRecyclerViewJobDetails;
    private List<JobDetailsViewHelper> info;
    private BaseQuickAdapter mJobInformaation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_info_viewer);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mRecyclerViewJobDetails = findViewById(R.id.recycler_view_job_details);
        mRecyclerViewJobDetails.setLayoutManager(new LinearLayoutManager(this));

        initSampleData();
        featureJobsAdapter();


    }


    private void initSampleData() {
        info = new ArrayList<>();

        String[] mUserInfo = {"-", "-", "-", "-", "-", "-", "-", "-", "-"
        };

        for (int i = 0; i < mUserInfo.length; i++) {
            JobDetailsViewHelper profileInformationHelper = new JobDetailsViewHelper(title[i], mUserInfo[i]);
            info.add(i, profileInformationHelper);
        }
    }

    @SuppressWarnings("unchecked")
    private void featureJobsAdapter() {
        //jobsList.clear();
        mJobInformaation = new JobDetailsViewAdapter(R.layout.example_preview_job_details, info);
        mJobInformaation.isFirstOnly(false);
        mJobInformaation.openLoadAnimation();

        mRecyclerViewJobDetails.setAdapter(mJobInformaation);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                super.onBackPressed();
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }
    }
}
