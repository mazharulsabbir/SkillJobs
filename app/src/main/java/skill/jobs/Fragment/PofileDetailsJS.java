package skill.jobs.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import skill.jobs.R;


public class PofileDetailsJS extends Fragment {
    ImageView pro_I_edit;
    View view;
    boolean pro_edit_flag=true,pro_edit_open=true;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_pofile_details_js, container, false);
        pro_I_edit=view.findViewById(R.id.js_pro_edit_imaage);
        pro_I_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProfileInformationEditJobSeeker();
            }
        });






        return view;
    }

private void ProfileInformationEditJobSeeker(){
    FrameLayout fr=view.findViewById(R.id.js_profile_edit_container);

        if (pro_edit_flag){
            if (pro_edit_open) {

                //profile edit fragment open
                Fragment fragment = new ProfileEditJobseekerFragment();
                FragmentManager fm = getFragmentManager();
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
                fragmentTransaction.add(R.id.js_profile_edit_container, fragment).commit();
                pro_edit_open=false;
            }
            fr.setVisibility(View.VISIBLE);
            pro_edit_flag = false;
        }else {


            fr.setVisibility(View.GONE);
            pro_edit_flag=true;
        }

}

}
