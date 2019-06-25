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
import android.widget.ImageView;

import skill.jobs.R;


public class PofileDetailsJS extends Fragment {
    ImageView pro_I_edit;
    View view;

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
        Fragment fragment= new ProfileEditJobseekerFragment();
    FragmentManager fm = getFragmentManager();
    FragmentTransaction fragmentTransaction = fm.beginTransaction();
    fragmentTransaction.add(R.id.js_profile_edit_container,fragment).commit();

}

}
