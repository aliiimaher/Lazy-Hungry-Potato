public class Query {

    // ========== Attributes ==========
    private int firstNQueries;
    private String prefix;


    // ========== Constructor ==========
    public Query(int firstNQueries, String prefix) {
        this.firstNQueries = firstNQueries;
        this.prefix = prefix;
    }


    // ========== Getters Setters ==========
    public int getFirstNQueries() {
        return firstNQueries;
    }

    public void setFirstNQueries(int firstNQueries) {
        this.firstNQueries = firstNQueries;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
}
