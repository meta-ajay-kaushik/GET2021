package JDBC;
public class TopCategoryDetail {
    private String categoryName;
    private int numberOfChildren;
    public String getName() {
        return categoryName;
    }
    public void setName(String categoryName) {
        this.categoryName = categoryName;
    }
    public int getNumberOfChildren() {
        return numberOfChildren;
    }
    public void setNumberOfChildren(int numberOfChildren) {
        this.numberOfChildren = numberOfChildren;
    }
}