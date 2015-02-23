package ch.halcyon.bbcradioone;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.koushikdutta.ion.Ion;

import ch.halcyon.bbcradioone.model.Realtime;
import ch.halcyon.bbcradioone.model.Show;


public class MainActivity extends ActionBarActivity {

    public static String LOGGING_TAG = "BBCRadioNP";

    private TextView songTitle, songArtist,
            currentShow;
    private DataService dataService;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        songTitle = (TextView) findViewById(R.id.songtitle);
        songArtist = (TextView) findViewById(R.id.songartist);
        currentShow = (TextView) findViewById(R.id.current_show);

        dataService = new DataService();

        imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetInfo();
            }
        });

        resetInfo();
    }

    private void resetInfo() {
        Realtime realtime = dataService.getNowPlaying().getRealtime();

        String artist_text = "<b>Artist:</b>   " + realtime.getArtist();
        songArtist.setText(Html.fromHtml(artist_text));

        String song_text = "<b>Song:</b>   " + realtime.getTitle();
        songTitle.setText(Html.fromHtml(song_text));

        Ion.with(imageView)
                .placeholder(R.drawable.ic_launcher)
                .error(R.drawable.ic_launcher)
                .load(dataService.getNowPlayingImageUrl(realtime.getRecord_id()));

        Show show = dataService.getCurrentShow();
        String text_show = "<b>" + show.getResults().get340()[1].getName() + "</b><br/>" + show.getResults().get340()[1].getDescription();
        currentShow.setText(Html.fromHtml(text_show));

    }


}
