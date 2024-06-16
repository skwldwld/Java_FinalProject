public class UserPreference {
    private String userName;
    private String preferredCategory;
    private int preferredPrice;
    private double preferredRating;

    public UserPreference(String userName, String preferredCategory, int preferredPrice, double preferredRating) {
        this.userName = userName;
        this.preferredCategory = preferredCategory;
        this.preferredPrice = preferredPrice;
        this.preferredRating = preferredRating;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPreferredCategory() {
        return preferredCategory;
    }

    public void setPreferredCategory(String preferredCategory) {
        this.preferredCategory = preferredCategory;
    }

    public int getPreferredPrice() {
        return preferredPrice;
    }

    public void setPreferredPrice(int preferredPrice) {
        this.preferredPrice = preferredPrice;
    }

    public double getPreferredRating() {
        return preferredRating;
    }

    public void setPreferredRating(double preferredRating) {
        this.preferredRating = preferredRating;
    }
}
