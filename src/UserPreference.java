public class UserPreference {
    private int userId;
    private String preferredCategory;
    private double preferredPrice;
    private double preferredRating;

    public UserPreference(int userId, String preferredCategory, double preferredPrice, double preferredRating) {
        this.userId = userId;
        this.preferredCategory = preferredCategory;
        this.preferredPrice = preferredPrice;
        this.preferredRating = preferredRating;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPreferredCategory() {
        return preferredCategory;
    }

    public void setPreferredCategory(String preferredCategory) {
        this.preferredCategory = preferredCategory;
    }

    public double getPreferredPrice() {
        return preferredPrice;
    }

    public void setPreferredPrice(double preferredPrice) {
        this.preferredPrice = preferredPrice;
    }

    public double getPreferredRating() {
        return preferredRating;
    }

    public void setPreferredRating(double preferredRating) {
        this.preferredRating = preferredRating;
    }
}
