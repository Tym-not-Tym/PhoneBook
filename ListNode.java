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

    public void setName(String name) {
        this.name = name;
    }    

    public viod setAddress(String address) {
        this.address = address;
    }    

    public viod setCity(String city) {
        this.city = city;
    }    

    public viod setPhone(String phoneNum) {
        this.phoneNum = phoneNum;
    }    

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getPhone() {
        return phoneNum;
    }    
}