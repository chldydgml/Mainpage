package com.example.mainpage;

public class UserAccount {
    private String emailId;
    private String password;
    private String name;
    private String idToken; // 고유 토큰정보
    public UserAccount() {
        //데이터베이스 조회를 위한 빈 생성자를 만들어줘야한다.
    }
    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdToken() {
        return idToken;
    }

    public void setIdToken(String idToken) {
        this.idToken = idToken;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
