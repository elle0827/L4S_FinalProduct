package elle0827.io.l4s_sns_apps_;

import java.io.Serializable;

public class Post implements Serializable{
    private String memo;
    private String url;
    private int likeCount;

    public Post(String memo, String url, int likeCount) {
        this.memo = memo;
        this.url = url;
        this.likeCount = likeCount;
    }

    public Post() {
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
