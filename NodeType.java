package Project1;

public class NodeType {
    public ItemType info;
    public NodeType next;
    public NodeType() {
        info = null;
        next = null;
    }
    public NodeType(ItemType i) {
        info = i;
    }
    public NodeType(ItemType i, NodeType n) {
        info = i;
        next = n;
    }
}
