package skill.jobs.Fragment;

import android.content.Context;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

import skill.jobs.R;
import skill.jobs.RecyclerView.Adapter.RunningCourseAdapter;
import skill.jobs.RecyclerView.Adapter.UpCommingCourseAdapter;
import skill.jobs.RecyclerView.Helper.RunningCourseHelper;
import skill.jobs.RecyclerView.Helper.UpcommingCourse;

public class TrainingFragment extends Fragment {

    private View view;
    private List<UpcommingCourse> courses;
    private List<RunningCourseHelper> RunnigCourses;

    private BaseQuickAdapter mUpCommingCoursesAdapter;
    private BaseQuickAdapter mRunningCoursesAdapter;

    private RecyclerView mRecyclerViewUpcomingCourse;
    private  RecyclerView mRecyclerViewRunningCourse;

    public TrainingFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_training, container, false);


        initializecourse();
        initRecyclerView();
        UpCommingCoursesAdapter();
        RunningCoursesAdapter();




        return  view;
    }

    private void RunningCoursesAdapter() {
       mRunningCoursesAdapter=new RunningCourseAdapter(R.layout.design_running_course,RunnigCourses);
       mRunningCoursesAdapter.isFirstOnly(false);
       mRunningCoursesAdapter.openLoadAnimation();
       mRecyclerViewRunningCourse.setAdapter(mRunningCoursesAdapter);


    }

    private void texturl() {
        TextView previous_price = view.findViewById(R.id.previous_price_upcomming_course);
        previous_price.setPaintFlags(previous_price.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);


    }

    private void UpCommingCoursesAdapter() {
        mUpCommingCoursesAdapter=new UpCommingCourseAdapter(R.layout.design_upcoming_course,courses);
        mUpCommingCoursesAdapter.isFirstOnly(false);
        mUpCommingCoursesAdapter.openLoadAnimation();

        mRecyclerViewUpcomingCourse.setAdapter(mUpCommingCoursesAdapter);
    }


    private void initRecyclerView() {
        mRecyclerViewUpcomingCourse= view.findViewById(R.id.upcomming_course_recyclerview);
        mRecyclerViewUpcomingCourse.setLayoutManager(new LinearLayoutManager(getContext()));

        mRecyclerViewRunningCourse=view.findViewById(R.id.running_course_recyclerview);
        mRecyclerViewRunningCourse.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private void initializecourse() {

        courses =new ArrayList<>();
        for (int i=0;i<10;i++) {
            UpcommingCourse course = new UpcommingCourse(
                    "COURSE TITLE",
                    "10-4-19",
                    "5-5-19",
                    "48",
                    "5000",
                    "8000");
            courses.add(course);
        }

        RunnigCourses=new ArrayList<>();
        for(int i=0;i<10;i++){
            RunningCourseHelper helper=new RunningCourseHelper(
                    "Title",
                    "50"
            );
            RunnigCourses.add(helper);
        }

    }

}
