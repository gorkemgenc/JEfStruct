package structure;

public interface Func<T> {
    void call(QuadTree<T> quadTree, Node<T> node);
}
