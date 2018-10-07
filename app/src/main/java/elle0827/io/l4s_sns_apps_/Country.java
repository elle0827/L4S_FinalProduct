package elle0827.io.l4s_sns_apps_;

import java.io.Serializable;
import java.util.List;

public class Country implements Serializable{
    private String url;
    private String name;
    private List<Post> posts;

    public Country() {
    }

    public Country(String url, String name, List<Post> posts) {
        this.url = url;
        this.name = name;
        this.posts = posts;
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

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
