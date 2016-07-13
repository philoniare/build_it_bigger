package com.example.philoniare.jokerview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


public class JokerViewActivity extends AppCompatActivity {
  public final static String EXTRA_JOKE = "joke";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_jokerview);
    Intent intent = getIntent();
    String joke = intent.getStringExtra(EXTRA_JOKE);
    TextView jokeTV = (TextView) findViewById(R.id.jokeTV);
    jokeTV.setText(joke);
  }
}
