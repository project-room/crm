package com.crm.entity;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;

import javax.management.MXBean;
import javax.persistence.Entity;
import java.util.List;

public class SysUser {
    private Long userId;

    //角色id
    private Long roleId;

    private String userName;

    private String userAccounts;

    private String userPassword;

    private Integer userStatus;

    private String userDepartment;

    private String userPosition;

    private String userEmail;

    private String userPhone;

    private String userWorkphone;

    private Integer userState;

    private List<CstCustomer> customerList;

    private List<UserTask> taskList;

    private List<CstChance> chanceList;

    //多个用户对应一个角色
    private SysRole sysRole;

    public List<CstChance> getChanceList() {
        return chanceList;
    }

    public void setChanceList(List<CstChance> chanceList) {
        this.chanceList = chanceList;
    }

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
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserAccounts() {
        return userAccounts;
    }

    public void setUserAccounts(String userAccounts) {
        this.userAccounts = userAccounts == null ? null : userAccounts.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
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
        this.userDepartment = userDepartment == null ? null : userDepartment.trim();
    }

    public String getUserPosition() {
        return userPosition;
    }

    public void setUserPosition(String userPosition) {
        this.userPosition = userPosition == null ? null : userPosition.trim();
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    public String getUserWorkphone() {
        return userWorkphone;
    }

    public void setUserWorkphone(String userWorkphone) {
        this.userWorkphone = userWorkphone == null ? null : userWorkphone.trim();
    }

    public Integer getUserState() {
        return userState;
    }

    public void setUserState(Integer userState) {
        this.userState = userState;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public SysRole getSysRole() {
        return sysRole;
    }

    public void setSysRole(SysRole sysRole) {
        this.sysRole = sysRole;
    }
}