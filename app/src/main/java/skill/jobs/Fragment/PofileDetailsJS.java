package skill.jobs.Fragment;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

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

    private RecyclerView mRecyclerViewProfileInfo;
    private List<ProfileInformationHelper> info;
    private BaseQuickAdapter mProfileInformation;
    private NestedScrollView mNestedScrollView;
    private ProfileInformationHelper helper;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.design_job_seeker_profile_ui, container, false);
//        pro_I_edit = view.findViewById(R.id.js_pro_edit_imaage);
//        pro_I_edit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ProfileInformationEditJobSeeker();
//            }
//        });
        mNestedScrollView = view.findViewById(R.id.nestedScrollView);

        mRecyclerViewProfileInfo = view.findViewById(R.id.recycler_view);
        mRecyclerViewProfileInfo.setLayoutManager(new LinearLayoutManager(getContext()));

        initSampleData();
        featureJobsAdapter();

        mNestedScrollView.fullScroll(View.FOCUS_UP);
        mNestedScrollView.smoothScrollTo(0,0);

        return view;
    }

    private void initSampleData() {
        info = new ArrayList<>();

        helper = new ProfileInformationHelper(R.drawable.ic_settings_black_24dp, "Lives In", "Dhaka, Bangladesh");
        info.add(0, helper);

        helper = new ProfileInformationHelper(R.drawable.ic_settings_black_24dp, "Contact No", "01825632294");
        info.add(1, helper);

        helper = new ProfileInformationHelper(R.drawable.ic_settings_black_24dp, "Birth Date", "1999-02-12");
        info.add(2, helper);

        helper = new ProfileInformationHelper(R.drawable.ic_settings_black_24dp, "Gender", "Male");
        info.add(3, helper);

        helper = new ProfileInformationHelper(R.drawable.ic_settings_black_24dp, "Marital Status", "Unmarried");
        info.add(4, helper);

        helper = new ProfileInformationHelper(R.drawable.ic_settings_black_24dp, "Nationality", "Bangladesh");
        info.add(5, helper);

        helper = new ProfileInformationHelper(R.drawable.ic_settings_black_24dp, "Expected Salary", "");
        info.add(6, helper);

        helper = new ProfileInformationHelper(R.drawable.ic_settings_black_24dp, "National ID", "1954886790");
        info.add(7, helper);

        helper = new ProfileInformationHelper(R.drawable.ic_settings_black_24dp, "Passport No", "");
        info.add(8, helper);

        helper = new ProfileInformationHelper(R.drawable.ic_settings_black_24dp, "Birth Certificate", "");
        info.add(9, helper);

        helper = new ProfileInformationHelper(R.drawable.ic_settings_black_24dp, "Present Address", "103 Central Bashabo, Khilgaon, District: Dhaka, Post Code: 1219, Bangladesh");
        info.add(10, helper);

        helper = new ProfileInformationHelper(R.drawable.ic_settings_black_24dp, "Permanent Address", "Sakhipur 4 no ward, Tangail, Post Code: 1950, Dhaka , Bangladesh");
        info.add(11, helper);

        helper = new ProfileInformationHelper(R.drawable.ic_settings_black_24dp, "Father Name", "Md. Lutfar Rahman");
        info.add(12, helper);

        helper = new ProfileInformationHelper(R.drawable.ic_settings_black_24dp, "Mother Name", "Mazeda");
        info.add(13, helper);
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


   /* private void ProfileInformationEditJobSeeker() {
        FrameLayout fr = view.findViewById(R.id.js_profile_edit_container);

        if (pro_edit_flag) {
            if (pro_edit_open) {

                //profile edit fragment open
                Fragment fragment = new ProfileEditJobseekerFragment();
                FragmentManager fm = getFragmentManager();
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
                fragmentTransaction.add(R.id.js_profile_edit_container, fragment).commit();
                pro_edit_open = false;
            }
            fr.setVisibility(View.VISIBLE);
            pro_edit_flag = false;
        } else {
            fr.setVisibility(View.GONE);
            pro_edit_flag = true;
        }

    }*/

}
