package ch.halcyon.bbcradioone;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.koushikdutta.ion.Ion;

import java.text.SimpleDateFormat;
import java.util.Date;

import ch.halcyon.bbcradioone.model.NowPlaying;
import ch.halcyon.bbcradioone.model.Show;


public class MainActivity extends ActionBarActivity {

    TextView songTitle, songArtist, /*untilFinished,*/
            currentShow;
    DataService dataService;
    ImageView imageView;

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
        NowPlaying nowPlaying = dataService.getNowPlaying();

        String text = "<b>Artist:</b>   " + nowPlaying.getRealtime().getArtist();
        songArtist.setText(Html.fromHtml(text));

        String text_song = "<b>Song:</b>   " + nowPlaying.getRealtime().getTitle();
        songTitle.setText(Html.fromHtml(text_song));

        Ion.with(imageView)
                .placeholder(R.drawable.ic_launcher)
                .error(R.drawable.ic_launcher)
                .load(dataService.getNowPlayingImageUrl(nowPlaying.getRealtime().getRecord_id()));

        Date date = new Date(nowPlaying.getRealtime().getEnd().longValue() * 1000);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");

        Show show = dataService.getCurrentShow();
        String text_show = "<b>" + show.getResults().get340()[1].getName() + "</b><br/>" + show.getResults().get340()[1].getDescription();
        currentShow.setText(Html.fromHtml(text_show));

    }


}
