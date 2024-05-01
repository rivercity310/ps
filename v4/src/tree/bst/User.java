package tree.bst;

public class User extends KeyComparable<User> {
    private final int weight;
    private final String name;
    private final String email;

    public User(int key, int weight, String name, String email) {
        this.key = key;
        this.name = name;
        this.email = email;
        this.weight = weight;
    }

    @Override
    public int compareTo(User that) {
        return this.key - that.key;
    }

    @Override
    public String toString() {
        return "[" + "(" + this.key + ")" + this.name + " " + this.email + " " + this.weight + "]";
    }
}
