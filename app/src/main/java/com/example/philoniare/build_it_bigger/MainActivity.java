package com.example.philoniare.build_it_bigger;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.philoniare.jokerview.JokerViewActivity;



public class MainActivity extends AppCompatActivity {
  private FetchJokeAsyncTask fetchJokeAsyncTask;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // Launch Android library
    final Context mContext = this;
    fetchJokeAsyncTask = new FetchJokeAsyncTask(new FetchJokeAsyncTask.OnFetchCompleted() {
      @Override
      public void OnFetchCompleted(String joke) {
        Intent intent = new Intent(mContext, JokerViewActivity.class);
        intent.putExtra(JokerViewActivity.EXTRA_JOKE, joke);
        startActivity(intent);
      }
    });
  }

  public void fetchJoke(View view) {
    fetchJokeAsyncTask.execute();
  }
}
