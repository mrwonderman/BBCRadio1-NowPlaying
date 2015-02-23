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
    private NowPlaying nowPlaying = null;
    private Image image = null;
    private Show show = null;

    DataService() {
    }


    public NowPlaying getNowPlaying() {
        BbcRadioOneRestClient.getNowPlaying(new TextHttpResponseHandler() {

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                Log.e(MainActivity.LOGGING_TAG, "error while getting the 'now playing' data: " + throwable.getMessage());
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                nowPlaying = new Gson().fromJson(responseString, NowPlaying.class);
            }
        });

        return nowPlaying;
    }

    public String getNowPlayingImageUrl(String id) {
        BbcRadioOneRestClient.getNowPlayingImg(id, new TextHttpResponseHandler() {

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                Log.e(MainActivity.LOGGING_TAG, "error while getting the 'now playing cover': " + throwable.getMessage());
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                image = new Gson().fromJson(responseString, Image.class);
            }
        });

        return image.getImageUrl();
    }

    public Show getCurrentShow() {
        BbcRadioOneRestClient.getCurrentShow(new TextHttpResponseHandler() {

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                Log.e(MainActivity.LOGGING_TAG, "error while getting the 'current show' data: " + throwable.getMessage());
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                show = new Gson().fromJson(responseString.substring(9, responseString.length() - 1), Show.class);
            }
        });

        return show;
    }
}
