package skill.jobs.fragment;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import skill.jobs.JobInfoViewerActivity;
import skill.jobs.R;
import skill.jobs.database.JobsReq;
import skill.jobs.database.JsonPlaceHolderApi;
import skill.jobs.recyclerview.adapter.JobsContainerAdapter;
import skill.jobs.recyclerview.helper.JobsContainerHelper;

public class GlobalJobsFragment extends Fragment {
    private View view;
    private RecyclerView mRecyclerViewFeatureJobs;
    private List<JobsContainerHelper> jobsList;
    private BaseQuickAdapter mFeatureJobsAdapter;
    private List<String> itemId;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_global_jobs, container, false);

        mRecyclerViewFeatureJobs = view.findViewById(R.id.recycler_view_global_jobs);
        mRecyclerViewFeatureJobs.setLayoutManager(new LinearLayoutManager(getContext()));

        getResponse();

        return view;
    }

    private void getResponse() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(JsonPlaceHolderApi.BASE_JOBS_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();

        JsonPlaceHolderApi api = retrofit.create(JsonPlaceHolderApi.class);

        Call<String> call = api.getJobs();
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.i("Response: ", response.body());
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        Log.i("onSuccess", response.body());

                        String jsonResponse = response.body();
                        getAllJobLists(jsonResponse);

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

    private void getAllJobLists(String response) {

        try {
            //getting the whole json object from the response
            JSONObject obj = new JSONObject(response);
            ArrayList<JobsReq> retroModelArrayList = new ArrayList<>();
            JSONArray dataArray = obj.getJSONArray("data");
            itemId = new ArrayList<>();
            jobsList = new ArrayList<>();

            for (int i = 0; i < dataArray.length(); i++) {
                JSONObject jsonObject = dataArray.getJSONObject(i);
                JobsReq jobsReq = new JobsReq(
                        jsonObject.getInt("id"),
                        jsonObject.getString("slug"),
                        jsonObject.getString("jobTitle"),
                        jsonObject.getString("companyName"),
                        jsonObject.getJSONObject("jobDeadline").getString("date"),
                        jsonObject.getJSONObject("jobDeadline").getString("timezone_type"),
                        jsonObject.getJSONObject("jobDeadline").getString("timezone")
                );

                itemId.add(i, Integer.toString(jsonObject.getInt("id")));

                retroModelArrayList.add(jobsReq);
                JobsContainerHelper jobs = new JobsContainerHelper(R.drawable.ic_company,
                        retroModelArrayList.get(i).getCompanyName(),
                        retroModelArrayList.get(i).getJobTitle(),
                        retroModelArrayList.get(i).getTimezone(),
                        retroModelArrayList.get(i).getDate(),
                        "Experience",
                        "Salary",
                        false);
                jobsList.add(jobs);
            }

            featureJobsAdapter();

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    private void featureJobsAdapter() {
        //jobsList.clear();
        mFeatureJobsAdapter = new JobsContainerAdapter(R.layout.example_layout_jobs, jobsList);
        mFeatureJobsAdapter.isFirstOnly(false);
        mFeatureJobsAdapter.openLoadAnimation();

        mRecyclerViewFeatureJobs.setAdapter(mFeatureJobsAdapter);

        mFeatureJobsAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                ImageView companyLogo = view.findViewById(R.id.imageView2);
                TextView companyName = view.findViewById(R.id.job_company_name),
                        vacancyName = view.findViewById(R.id.job_vacancy_name),
                        location = view.findViewById(R.id.job_location);

                Intent sharedIntent = new Intent(getActivity(), JobInfoViewerActivity.class);
                sharedIntent.putExtra("JOB_ID", itemId.get(position));

                Pair[] pairs = new Pair[4];
                pairs[0] = new Pair<View, String>(companyLogo, "company_logo");
                pairs[1] = new Pair<View, String>(companyName, "company_name");
                pairs[2] = new Pair<View, String>(vacancyName, "vacancy_name");
                pairs[3] = new Pair<View, String>(location, "company_location");

                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(getActivity(), pairs);
                    startActivity(sharedIntent, options.toBundle());

                } else {
                    startActivity(sharedIntent);
                }
            }
        });

        mFeatureJobsAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View v, int position) {
                switch (v.getId()) {
                    case R.id.menu_favorite:
                        Toast.makeText(getContext(), "Removed from Favorite", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.menu_not_favorite:
                        Toast.makeText(getContext(), "Added to Favorite", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu_share_job:
                        Toast.makeText(getContext(), "Share", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }

}
