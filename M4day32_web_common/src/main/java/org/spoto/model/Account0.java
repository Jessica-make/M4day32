package org.spoto.model;

import java.util.Date;

public class Account0 {
    private Integer id;

    private String username;

    private String passwd;

    private String role;
    //是否可用
    private String status;

    //注册时间
    private  Date date0;

    public Account0() {
    }

    public Account0(Integer id, String username, String passwd, String role, String status, Date date0) {
        this.id = id;
        this.username = username;
        this.passwd = passwd;
        this.role = role;
        this.status = status;
        this.date0 = date0;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDate0() {
        return date0;
    }

    public void setDate0(Date date0) {
        this.date0 = date0;
    }

    @Override
    public String toString() {
        return "Account0{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", passwd='" + passwd + '\'' +
                ", role='" + role + '\'' +
                ", status='" + status + '\'' +
                ", date0=" + date0 +
                '}';
    }
}
