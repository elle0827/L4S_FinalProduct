package elle0827.io.l4s_sns_apps_;

import java.io.Serializable;

public class Post implements Serializable{
    private String memo;
    private String url;
    private int likeCount;
    private String key;
//    private int ImageId;

    public Post(String memo, String url, int likeCount, int imageId) {
        this.memo = memo;
        this.url = url;
        this.likeCount = likeCount;
        this.key = key;
//        this.ImageId = ImageId;
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

//    public int getImageId(){
//        return ImageId;}
//
//    public void setImageId(int ImageId){this.ImageId = ImageId;}

    public String getkey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
