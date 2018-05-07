package com.example.a16022895.demoexplicitintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HeroStatsActivity extends AppCompatActivity {

    TextView tvName, tvStrength, tvTechnical;
    Button btLike, btDislike;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero_stats);

        // Get the intent
        Intent i = getIntent();
        // Get the Hero object first activity put in Intent
        Hero hero = (Hero) i.getSerializableExtra("hero");

        tvName = findViewById(R.id.tvName);
        tvStrength = findViewById(R.id.tvStrength);
        tvTechnical = findViewById(R.id.tvTechnical);

        tvName.setText(hero.getName());
        tvStrength.setText("Strength: " + hero.getStrength());
        tvTechnical.setText("Technical: " + hero.getTechnicalProwess());

        btLike = findViewById(R.id.btLike);
        btDislike = findViewById(R.id.btDislike);

        btLike.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                // Create intent & pass in String data
                Intent i = new Intent();
                i.putExtra("like", "like");
                // Set result to RESULT_OK to indicate normal			// response and pass in the intent containing the 		// like
                setResult(RESULT_OK, i);
                finish();
            }});

        btDislike.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                //Create intent & pass in String data
                Intent i = new Intent();
                i.putExtra("like", "dislike");
                // Set result to RESULT_OK to indicate normal
                // response and pass in the intent containing the
                // dislike
                setResult(RESULT_OK, i);
                finish();
            }});
}
}
