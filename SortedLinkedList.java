package Project1;
import Project1.ItemType;
import Project1.NodeType;
public class SortedLinkedList {
    private NodeType head;
    private NodeType currentPos;
    public SortedLinkedList() {
        head = new NodeType();
        currentPos = head.next;
    }
    public int getLength() {
        int counter = 0;
        NodeType temp = head;
        while(temp.next != null) {
            temp = temp.next;
            counter++;
        }
        return counter;
    }
    public void insertItem(ItemType item) {
        NodeType insertionNode = new NodeType(item);
        if(head.next == null) { //empty list                                                                                                                                                                                                  

            head.next = insertionNode;
            return;
        }

        currentPos = head;

        while(currentPos.next != null) {
            if(currentPos.next.info.compareTo(item) == 0){
                System.out.println("Sorry. You cannot insert the duplicate item");
                return;
            }
            else if (currentPos.next.info.compareTo(item) == 1){
                insertionNode.next = currentPos.next;
                currentPos.next = insertionNode;
                return;
            }
            currentPos = currentPos.next;
        }
        if(currentPos.info.compareTo(item) == -1){
            currentPos.next = insertionNode;
        }
        currentPos = head;
    }
    public void deleteItem(ItemType item) {
        if(head.next == null){
            System.out.println("the list is empty.");
        }
        NodeType iter = head;
        while(iter.next != null){
            if (iter.next.info.compareTo(item) == 0){
                if(iter.next.next == null){
                    iter.next = null;
                    return;
                }
                else{
                    iter.next = iter.next.next;
                    return;
                }
            }
            iter = iter.next;
        }
        System.out.println("Item not found.");
        
    }
    public int searchItem(ItemType item) {
        NodeType iter = head;
        int index = 0;
        while(iter.next != null){
            if(iter.next.info.compareTo(item)==0){
                return index+1;
            }
            index ++;
            iter = iter.next;
        }
        System.out.println("Item not found");
        return -1;
    }
    public ItemType getNextItem() {

        if (head.next == null){
            System.out.println("List is empty");
            return null;
        }
        else if(currentPos.next == null){
            currentPos = head.next;
            return currentPos.info;
        }
        currentPos = currentPos.next;
        return currentPos.info;
    }
    public void resetList() {
        currentPos = head.next;
    }

    @Override
    public String toString(){
	    String ret = "[ ";
        NodeType iter = head.next;
        while (iter != null){
            ret += iter.info.getValue() + " ";
            iter = iter.next;
        }
        return ret + "]";
    }

    public void mergeList(SortedLinkedList otherList){
        otherList.resetList();
        NodeType otheriter = otherList.head;
        while(otheriter.next != null){
            mergeHelperInsert(new ItemType(otheriter.next.info.getValue()));
            otheriter = otheriter.next;
        }


    }

    private void mergeHelperInsert(ItemType item){
        NodeType insertionNode = new NodeType(item);
        if(head.next == null) { //empty list                                                                                                                                                                                                  

            head.next = insertionNode;
            return;
        }

        currentPos = head;

        while(currentPos.next != null) {
            if(currentPos.next.info.compareTo(item) == 0){
                return;
            }
            else if (currentPos.next.info.compareTo(item) == 1){
                insertionNode.next = currentPos.next;
                currentPos.next = insertionNode;
                return;
            }
            currentPos = currentPos.next;
        }
        if(currentPos.info.compareTo(item) == -1){
            currentPos.next = insertionNode;
        }
    }

    public void DeleteAlternate(){
        NodeType iter = head;

        int count = 0;

        while(iter.next != null){
            if (count%2!=0){
                deleteItem(new ItemType(iter.next.info.getValue()));
            }
            else{
                iter = iter.next;
            }
            count++;

        }
    }

    public void intersection(SortedLinkedList other){
        String list = "[ ";

        NodeType iter = head;


        while(iter.next != null){
            if(intersectionHelper(other,iter.next.info) == 0){
                list += iter.next.info.getValue() + " ";
            }
            iter = iter.next;
        }
        System.out.println(list + "]");
    }
    private int intersectionHelper(SortedLinkedList other, ItemType item){
        NodeType iter = other.head;
        while(iter.next != null){
            if(iter.next.info.compareTo(item)==0){
                return 0;
            }
            iter = iter.next;
        }
        return -1;
    }

}

