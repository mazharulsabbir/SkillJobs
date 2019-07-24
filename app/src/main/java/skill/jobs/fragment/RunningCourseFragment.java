package skill.jobs.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

import skill.jobs.R;
import skill.jobs.recyclerview.adapter.RunningCourseAdapter;
import skill.jobs.recyclerview.helper.RunningCourseHelper;

public class RunningCourseFragment extends Fragment {
    View view;
    private List<RunningCourseHelper> RunnigCourses;

    private BaseQuickAdapter mRunningCoursesAdapter;

    private RecyclerView mRecyclerViewRunningCourse;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_running_course, container, false);

        initializecourse();
        initRecyclerView();
        RunningCoursesAdapter();



        return view;
    }

    private void RunningCoursesAdapter() {
        mRunningCoursesAdapter=new RunningCourseAdapter(R.layout.design_running_course,RunnigCourses);
        mRunningCoursesAdapter.isFirstOnly(false);
        mRunningCoursesAdapter.openLoadAnimation();
        mRecyclerViewRunningCourse.setAdapter(mRunningCoursesAdapter);


    }




    private void initRecyclerView() {

        mRecyclerViewRunningCourse=view.findViewById(R.id.running_course_recyclerview);
        mRecyclerViewRunningCourse.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private void initializecourse() {


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
