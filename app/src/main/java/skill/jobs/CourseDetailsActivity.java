package skill.jobs;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.res.ResourcesCompat;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.internal.CollapsingTextHelper;

public class CourseDetailsActivity extends AppCompatActivity {
    Intent mintent;
    private String title="", summary="", detail="";
    private CollapsingToolbarLayout collapsingToolbar;
    private CollapsingTextHelper collapsingTextHelper;

    TextView Summary;
    TextView Detail;
    TextView Title;




    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_details);
        Toolbar toolbar;
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        collapsingToolbar = findViewById(R.id.collapsing_toolbar);

        Title = findViewById(R.id.course_title);
        Summary = findViewById(R.id.jd_summaryOverview);
        Detail = findViewById(R.id.jd_contentOverview);

        /*CHANGING THE COLLAPSING TOOLBAR TITLE FONT STYLE USING TYPEFACE*/
        final Typeface tf = ResourcesCompat.getFont(this, R.font.open_sans_regular);

        collapsingToolbar.setCollapsedTitleTypeface(tf);
        collapsingToolbar.setExpandedTitleTypeface(tf);

        collapsingTextHelper = new CollapsingTextHelper(collapsingToolbar);
        collapsingTextHelper.setExpandedTextSize(3);
        collapsingTextHelper.setExpandedTextSize(14);

        retrivedata();
        setdata();

    }

    private void setdata() {

        Title.setText(title);

        if (summary.equals("null")) {
            Summary.setVisibility(View.GONE);
        } else {
            Summary.setText(Html.fromHtml(summary));
        }

        if (detail.equals("null")) {
            Detail.setVisibility(View.GONE);
        } else {
            Detail.setText(Html.fromHtml(detail));
        }
    }


    private void retrivedata() {
        mintent = getIntent();
        title = mintent.getStringExtra("Title");
        summary = mintent.getStringExtra("Summary");
        detail = mintent.getStringExtra("Detail");


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
