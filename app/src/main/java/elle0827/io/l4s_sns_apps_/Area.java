package elle0827.io.l4s_sns_apps_;

import android.widget.LinearLayout;

import java.util.List;

public class Area {
    private String url;
    private String name;
    private List<Country> places;

    public Area() {
    }

    public Area(String url, String name, List<Country> places) {
        this.url = url;
        this.name = name;
        this.places = places;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Country> getPlaces() {
        return places;
    }

    public void setPlaces(List<Country> places) {
        this.places = places;
    }
}
