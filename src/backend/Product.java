package backend;

import java.util.ArrayList;
import java.util.List;

public class Product {
    private String name;
    private String category;
    private String shortDescription;
    private int rating;
    private int price;
    private String specifications;
    private String description;

    private List<Review> reviewList = new ArrayList<>();

    public Product(String name, String category, String shortDescription, int price, String specifications, String description) {
        this.name = name;
        this.category = category;
        this.shortDescription = shortDescription;
        this.rating = 0;
        this.price = price;
        this.specifications = specifications;
        this.description = description;
    }

    public Product(String name, String category, int price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public void addReview(Review newReview) {
        reviewList.add(newReview);
        newReview.setIndex(reviewList.size()-1);

        rating = 0;
        for (Review review: reviewList) {
            rating += review.getRating();
        }

        rating /= reviewList.size();
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public int getRating() {
        return rating;
    }

    public int getPrice() {
        return price;
    }

    public String getSpecifications() {
        return specifications;
    }

    public String getDescription() {
        return description;
    }

    public List<Review> getReviewList() {
        return reviewList;
    }
}
