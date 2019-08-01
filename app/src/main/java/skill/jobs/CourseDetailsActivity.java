package skill.jobs;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class CourseDetailsActivity extends AppCompatActivity {
    Intent mintent;
    private String title,summary,detail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_details);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        retrivedata();
        setdata();


    }

    private void setdata() {
        TextView Title=findViewById(R.id.jd_courseTitle);
        Title.setText(title);
        TextView Summary=findViewById(R.id.jd_summaryOverview);

        if (summary.equals("null")){
            Summary.setVisibility(View.GONE);

        }else {

            Summary.setText(Html.fromHtml(summary));
        }


        TextView Detail=findViewById(R.id.jd_contentOverview);
        if (detail.equals("null")){
            Detail.setVisibility(View.GONE);
        }else {
            Detail.setText(Html.fromHtml(detail));
        }
    }


    private void retrivedata(){
        mintent=getIntent();
        title=mintent.getStringExtra("Title");
        summary=mintent.getStringExtra("Summary");
        detail=mintent.getStringExtra("Detail");


    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                super.onBackPressed();
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }
    }
}
