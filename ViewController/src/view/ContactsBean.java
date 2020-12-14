package view;

public class ContactsBean {
    private String name;
    private String phone;
    private String email;
    private String isPrimary;
    private String influenceLevel;

    public ContactsBean() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setIsPrimary(String isPrimary) {
        this.isPrimary = isPrimary;
    }

    public String getIsPrimary() {
        return isPrimary;
    }

    public void setInfluenceLevel(String influenceLevel) {
        this.influenceLevel = influenceLevel;
    }

    public String getInfluenceLevel() {
        return influenceLevel;
    }
}
