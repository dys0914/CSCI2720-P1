package Project1;

public class ItemType {
    private int value;
    public ItemType() {
        value = 0;
    }
    public ItemType(int num) {
        value = num;
    }
    public int compareTo(ItemType item) {
        int ret = 0;
        if(item.getValue() > value) {
            ret = -1;
        }
        else if(item.getValue() <  value) {
            ret = 1;
        }
        return ret;
    }
    public int getValue() {
        return value;
    }
}
