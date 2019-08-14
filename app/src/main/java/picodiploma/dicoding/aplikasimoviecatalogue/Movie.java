package picodiploma.dicoding.aplikasimoviecatalogue;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable {
    private int image;
    private String judul;
    private String rilis;
    private String description;


    protected Movie(Parcel in) {
        image = in.readInt();
        judul = in.readString();
        rilis = in.readString();
        description = in.readString();
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie( in );
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    public Movie() {

    }


    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getRilis() {
        return rilis;
    }

    public void setRilis(String rilis) {
        this.rilis = rilis;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt( image );
        dest.writeString( judul );
        dest.writeString( rilis );
        dest.writeString( description );
    }
}
