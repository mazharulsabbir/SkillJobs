package skill.jobs.fragment;

import android.app.FragmentManager;
import android.graphics.Paint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.security.cert.LDAPCertStoreParameters;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import skill.jobs.database.JobsReq;
import skill.jobs.database.JsonPlaceHolderApi;
import skill.jobs.database.Upcourse;
import skill.jobs.R;
import skill.jobs.recyclerview.adapter.UpCommingCourseAdapter;
import skill.jobs.recyclerview.helper.JobsHelper;
import skill.jobs.recyclerview.helper.UpcommingCourse;

public class UpcommingCourseFragment extends Fragment {

    View view;
    private List<UpcommingCourse> courses;
    private BaseQuickAdapter mUpCommingCoursesAdapter;

    private RecyclerView mRecyclerViewUpcomingCourse;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_upcomming_course, container, false);


        ApiData();
        initialRecyclerview();


        return view;
    }

    private void ApiData() {


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://training.skill.jobs/api/v1/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();


        JsonPlaceHolderApi mapi = retrofit.create(JsonPlaceHolderApi.class);
        Call<String> call = mapi.getUpcourses();

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.i("Response: ", response.body());
                if (!response.isSuccessful()) return;

                if (response.body() != null) {
                    Log.i("onSuccess", response.body());

                    String jsonResponse = response.body();
                    getJobLists(jsonResponse);

                } else {
                    Log.i("onEmptyResponse", "Returned empty response");
                }

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

                Toast.makeText(getContext(), t.getMessage() + "", Toast.LENGTH_SHORT).show();
                Log.i("Response error: ", t.getMessage());
            }
        });


    }

    private void getJobLists(String response) {
        try {
            //getting the whole json object from the response
            JSONObject obj = new JSONObject(response);
            ArrayList<Upcourse> retroModelArrayList = new ArrayList<>();
            JSONArray dataArray = obj.getJSONArray("data");
            courses = new ArrayList<>();

            for (int i = 0; i < dataArray.length(); i++) {
                Upcourse upcourse = new Upcourse();
                JSONObject jsonObject = dataArray.getJSONObject(i);

                upcourse.setName(jsonObject.getString("name"));

                retroModelArrayList.add(upcourse);
            }

            for (int j = 0; j < retroModelArrayList.size(); j++) {
                UpcommingCourse helper = new UpcommingCourse(
                        retroModelArrayList.get(j).getName() + "",
                        "10-4-19",
                        "5-5-19",
                        "48 ",
                        "5000",
                        "8000");

                courses.add(helper);

            }

            UpCommingCoursesAdapter();

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }


    private void initialRecyclerview() {
        mRecyclerViewUpcomingCourse = view.findViewById(R.id.upcomming_course_recyclerview);
        mRecyclerViewUpcomingCourse.setLayoutManager(new LinearLayoutManager(getContext()));

    }


    private void UpCommingCoursesAdapter() {
        mUpCommingCoursesAdapter = new UpCommingCourseAdapter(R.layout.design_upcoming_course, courses);
        mUpCommingCoursesAdapter.isFirstOnly(false);
        mUpCommingCoursesAdapter.openLoadAnimation();

        mRecyclerViewUpcomingCourse.setAdapter(mUpCommingCoursesAdapter);


        mUpCommingCoursesAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

            }
        });

        mUpCommingCoursesAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View v, int position) {
                switch (v.getId()) {

                    case R.id.enrollButton:
                        EnrollmentFormFragment formFragment = new EnrollmentFormFragment();
                        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.fragment_container, formFragment);
                        fragmentTransaction.commit();
                        break;
                }
            }
        });

    }





    private void texturl() {
        TextView previous_price = view.findViewById(R.id.previous_price_upcomming_course);
        previous_price.setPaintFlags(previous_price.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);


    }


}
