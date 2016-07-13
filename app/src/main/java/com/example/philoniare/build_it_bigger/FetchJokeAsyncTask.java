package com.example.philoniare.build_it_bigger;

import android.os.AsyncTask;

import com.example.philoniare.myapplication.backend.jokerApi.JokerApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

public class FetchJokeAsyncTask extends AsyncTask<Void, Void, String> {

  private static JokerApi jokerApiService = null;
  private OnFetchCompleted mListener;

  public FetchJokeAsyncTask(OnFetchCompleted listener) {
    mListener = listener;
  }

  @Override
  protected String doInBackground(Void... params) {
    if(jokerApiService == null) {  // Only do this once
      JokerApi.Builder builder = new JokerApi.Builder(AndroidHttp.newCompatibleTransport(),
              new AndroidJsonFactory(), null)
              // options for running against local devappserver
              // - 10.0.2.2 is localhost's IP address in Android emulator
              // - turn off compression when running against local devappserver
              .setApplicationName("Joker App")
              .setRootUrl("http://10.0.2.2:8080/_ah/api/")
              .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                @Override
                public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                  abstractGoogleClientRequest.setDisableGZipContent(true);
                }
              });
      jokerApiService = builder.build();
    }

    try {
      return jokerApiService.fetchJoke().execute().getData();
    } catch (IOException e) {
      return e.getMessage();
    }
  }

  @Override
  protected void onPostExecute(String result) {
    mListener.OnFetchCompleted(result);
  }

  public interface OnFetchCompleted {
    // Update the UI after network fetch
    void OnFetchCompleted(String joke);
  }
}

