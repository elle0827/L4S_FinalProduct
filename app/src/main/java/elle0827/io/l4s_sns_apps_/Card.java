package elle0827.io.l4s_sns_apps_;

public class Card {

    private String title;
    private String content;
    private int likecount=0;

    public Card(String title, String content, int likecount) {

        this.title = title;
        this.content = content;
        this.likecount = likecount;

    }
    public Card(){

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getlikecount() {
        return likecount;
    }

    public void setlikecount(int likecount) {
        this.likecount = likecount;
    }
}
