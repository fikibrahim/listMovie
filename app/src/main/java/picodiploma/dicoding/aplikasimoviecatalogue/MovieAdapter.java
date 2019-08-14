package picodiploma.dicoding.aplikasimoviecatalogue;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MovieAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Movie> movies;

    public MovieAdapter(Context context) {
        this.context = context;
        movies = new ArrayList<>( );
    }

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int i) {
        return movies.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null){
            view = LayoutInflater.from( context ).inflate( R.layout.list_item_movie, viewGroup,false );
        }
        ViewHolder viewHolder = new ViewHolder(view);
        Movie movie = (Movie) getItem( i );
        viewHolder.bind(movie);
        return view;
    }

    private class ViewHolder {
        private TextView txtJudul;
        private TextView txtTgl;
        private TextView txtDesc;
        private ImageView imgPoster;

        ViewHolder(View view) {
            txtJudul = view.findViewById( R.id.txtJudul_id );
            txtTgl = view.findViewById( R.id.txtDate_id );
            txtDesc = view.findViewById( R.id.txtDesc_id );
            imgPoster = view.findViewById( R.id.imgPoster_id );
        }

        public void bind(Movie movie) {
            txtJudul.setText( movie.getJudul() );
            txtTgl.setText( movie.getRilis() );
            txtDesc.setText( movie.getDescription() );
            imgPoster.setImageResource( movie.getImage());
        }
    }
}
