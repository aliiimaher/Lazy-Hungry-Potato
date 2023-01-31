public class Restaurant {

    // ---------- Attributes ----------
    private String RestaurantName;
    private int RestaurantDistance;

    // ---------- Constructor ----------
    public Restaurant(String restaurantName, int restaurantDistance) {
        this.RestaurantName = restaurantName;
        this.RestaurantDistance = restaurantDistance;
    }

    // ---------- Getters Setters ----------
    public String getRestaurantName() {
        return RestaurantName;
    }
    public void setRestaurantName(String restaurantName) {
        this.RestaurantName = restaurantName;
    }

    public int getRestaurantDistance() {
        return RestaurantDistance;
    }
    public void setRestaurantDistance(int restaurantDistance) {
        this.RestaurantDistance = restaurantDistance;
    }
}
