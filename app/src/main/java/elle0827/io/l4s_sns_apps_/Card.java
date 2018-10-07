package elle0827.io.l4s_sns_apps_;

public class Card {

    private String memo;
    private String url;
    private int likecount = 0;
    private int ImageId = 0;
    private String key;

    public Card(String key, String memo, String url, int likecount, int ImageId) {

        this.memo= memo;
        this.url = url;
        this.likecount = likecount;
        this.ImageId = ImageId;
        this.key = key;
    }

    public Card() {

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

    public int getlikecount() {
        return likecount;
    }

    public void setlikecount(int likecount) {
        this.likecount = likecount;
    }

    public int getImageId() {
        return ImageId;
    }

    public void setImageId(int ImageId) {
        this.ImageId = ImageId;
    }

    public String getkey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
