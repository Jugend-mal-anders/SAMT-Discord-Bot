package model;

public class Triple<L, M, R> {

    private final L left;
    private final M middle;
    private final R right;

    public Triple(L left, M middle, R right) {
        assert left != null;
        assert right != null;
        assert middle != null;

        this.left = left;
        this.right = right;
        this.middle = middle;
    }

    public L getLeft() {
        return left;
    }

    public M getMiddle() {
        return middle;
    }

    public R getRight() {
        return right;
    }

    @Override
    public int hashCode() {
        return left.hashCode() ^ middle.hashCode() ^ right.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Triple)) return false;
        Triple tripleo = (Triple) o;
        return this.left.equals(tripleo.getLeft()) &&
                this.middle.equals(tripleo.getMiddle()) &&
                this.right.equals(tripleo.getRight());
    }

}
