package skill.jobs.JobSeeker.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

import skill.jobs.JobSeeker.EditJobSeekerProfile;
import skill.jobs.R;
import skill.jobs.RecyclerView.Adapter.CertificationsAdapter;
import skill.jobs.RecyclerView.Adapter.ContactInformationAdapter;
import skill.jobs.RecyclerView.Adapter.EducationAdapter;
import skill.jobs.RecyclerView.Adapter.ProfileInformationAdapter;
import skill.jobs.RecyclerView.Adapter.ReferenceAdapter;
import skill.jobs.RecyclerView.Adapter.SkillsAdapter;
import skill.jobs.RecyclerView.Adapter.TrainingAdapter;
import skill.jobs.RecyclerView.Adapter.WorkExperienceAdapter;
import skill.jobs.RecyclerView.Helper.CertificationsHelper;
import skill.jobs.RecyclerView.Helper.ContactInformationHelper;
import skill.jobs.RecyclerView.Helper.EducationHelper;
import skill.jobs.RecyclerView.Helper.ProfileInformationHelper;
import skill.jobs.RecyclerView.Helper.ReferenceHelper;
import skill.jobs.RecyclerView.Helper.SkillsHelper;
import skill.jobs.RecyclerView.Helper.TrainingHelper;
import skill.jobs.RecyclerView.Helper.WorkExperienceHepler;


public class PofileDetailsJS extends Fragment implements View.OnClickListener {
    ImageView pro_I_edit;
    View view;
    boolean pro_edit_flag = true, pro_edit_open = true;

    private int[] drawables = {R.drawable.ic_my_location_black_24dp, R.drawable.ic_phone_black_24dp, R.drawable.ic_date_black_24dp,
            R.drawable.ic_gender, R.drawable.ic_marriage_ring, R.drawable.ic_nationality,
            R.drawable.ic_expected_salary, R.drawable.ic_national_id, R.drawable.ic_passport,
            R.drawable.ic_date_black_24dp, R.drawable.ic_present_address, R.drawable.ic_parmanent_address,
            R.drawable.ic_male, R.drawable.ic_female};

    private String[] title = {"Lives In", "Contact No", "Birth Date", "Gender", "Marital Status",
            "Nationality", "Expected Salary", "National ID", "Passport No",
            "Birth Certificate", "Present Address", "Permanent Address", "Father Name", "Mother Name"};

    private RecyclerView mRecyclerViewProfileInfo, mRecyclerViewWorkExperience, mRecyclerViewContactInformation,
            mRecyclerViewSkills, mRecyclerViewEducation, mRecyclerViewCertifications, mRecyclerViewTraining, mRecyclerViewReference;
    private List<ProfileInformationHelper> info;
    private BaseQuickAdapter mProfileInformation, mWorkExperience, mContactInfo, mSkills, mEducation, mCertifications, mTraining, mReference;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_profile_details_js, container, false);

        NestedScrollView mNestedScrollView = view.findViewById(R.id.nestedScrollView);

        initSampleData();
        initiateRecyclerViews();
        initiateRecyclerViewAdapters();

        setAdapters();//connection between recyclerView and adapters


        //ON CLICK SEGMENT
        initiateOnClick();

        return view;
    }

    private void initiateRecyclerViews() {
        mRecyclerViewProfileInfo = view.findViewById(R.id.recycler_view);
        mRecyclerViewProfileInfo.setLayoutManager(new LinearLayoutManager(getContext()));

        mRecyclerViewWorkExperience = view.findViewById(R.id.recycler_view_work_experience);
        mRecyclerViewWorkExperience.setLayoutManager(new LinearLayoutManager(getContext()));

        mRecyclerViewContactInformation = view.findViewById(R.id.recycler_view_contact_information);
        mRecyclerViewContactInformation.setLayoutManager(new LinearLayoutManager(getContext()));

        mRecyclerViewSkills = view.findViewById(R.id.recycler_view_skills);
        mRecyclerViewSkills.setLayoutManager(new LinearLayoutManager(getContext()));

        mRecyclerViewEducation = view.findViewById(R.id.recycler_view_education);
        mRecyclerViewEducation.setLayoutManager(new LinearLayoutManager(getContext()));

        mRecyclerViewCertifications = view.findViewById(R.id.recycler_view_certifications);
        mRecyclerViewCertifications.setLayoutManager(new LinearLayoutManager(getContext()));

        mRecyclerViewTraining = view.findViewById(R.id.recycler_view_training);
        mRecyclerViewTraining.setLayoutManager(new LinearLayoutManager(getContext()));

        mRecyclerViewReference = view.findViewById(R.id.recycler_view_reference);
        mRecyclerViewReference.setLayoutManager(new LinearLayoutManager(getContext()));

    }

    private void initiateRecyclerViewAdapters() {
        mProfileInformation = new ProfileInformationAdapter(R.layout.example_profile_info_ui, info);
        mProfileInformation.isFirstOnly(false);
        mProfileInformation.openLoadAnimation();


        List<WorkExperienceHepler> weh = new ArrayList<>();
        WorkExperienceHepler workExperienceHeplers = new WorkExperienceHepler("Org Name",
                "Position",
                "Join Date",
                "Resign Date");
        weh.add(workExperienceHeplers);
        weh.add(workExperienceHeplers);

        mWorkExperience = new WorkExperienceAdapter(R.layout.example_work_experience, weh);
        mWorkExperience.isFirstOnly(false);
        mWorkExperience.openLoadAnimation();


        List<ContactInformationHelper> ch = new ArrayList<>();
        ContactInformationHelper contactInformationHelper = new ContactInformationHelper("Contact Title", "Contact");
        ch.add(contactInformationHelper);
        ch.add(contactInformationHelper);

        mContactInfo = new ContactInformationAdapter(R.layout.example_contact_information, ch);
        mContactInfo.isFirstOnly(false);
        mContactInfo.openLoadAnimation();


        List<SkillsHelper> sh = new ArrayList<>();
        SkillsHelper skillsHelper = new SkillsHelper("Skills Name", "Years Of XP");
        sh.add(skillsHelper);
        sh.add(skillsHelper);
        sh.add(skillsHelper);
        mSkills = new SkillsAdapter(R.layout.example_contact_information, sh);
        //we use contact information adapter over here because of same number of parameter.
        // That's why we skip to re design a same thing.
        mSkills.isFirstOnly(false);
        mSkills.openLoadAnimation();


        List<EducationHelper> eh = new ArrayList<>();
        EducationHelper educationHelper = new EducationHelper("Degree Level",
                "Degree Title",
                "Grade",
                "3.7",
                "First Class",
                "Passing Year",
                "Institution");
        eh.add(educationHelper);
        eh.add(educationHelper);

        mEducation = new EducationAdapter(R.layout.example_education, eh);
        mEducation.isFirstOnly(false);
        mEducation.openLoadAnimation();


        List<CertificationsHelper> ceh = new ArrayList<>();
        CertificationsHelper certificationsHelper = new CertificationsHelper("Certification Name",
                "Exam Date",
                "Score",
                "Score Scale");
        ceh.add(certificationsHelper);
        ceh.add(certificationsHelper);
        mCertifications = new CertificationsAdapter(R.layout.example_certifications, ceh);
        mCertifications.isFirstOnly(false);
        mCertifications.openLoadAnimation();


        List<TrainingHelper> th = new ArrayList<>();
        TrainingHelper trainingHelper = new TrainingHelper("Training Type",
                "Training Title",
                "Training Duration",
                "Training Start Date",
                "Training End Date",
                "Training Certification");
        th.add(trainingHelper);
        th.add(trainingHelper);
        mTraining = new TrainingAdapter(R.layout.example_training, th);
        mTraining.isFirstOnly(false);
        mTraining.openLoadAnimation();


        List<ReferenceHelper> rh = new ArrayList<>();
        ReferenceHelper referenceHelper = new ReferenceHelper("Person Name",
                "Designation",
                "Org Name",
                "Contact No",
                "Email Address",
                "Relation");
        rh.add(referenceHelper);
        rh.add(referenceHelper);
        mReference = new ReferenceAdapter(R.layout.example_reference, rh);
        mReference.isFirstOnly(false);
        mReference.openLoadAnimation();

    }

    private void setAdapters() {
        mRecyclerViewProfileInfo.setAdapter(mProfileInformation);

        mRecyclerViewWorkExperience.setAdapter(mWorkExperience);

        mRecyclerViewContactInformation.setAdapter(mContactInfo);

        mRecyclerViewSkills.setAdapter(mSkills);

        mRecyclerViewEducation.setAdapter(mEducation);

        mRecyclerViewCertifications.setAdapter(mCertifications);

        mRecyclerViewTraining.setAdapter(mTraining);

        mRecyclerViewReference.setAdapter(mReference);

    }

    private void initSampleData() {
        info = new ArrayList<>();

        String[] mUserInfo = {"Dhaka, Bangladesh", "01825632294", "1999-02-12", "Male", "Unmarried", "Bangladeshi",
                "-", "1954886790", "-", "-", "103 Central Bashabo, Khilgaon, District: Dhaka, Post Code: 1219, Bangladesh",
                "Sakhipur 4 no ward, Tangail, Post Code: 1950, Dhaka , Bangladesh",
                "Md. Lutfar Rahman", "Mazeda"
        };

        for (int i = 0; i < mUserInfo.length; i++) {
            ProfileInformationHelper profileInformationHelper = new ProfileInformationHelper(drawables[i], title[i], mUserInfo[i]);
            info.add(i, profileInformationHelper);
        }
    }

    private void initiateOnClick() {
        TextView mEditProfile, addWorkXp, addContact, addSkills, addEdu, addCertificate, addTraining, addReference;

        mEditProfile = view.findViewById(R.id.edit_profile);
        mEditProfile.setOnClickListener(this);

        addWorkXp = view.findViewById(R.id.tv_add_work_experience);
        addWorkXp.setOnClickListener(this);

        addContact = view.findViewById(R.id.tv_add_contact_info);
        addContact.setOnClickListener(this);

        addSkills = view.findViewById(R.id.tv_add_skills);
        addSkills.setOnClickListener(this);

        addEdu = view.findViewById(R.id.tv_add_education);
        addEdu.setOnClickListener(this);

        addCertificate = view.findViewById(R.id.tv_add_certifications);
        addCertificate.setOnClickListener(this);

        addTraining = view.findViewById(R.id.tv_add_training);
        addTraining.setOnClickListener(this);

        addReference = view.findViewById(R.id.tv_add_reference);
        addReference.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.edit_profile:
                startActivity(new Intent(getActivity(), EditJobSeekerProfile.class));
                break;

            case R.id.tv_add_work_experience:
                //do your staff here
                Toast.makeText(getContext(), "Clicked", Toast.LENGTH_SHORT).show();
                break;

            case R.id.tv_add_contact_info:
                //do your staff here
                Toast.makeText(getContext(), "Clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_add_skills:
                //do your staff here
                Toast.makeText(getContext(), "Clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_add_education:
                //do your staff here
                Toast.makeText(getContext(), "Clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_add_certifications:
                //do your staff here
                Toast.makeText(getContext(), "Clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_add_training:
                //do your staff here
                Toast.makeText(getContext(), "Clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_add_reference:
                //do your staff here
                Toast.makeText(getContext(), "Clicked", Toast.LENGTH_SHORT).show();
                break;

        }
    }
}
