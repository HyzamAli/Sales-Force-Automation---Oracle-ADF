package view;

public class UsersBean {
    private String fname;
    private String mname;
    private String lname;
    private String password;
    private String start_date;
    private String end_date;
    private String supervisor;

    public UsersBean() {
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getFname() {
        return fname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getMname() {
        return mname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getLname() {
        return lname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public String getSupervisor() {
        return supervisor;
    }
}
