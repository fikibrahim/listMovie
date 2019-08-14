package picodiploma.dicoding.aplikasimoviecatalogue;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private String[] dataJudul;
    private String[] dataDate;
    private String[] dataDecs;
    private TypedArray dataImage;
    private MovieAdapter adapter;
    private ArrayList<Movie> movies;
    ListView listView;
    private TextView mTextMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        BottomNavigationView navView = findViewById( R.id.nav_view );
        mTextMessage = findViewById( R.id.message );
        navView.setOnNavigationItemSelectedListener( mOnNavigationItemSelectedListener );

        adapter = new MovieAdapter( this );

        listView = findViewById( R.id.listView_id );
        listView.setAdapter( adapter );

        listView.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DetailMovie.class );
                intent.putExtra( "movie",movies.get( position ) );
                startActivity( intent );
            }
        } );

        prepare();
        addItem();

    }

    private void prepare(){
        dataJudul = getResources().getStringArray( R.array.data_film );
        dataDate = getResources().getStringArray( R.array.data_rilis );
        dataDecs = getResources().getStringArray( R.array.data_description );
        dataImage = getResources().obtainTypedArray( R.array.data_image );

    }

    private void addItem(){
        movies = new ArrayList<>();

        for (int i = 0; i < dataJudul.length; i++){

            Movie movie = new Movie();
            movie.setImage( dataImage.getResourceId( i,-1 ) );
            movie.setJudul( dataJudul[i]);
            movie.setRilis( dataDate[i]);
            movie.setDescription( dataDecs[i]);
            movies.add( movie );
        }
        adapter.setMovies( movies );
    }


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_movie:
                    mTextMessage.setText( R.string.movie );
                    return true;
                case R.id.navigation_tvshow:
                    mTextMessage.setText( R.string.tv_show );
                    return true;
            }
            return false;
        }
    };

    @Override
    public void onClick(View v) {
    }
}

