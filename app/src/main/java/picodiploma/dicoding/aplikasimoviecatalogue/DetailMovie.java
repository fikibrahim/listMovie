package picodiploma.dicoding.aplikasimoviecatalogue;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailMovie extends AppCompatActivity {

    ImageView img;
    TextView judul,rilis,overview;
    Movie movie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_detail_movie );

        movie = new Movie();
        movie = getIntent().getParcelableExtra( "movie" );
        img = findViewById( R.id.imgPoster_id );
        judul = findViewById( R.id.txtJudul_id );
        rilis = findViewById( R.id.txtDate_id );
        overview = findViewById( R.id.txtOverview_id );
        Toast.makeText( this, movie.getJudul(), Toast.LENGTH_SHORT ).show();

        img.setImageResource( movie.getImage() );
        judul.setText( movie.getJudul() );
        rilis.setText( movie.getRilis() );
        overview.setText( movie.getDescription() );
    }
}
