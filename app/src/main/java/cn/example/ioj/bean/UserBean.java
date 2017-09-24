package cn.example.ioj.bean;

/**
 * Created by L on 2017/9/24.
 */

public class UserBean {

    /**
     * username : 5120160446
     * maxim : boji9.cn
     * phone :
     * student_class : 计科1602
     * institution : CS
     * qq :
     * school : swust
     * student_id : 5120160446
     * real_name : 劳博基
     * is_inner : false
     * email : laobo3515@gmail.com
     */


    private String password;
    private String username;
    private String maxim;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean is_inner() {
        return is_inner;
    }

    private String phone;
    private String student_class;
    private String institution;
    private String qq;
    private String school;
    private String student_id;
    private String real_name;
    private boolean is_inner;
    private String email;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMaxim() {
        return maxim;
    }

    public void setMaxim(String maxim) {
        this.maxim = maxim;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStudent_class() {
        return student_class;
    }

    public void setStudent_class(String student_class) {
        this.student_class = student_class;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getReal_name() {
        return real_name;
    }

    public void setReal_name(String real_name) {
        this.real_name = real_name;
    }

    public boolean isIs_inner() {
        return is_inner;
    }

    public void setIs_inner(boolean is_inner) {
        this.is_inner = is_inner;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
