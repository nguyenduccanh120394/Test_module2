public class DanhBa {
    private final String GENDER_1 ="Male";
    private final String GENDER_2 ="FeMale";
    private final String GROUP_1 ="Family";
    private final String GROUP_2 ="Company";
    private final String GROUP_3 ="Friend";

    private String phoneNumber;
    private String group;
    private String name;
    private String gender;
    private String address;
    private String dateOfBirth;
    private String email;

    public DanhBa(String phoneNumber, String group, String name, String gender, String address, String dateOfBirth, String email) {
        this.phoneNumber = phoneNumber;
        this.group = group;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        if (group.equals("1")){
            this.group=GROUP_1;
        }else if (group.equals("2")){
            this.group=GROUP_2;
        }else if ((group.equals("3"))){
            this.group=GROUP_3;
        }
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        if (gender.equals("1")){
            this.gender=GENDER_1;
        }else if (gender.equals("2")){
            this.gender=GENDER_2;
        }
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "DanhBa{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", group='" + getGroup() + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + getGender() + '\'' +
                ", address='" + address + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
