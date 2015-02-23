package ch.halcyon.bbcradioone;

import android.os.StrictMode;

import com.loopj.android.http.SyncHttpClient;
import com.loopj.android.http.TextHttpResponseHandler;

/**
 * Created by yannick on 09/02/15.
 */
public class BbcRadioOneRestClient {
    private static boolean isInitialized = false;

    private static final String NOW_PLAYING_URL = "http://polling.bbc.co.uk/radio/realtime/bbc_radio_one.json";
    private static final String NOW_PLAYING_IMG_URL = "http://www.bbc.co.uk/radio/player/trackimage/";
    private static final String CURRENT_SHOW_URL = "http://np.radioplayer.co.uk/qp/v3/onair?rpIds=340";


    private static SyncHttpClient client = new SyncHttpClient();

    private static void  initialize() {
        if (!isInitialized) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                    .permitAll().build();
            StrictMode.setThreadPolicy(policy);
            client.setUserAgent("runscope/0.1");
            client.addHeader("Accept-Encoding", "gzip, deflate, compress");
            client.addHeader("User-Agent", "runscope/0.1");
            client.addHeader("Accept", " */*");
            isInitialized = true;
        }
    }

    public static void getNowPlaying(TextHttpResponseHandler responseHandler) {
        initialize();
        client.get(NOW_PLAYING_URL, responseHandler);
    }

    public static void getNowPlayingImg(String image_id, TextHttpResponseHandler responseHandler) {
        initialize();
        client.get(NOW_PLAYING_IMG_URL + image_id, responseHandler);
    }

    public static void getCurrentShow(TextHttpResponseHandler responseHandler) {
        initialize();
        client.get(CURRENT_SHOW_URL, responseHandler);
    }


}
