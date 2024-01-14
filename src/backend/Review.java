package backend;

public class Review {
    private int rating;
    private String text;
    private String authorName;
    private boolean isVerified;
    private int index;

    public Review(int rating, String text, String authorName) {
        this.rating = rating;
        this.text = text;
        this.authorName = authorName;
        isVerified = false;
    }

    public Review() {
        isVerified = false;
    }

    public void verify(Boolean isVerified) {
        this.isVerified = isVerified;
    }

    public int getRating() {
        return rating;
    }

    public String getText() {
        return text;
    }

    public String getAuthorName() {
        return authorName;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int i) {
        index = i;
    }

    public void setRating(Integer value) {
        rating = value;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
}
