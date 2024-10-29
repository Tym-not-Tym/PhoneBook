public class ListNode{
    private String name;
    private String address;
    private String city;
    private String phoneNum;

    public listNode(String name, String address, String city, String phoneNum) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.phoneNum = phoneNum;
    }

    public viod setName(String name) {
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