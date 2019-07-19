package skill.jobs;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;

import skill.jobs.RecyclerView.Adapter.JobDetailsViewAdapter;
import skill.jobs.RecyclerView.Helper.JobDetailsViewHelper;

public class JobInfoViewerActivity extends AppCompatActivity {

    private String[] title = {"Title", "Job Type", "Job Experience", "Gender", "Posted On", "Last Date", "No Of Vacancies", "Location", "Salary"};
    private RecyclerView mRecyclerViewJobDetails;
    private List<JobDetailsViewHelper> info;
    private BaseQuickAdapter mJobInformation;
    private NestedScrollView scrollView;
    private MaterialButton materialButtonSave;

    private CardView layoutBottom;

    private Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_info_viewer);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        scrollView = findViewById(R.id.mNestedScrollView);

        layoutBottom = findViewById(R.id.card_view_bottom);

        materialButtonSave = findViewById(R.id.materialButton3);

        mRecyclerViewJobDetails = findViewById(R.id.recycler_view_job_details);
        mRecyclerViewJobDetails.setLayoutManager(new LinearLayoutManager(this));

        initSampleData();
        featureJobsAdapter();

        scrollView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public void onScrollChanged() {
                float scrollY = scrollView.getScrollY(); // For ScrollView

                float top = materialButtonSave.getY();
                float bottom = top + materialButtonSave.getHeight();

                if (scrollY >= bottom) {
                    layoutBottom.setVisibility(View.VISIBLE);
                } else if ((scrollY < bottom)){
                    layoutBottom.setVisibility(View.INVISIBLE);
                }
            }
        });

    }


    private void initSampleData() {
        info = new ArrayList<>();

        for (int i = 0; i < title.length; i++) {
            JobDetailsViewHelper profileInformationHelper = new JobDetailsViewHelper(title[i], "Information will appear here...");
            info.add(i, profileInformationHelper);
        }
    }

    @SuppressWarnings("unchecked")
    private void featureJobsAdapter() {
        //jobsList.clear();
        mJobInformation = new JobDetailsViewAdapter(R.layout.example_preview_job_details, info);
        mJobInformation.isFirstOnly(false);
        mJobInformation.openLoadAnimation();

        mRecyclerViewJobDetails.setAdapter(mJobInformation);

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
