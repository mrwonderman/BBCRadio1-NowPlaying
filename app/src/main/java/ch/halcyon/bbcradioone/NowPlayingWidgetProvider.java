package ch.halcyon.bbcradioone;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.widget.RemoteViews;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import ch.halcyon.bbcradioone.model.NowPlaying;

/**
 * Created by yansigner on 22.02.15.
 */
public class NowPlayingWidgetProvider extends AppWidgetProvider {
    public static final String ACTION_AUTO_UPDATE = "AUTO_UPDATE";

    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);

        if (intent.getAction().equals(ACTION_AUTO_UPDATE)) {
            AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
            ComponentName thisAppWidget = new ComponentName(context.getPackageName(), NowPlayingWidgetProvider.class.getName());
            int[] appWidgetIds = appWidgetManager.getAppWidgetIds(thisAppWidget);
            onUpdate(context, appWidgetManager, appWidgetIds);
        }
    }

    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        final int N = appWidgetIds.length;

        // Perform this loop procedure for each App Widget that belongs to this provider
        for (int i = 0; i < N; i++) {
            int appWidgetId = appWidgetIds[i];

            // Create an Intent to launch ExampleActivity
            Intent intent = new Intent(context, MainActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);

            // Get the layout for the App Widget and attach an on-click listener
            // to the button
            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.nowplaying_widget);
            views.setOnClickPendingIntent(R.id.imageView3, pendingIntent);

            DataService dataService = new DataService();
            NowPlaying nowPlaying = dataService.getNowPlaying();

            String text = nowPlaying.getRealtime().getArtist();
            String text_song = nowPlaying.getRealtime().getTitle();

            views.setTextViewText(R.id.textView, text + " - " + text_song);
            try {
                views.setImageViewBitmap(R.id.imageView3, getImageBitmap(dataService.getNowPlayingImageUrl(nowPlaying.getRealtime().getRecord_id())));
            } catch (Exception e) {
            }
            // Tell the AppWidgetManager to perform an update on the current app widget
            appWidgetManager.updateAppWidget(appWidgetId, views);
        }
    }

    @Override
    public void onEnabled(Context context) {
        // start alarm
        AppWidgetAlarm appWidgetAlarm = new AppWidgetAlarm(context.getApplicationContext());
        appWidgetAlarm.startAlarm();
    }

    @Override
    public void onDisabled(Context context) {
        // stop alarm
        AppWidgetAlarm appWidgetAlarm = new AppWidgetAlarm(context.getApplicationContext());
        appWidgetAlarm.stopAlarm();
    }

    private Bitmap getImageBitmap(String url) throws Exception {
        Bitmap bm = null;
        try {
            URL aURL = new URL(url);
            URLConnection conn = aURL.openConnection();
            conn.connect();
            InputStream is = conn.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(is);
            bm = BitmapFactory.decodeStream(bis);
            bis.close();
            is.close();
        } catch (IOException e) {
            Log.e(MainActivity.LOGGING_TAG, "Error getting bitmap", e);
        }
        return bm;
    }

}