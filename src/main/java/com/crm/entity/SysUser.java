package com.crm.entity;


import java.util.List;

public class SysUser {
    private Long userId;

    private String userName;

    private String userAccounts;

    private String userPassword;

    private Integer userStatus;

    private String userDepartment;

    private String userPosition;

    private String userEmail;

    private String userPhone;

    private String userWorkphone;


    private List<CstCustomer> customerList;//附加对象客户List

    private List<UserTask> taskList;//附加对象任务List

    public List<UserTask> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<UserTask> taskList) {
        this.taskList = taskList;
    }

    public List<CstCustomer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<CstCustomer> customerList) {
        this.customerList = customerList;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAccounts() {
        return userAccounts;
    }

    public void setUserAccounts(String userAccounts) {
        this.userAccounts = userAccounts;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    public String getUserDepartment() {
        return userDepartment;
    }

    public void setUserDepartment(String userDepartment) {
        this.userDepartment = userDepartment;
    }

    public String getUserPosition() {
        return userPosition;
    }

    public void setUserPosition(String userPosition) {
        this.userPosition = userPosition;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserWorkphone() {
        return userWorkphone;
    }

    public void setUserWorkphone(String userWorkphone) {
        this.userWorkphone = userWorkphone;
    }


}