package arvoreAVL;

public class Sheet {
    private int value;
    private int height;
    private Sheet left;
    private Sheet right;

    public Sheet(int value) {
        this.value = value;
        this.height = 1;
    }

    public int getValue() {
        return value;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Sheet getLeft() {
        return left;
    }

    public void setLeft(Sheet left) {
        this.left = left;
    }

    public Sheet getRight() {
        return right;
    }

    public void setRight(Sheet right) {
        this.right = right;
    }
}
