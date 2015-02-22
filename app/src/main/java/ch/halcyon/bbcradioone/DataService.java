package ch.halcyon.bbcradioone;

import android.util.Log;

import com.google.gson.Gson;
import com.loopj.android.http.TextHttpResponseHandler;

import org.apache.http.Header;

import ch.halcyon.bbcradioone.model.Image;
import ch.halcyon.bbcradioone.model.NowPlaying;
import ch.halcyon.bbcradioone.model.Show;

/**
 * Created by yannick on 09/02/15.
 */
public class DataService {
    NowPlaying np = null;
    Image image = null;
    Show showy = null;

    DataService() {

    }


    public NowPlaying getNowPlaying() {

        Log.d("bbc", "starting getting");

        BbcRadioOneRestClient.getNowPlaying(new TextHttpResponseHandler() {

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                Log.e("bbc", "error");
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                Log.d("bbc", responseString);

                Gson gson = new Gson();
                np = gson.fromJson(responseString, NowPlaying.class);

            }
        });

        return np;

    }

    public String getNowPlayingImageUrl(String id) {

        Log.d("bbc", "starting getting image");

        BbcRadioOneRestClient.getNowPlayingImg(id, new TextHttpResponseHandler() {

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                Log.e("bbc", "error");
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                Log.d("bbc", responseString);

                Gson gson = new Gson();
                image = gson.fromJson(responseString, Image.class);

            }
        });

        return image.getImageUrl();

    }

    public Show getCurrentShow() {

        Log.d("bbc", "starting getting current show");

        BbcRadioOneRestClient.getCurrentShow(new TextHttpResponseHandler() {

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                Log.e("bbc", "error");
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                Log.d("bbc", responseString);
                String s = responseString.substring(9, responseString.length() - 1);
                Log.d("bbc", s);
                Gson gson = new Gson();
                showy = gson.fromJson(s, Show.class);

            }
        });

        return showy;

    }
}
