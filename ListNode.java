public class ListNode{
    public String name;
    public String address;
    public String city;
    public String phoneNum;
    public ListNode next;

    public ListNode() {
        next = null;
    }

    public ListNode(ListNode next, String name, String address, String city, String phoneNum) {
        this.next = next;
        this.name = name;
        this.city = city;
        this.address = address;
        this.phoneNum = phoneNum;
    }

    public ListNode(String name, String address, String city, String phoneNum) {
        this.name = name;
        this.city = city;
        this.address = address;
        this.phoneNum = phoneNum;
        next = null;
    } 
}