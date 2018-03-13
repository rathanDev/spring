package jana.model;

public class Hello {
    private String h;

    public String getH() {
        return h;
    }

    public void setH(String h) {
        this.h = h;
    }

    @Override
    public String toString() {
        return "Hello{" +
                "h='" + h + '\'' +
                '}';
    }
}
