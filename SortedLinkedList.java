public class SortedLinkedList {
    private NodeType head;
    private NodeType currentPos;
    public SortedLinkedList() {
        head = null;
        currentPos = null;
    }
    public int getLength() {
        int counter = 0;
        currentPos = head;
        while(currentPos != null) {
            currentPos = currentPos.next;
            counter++;
        }
        return counter;
    }
    public void insertItem(ItemType item) {
        currentPos = head;
        NodeType n = new NodeType();
        boolean reachEnd = true;
        Nodetype temp;
        if(head == null) { //empty list                                                                                                                                                                
            temp = new NodeType(item);
            head = temp;
            return;
        }
        NodeType prev;
        while(currentPos != null) {
            if(item.compareTo(currentPos.info) < 0) {
                if(head == currentPos) {
                    head = new NodeType(item, currentPos);
                }
                else {
                    temp  = new NodeType(item, currentPos);
                    prev.next = temp;
                    reachEnd = false;
                    break;
                }
            }
            else if(item.compareTo(currentPos.next.info) == 0) {
                System.out.println("Sorry. You cannot insert the duplicate item");
                break;
            }
            prev = currentPos;
            currentPos = currentPos.next;
        }
        if(reachEnd) {
            temp = new NodeType(item);
            currentPos.next = temp;
        }
    }
    public void deleteItem(ItemType item) {

    }
    public int searchItem(ItemType item) {
        return -1;
    }
    public ItemType getNextItem() {
        return null;
    }
    public void resetList() {

    }
    public String toString() {
        currentPos = head;
        String ret = "";
        while(currentPos != null) {
            ret += currentPos.info.getValue() + " ";
        }
        return ret;
    }

}
