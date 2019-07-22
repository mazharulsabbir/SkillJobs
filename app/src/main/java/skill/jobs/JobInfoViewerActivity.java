package skill.jobs;

import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.android.material.button.MaterialButton;

import org.xml.sax.XMLReader;

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
                } else if ((scrollY < bottom)) {
                    layoutBottom.setVisibility(View.GONE);
                }
            }
        });

        initiateHtmlToString();

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

    private void initiateHtmlToString() {
        String jobDesc = "<li>Create and preserve an environment where employees, visitors and properties are safe and well- protected</li>\n" +
                "\t<li>Develop &amp; implement security policies, protocol and procedures</li>\n" +
                "\t<li>Recruit, train and supervise Security Officers and Guards</li>\n" +
                "\t<li>Attend meetings with other Manager to determine operational needs</li>\n" +
                "\t<li>Control budgets for security operations and monitor expenses</li>\n" +
                "\t<li>Plan and coordinate security operations for specific events</li>\n" +
                "\t<li>Investigate &amp; resolve issues</li>\n" +
                "\t<li>Maintain relationship with local government authority, law and order enforcing agencies</li>\n" +
                "\t<li>Lead periodical safety drill</li>\n" +
                "\t<li>Ensure submissive behavior and warm reception to the visitors</li>";

        String educationalReq = "Job Experience:" +
                "\t<li>Proven experience as Assistant Manager or similar position of security team in a reputed organization</li>\n" +
                "\t<li>Defense background (minimum rank: Lieutenant or equivalent) is preferable</li>\n";

        String additionalReq = "<li>Well- groomed and age at most 45 years</li>\n" +
                "\t<li>Ability to lead &amp; coach security team</li>\n" +
                "\t<li>Experience in using relevant technology &amp; equipment (e.g. CCTV)</li>\n" +
                "\t<li>Excellent communication &amp; interpersonal skills</li>";

        String extraFacility = "<li>As per policy.</li>";

        TextView jobDescription = findViewById(R.id.tv_job_description);
        TextView educationalRequirements = findViewById(R.id.tv_educational_requirements);
        TextView additionalRequirements = findViewById(R.id.tv_additional_requirements);
        TextView extraFacilities = findViewById(R.id.tv_extra_facilities);
        TextView applyInstruction = findViewById(R.id.tv_apply_instruction);

        jobDescription.setText(Html.fromHtml(jobDesc, null, new UlTagHandler()));
        educationalRequirements.setText(Html.fromHtml(educationalReq, null, new UlTagHandler()));
        additionalRequirements.setText(Html.fromHtml(additionalReq, null, new UlTagHandler()));
        extraFacilities.setText(Html.fromHtml(extraFacility, null, new UlTagHandler()));
        applyInstruction.setText(Html.fromHtml(extraFacility, null, new UlTagHandler()));
    }

    public class UlTagHandler implements Html.TagHandler {
        @Override
        public void handleTag(boolean opening, String tag, Editable output,
                              XMLReader xmlReader) {
            if (tag.equals("ul") && !opening) output.append("");
            if (tag.equals("li") && opening) output.append("\n‣ ");
        }
    }
}
