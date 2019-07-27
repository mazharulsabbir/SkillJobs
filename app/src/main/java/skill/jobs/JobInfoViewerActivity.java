package skill.jobs;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.android.material.button.MaterialButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xml.sax.XMLReader;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import skill.jobs.database.JsonPlaceHolderApi;
import skill.jobs.recyclerview.adapter.JobDetailsViewAdapter;
import skill.jobs.recyclerview.helper.JobDetailsViewHelper;

public class JobInfoViewerActivity extends AppCompatActivity {
    private static final String TAG = "JobInfoViewerActivity";

    private String[] title = {"Title", "Job Type", "Job Experience", "Gender", "Posted On", "Last Date", "No Of Vacancies", "Location", "Salary"};
    private RecyclerView mRecyclerViewJobDetails;
    private List<JobDetailsViewHelper> info;
    private BaseQuickAdapter mJobInformation;
    private NestedScrollView scrollView;
    private MaterialButton materialButtonSave;
    private JobDetailsViewHelper profileInformationHelper;
    private int jobId;
    private CardView layoutBottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_info_viewer);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = this.getIntent();
        jobId = intent.getIntExtra("JOB_ID",0);

        scrollView = findViewById(R.id.mNestedScrollView);

        layoutBottom = findViewById(R.id.card_view_bottom);

        materialButtonSave = findViewById(R.id.materialButton3);

        mRecyclerViewJobDetails = findViewById(R.id.recycler_view_job_details);
        mRecyclerViewJobDetails.setLayoutManager(new LinearLayoutManager(this));

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

        getResponse();
    }

    private void getResponse() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(JsonPlaceHolderApi.BASE_JOBS_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();

        JsonPlaceHolderApi api = retrofit.create(JsonPlaceHolderApi.class);

        Call<String> call = api.getJobDetails(jobId);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.i("Response: ", response.body());
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        Log.i("onSuccess", response.body());

                        String jsonResponse = response.body();
                        getJobInfo(jsonResponse);

                    } else {
                        Log.i("onEmptyResponse", "Returned empty response");
                    }
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                t.printStackTrace();

            }
        });
    }

    private void getJobInfo(String response) {

        try {
            //getting the whole json object from the response
            JSONObject obj = new JSONObject(response);
            JSONArray dataArray = obj.getJSONArray("data");

            for (int i = 0; i < dataArray.length(); i++) {
                JSONObject jsonObject = dataArray.getJSONObject(i);

                TextView mJobName = findViewById(R.id.textView79);
                TextView mCompanyName = findViewById(R.id.textView82);
                TextView mLocation = findViewById(R.id.textView83);

                mJobName.setText(jsonObject.getString("jobTitle"));
                mCompanyName.setText(jsonObject.getString("companyName"));
                mLocation.setText(jsonObject.getJSONObject("jobDeadline").getString("timezone"));

                info = new ArrayList<>();

                String jobDescription, educationRequire, additionalRequire, extraFacilities;

                jobDescription = jsonObject.getString("jobDetail");

                educationRequire = jsonObject.getString("educationRequire");

                additionalRequire = jsonObject.getString("additionalRequire");

                extraFacilities = jsonObject.getString("extraFacilities");

                initiateHtmlToString(jobDescription, educationRequire, additionalRequire, extraFacilities);


                profileInformationHelper = new JobDetailsViewHelper(title[0],
                        jsonObject.getString("jobTitle"));
                info.add(0, profileInformationHelper);

                profileInformationHelper = new JobDetailsViewHelper(title[2],
                        jsonObject.getString("experienceRequire") + " year");
                info.add(1, profileInformationHelper);

                profileInformationHelper = new JobDetailsViewHelper(title[5],
                        jsonObject.getJSONObject("jobDeadline").getString("date"));
                info.add(2, profileInformationHelper);

                try {
                    profileInformationHelper = new JobDetailsViewHelper(title[6],
                            Integer.toString(jsonObject.getInt("noOfVacancy")));
                    info.add(3, profileInformationHelper);
                } catch (Exception e) {
                    profileInformationHelper = new JobDetailsViewHelper(title[6], "-");
                    info.add(3, profileInformationHelper);
                    Log.e(TAG, "getJobInfo: " + jobId, e);
                }

                profileInformationHelper = new JobDetailsViewHelper(title[7],
                        jsonObject.getString("location"));
                info.add(4, profileInformationHelper);

            }
            featureJobsAdapter();

        } catch (JSONException e) {
            Log.e(TAG, "getJobInfo: " + jobId, e);
        }

    }

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

    private void initiateHtmlToString(String jobDesc, String educationalReq, String additionalReq, String extraFacility) {

        TextView jobDescription = findViewById(R.id.tv_job_description);
        TextView educationalRequirements = findViewById(R.id.tv_educational_requirements);
        TextView additionalRequirements = findViewById(R.id.tv_additional_requirements);
        TextView extraFacilities = findViewById(R.id.tv_extra_facilities);
        TextView applyInstruction = findViewById(R.id.tv_apply_instruction);

        jobDescription.setText(Html.fromHtml(jobDesc.trim(), null, new UlTagHandler()));
        educationalRequirements.setText(Html.fromHtml(educationalReq.trim(), null, new UlTagHandler()));
        additionalRequirements.setText(Html.fromHtml(additionalReq.trim(), null, new UlTagHandler()));
        extraFacilities.setText(Html.fromHtml(extraFacility.trim(), null, new UlTagHandler()));

        applyInstruction.setText("\nOnline apply");
    }

    public class UlTagHandler implements Html.TagHandler {
        @Override
        public void handleTag(boolean opening, String tag, Editable output,
                              XMLReader xmlReader) {
            if (tag.equals("ul") && !opening) output.append(" ");
            if (tag.equals("li") && opening) output.append("\n‣ ");
        }
    }
}
