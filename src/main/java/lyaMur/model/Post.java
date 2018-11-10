package lyaMur.model;

public class Post {

    private String id;
    private String summary;
    private String mainPageText;
    private String textPost;
    private String image;

    public Post() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "id = " + id +
                "summary = " + summary +
                ", mainPageText = " + mainPageText +
                ", textPost = " + textPost +
                ", image = " + image;
    }
}
