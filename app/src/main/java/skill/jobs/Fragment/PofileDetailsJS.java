package skill.jobs.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

import skill.jobs.R;
import skill.jobs.RecyclerView.ProfileInformationAdapter;
import skill.jobs.RecyclerView.ProfileInformationHelper;


public class PofileDetailsJS extends Fragment {
    ImageView pro_I_edit;
    View view;
    boolean pro_edit_flag = true, pro_edit_open = true;

    private int drawables[] = {R.drawable.ic_my_location_black_24dp, R.drawable.ic_phone_black_24dp, R.drawable.ic_date_black_24dp,
            R.drawable.ic_gender, R.drawable.ic_marriage_ring, R.drawable.ic_nationality,
            R.drawable.ic_expected_salary, R.drawable.ic_national_id, R.drawable.ic_passport,
            R.drawable.ic_date_black_24dp, R.drawable.ic_present_address, R.drawable.ic_parmanent_address,
            R.drawable.ic_male, R.drawable.ic_female};

    private String title[] = {"Lives In", "Contact No", "Birth Date", "Gender", "Marital Status",
            "Nationality", "Expected Salary", "National ID", "Passport No",
            "Birth Certificate", "Present Address", "Permanent Address", "Father Name", "Mother Name"};

    private RecyclerView mRecyclerViewProfileInfo;
    private List<ProfileInformationHelper> info;
    private BaseQuickAdapter mProfileInformation;
    private NestedScrollView mNestedScrollView;
    private ProfileInformationHelper profileInformationHelper;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.design_job_seeker_profile_ui, container, false);

        mNestedScrollView = view.findViewById(R.id.nestedScrollView);

        mRecyclerViewProfileInfo = view.findViewById(R.id.recycler_view);
        mRecyclerViewProfileInfo.setLayoutManager(new LinearLayoutManager(getContext()));

        initSampleData();
        featureJobsAdapter();

        TextView mEditProfile = view.findViewById(R.id.edit_profile);
        mEditProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), EditJobSeekerProfile.class));
            }
        });

        return view;
    }

    private void initSampleData() {
        info = new ArrayList<>();

        String mUserInfo[] = {"Dhaka, Bangladesh", "01825632294", "1999-02-12", "Male", "Unmarried", "Bangladeshi",
                "-", "1954886790", "-", "-", "103 Central Bashabo, Khilgaon, District: Dhaka, Post Code: 1219, Bangladesh",
                "Sakhipur 4 no ward, Tangail, Post Code: 1950, Dhaka , Bangladesh",
                "Md. Lutfar Rahman", "Mazeda"
        };

        for (int i = 0; i < mUserInfo.length; i++) {
            profileInformationHelper = new ProfileInformationHelper(drawables[i], title[i], mUserInfo[i]);
            info.add(i, profileInformationHelper);
        }
    }

    @SuppressWarnings("unchecked")
    private void featureJobsAdapter() {
        //jobsList.clear();
        mProfileInformation = new ProfileInformationAdapter(R.layout.example_profile_info_ui, info);
        mProfileInformation.isFirstOnly(false);
        mProfileInformation.openLoadAnimation();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mRecyclerViewProfileInfo.setAdapter(mProfileInformation);
            }
        }, 200);
    }
}
