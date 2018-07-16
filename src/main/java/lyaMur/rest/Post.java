package lyaMur.rest;

public class Post {

    private String summary;
    private String mainPageText;
    private String textPost;
    private String image;

    public Post(String summary, String mainPageText, String textPost, String image) {
        this.summary = summary;
        this.mainPageText = mainPageText;
        this.textPost = textPost;
        this.image = image;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getMainPageText() {
        return mainPageText;
    }

    public void setMainPageText(String mainPageText) {
        this.mainPageText = mainPageText;
    }

    public String getTextPost() {
        return textPost;
    }

    public void setTextPost(String pagePost) {
        this.textPost = pagePost;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
