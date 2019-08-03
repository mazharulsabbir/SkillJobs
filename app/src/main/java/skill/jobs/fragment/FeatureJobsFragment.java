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

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import skill.jobs.JobInfoViewerActivity;
import skill.jobs.R;
import skill.jobs.database.AllJobs;
import skill.jobs.database.JobsData;
import skill.jobs.database.JsonPlaceHolderApi;
import skill.jobs.recyclerview.adapter.JobsContainerAdapter;

public class FeatureJobsFragment extends Fragment {
    private static final String TAG = "FeatureJobsFragment";
    private int TOTAL_COUNTER = 100;
    private View view;
    private RecyclerView mRecyclerViewFeatureJobs;
    private BaseQuickAdapter mFeatureJobsAdapter;
    private List<JobsData> data;
    private List<JobsData> limitedData;
    private int mCurrentCounter = 10;
    private Toast toast;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_feature_jobs, container, false);

        mRecyclerViewFeatureJobs = view.findViewById(R.id.recycler_view_feature_job);
        mRecyclerViewFeatureJobs.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerViewFeatureJobs.setHasFixedSize(true);

        getResponse();

        return view;
    }

    private void getResponse() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(JsonPlaceHolderApi.BASE_JOBS_URL)
                .addConverterFactory(GsonConverterFactory.create())//ScalarsConverterFactory.create()
                .build();

        JsonPlaceHolderApi api = retrofit.create(JsonPlaceHolderApi.class);

        Call<AllJobs> call = api.getAllJobs();
        call.enqueue(new Callback<AllJobs>() {
                         @Override
                         public void onResponse(Call<AllJobs> call, Response<AllJobs> response) {
                             if (!response.isSuccessful()) {
                                 Log.i(TAG, "onResponse: " + response.message() + ":" + response.code());
                                 Toast.makeText(getContext(), response.code(), Toast.LENGTH_SHORT).show();
                             }
                             data = new ArrayList<>();
                             limitedData = new ArrayList<>();

                             data = response.body().getJobsData();
                             TOTAL_COUNTER = data.size();
                             if (data.size() > 10)
                                 for (int i = 0; i < 10; i++) {
                                     limitedData.add(data.get(i));
                                 }
                             else limitedData.addAll(data);
                             featureJobsAdapter();
                         }

                         @Override
                         public void onFailure(Call<AllJobs> call, Throwable t) {
                             Log.e(TAG, "onFailure: ", t);
                             //Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                         }
                     }
        );
    }

    private void featureJobsAdapter() {
        mFeatureJobsAdapter = new JobsContainerAdapter(R.layout.example_layout_jobs, limitedData);
        mFeatureJobsAdapter.setHasStableIds(true);

        mRecyclerViewFeatureJobs.setAdapter(mFeatureJobsAdapter);

        mFeatureJobsAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                mRecyclerViewFeatureJobs.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (mCurrentCounter >= TOTAL_COUNTER) {
                            //Data are all loaded.
                            mFeatureJobsAdapter.loadMoreEnd();
                        } else {
                            mCurrentCounter = mFeatureJobsAdapter.getData().size();
                            limitedData.clear();

                            if (mCurrentCounter + 20 <= data.size()) {
                                for (int i = 0; i < mCurrentCounter + 20; i++) {
                                    limitedData.add(data.get(i));
                                }
                            } else limitedData.addAll(data);

                            mFeatureJobsAdapter.replaceData(limitedData);
                            mFeatureJobsAdapter.notifyDataSetChanged();
                            mFeatureJobsAdapter.loadMoreComplete();
                        }
                    }

                }, 300);
            }
        }, mRecyclerViewFeatureJobs);

        mFeatureJobsAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                ImageView companyLogo = view.findViewById(R.id.imageView2);
                TextView companyName = view.findViewById(R.id.job_company_name),
                        vacancyName = view.findViewById(R.id.job_vacancy_name),
                        location = view.findViewById(R.id.job_location);

                Intent sharedIntent = new Intent(getActivity(), JobInfoViewerActivity.class);
                sharedIntent.putExtra("JOB_ID", data.get(position).getId());
                sharedIntent.putExtra("JOB_TITLE",data.get(position).getJobTitle());
                sharedIntent.putExtra("COMPANY_NAME",data.get(position).getCompanyName());
                sharedIntent.putExtra("LOCATION",data.get(position).getJobDeadline().getTimezone());


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