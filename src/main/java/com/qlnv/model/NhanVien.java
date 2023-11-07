package com.qlnv.model;

import java.util.Date;

public class NhanVien {
    private int EmployeeID;
    private String FullName;
    private Date DateOfBirth;
    private String Gender;
    private String Avatar;
    private String IDCardNumber;
    private String EducationalBackground;
    private String LanguageSkills;
    private String PermanentResidence;
    private String Address;
    private String Ethnicity;
    private String Religion;
    private Date DateJoinYouthUnion;
    private Date DateJoinParty;
    private String Parents;
    private String Siblings;
    private String MaritalStatus;
    private String Children;
    private String PolicyCategory;
    private String Department;
    private String JobTitle;
    private boolean isCheckIn;
    private boolean StatusStaff = true;

    public NhanVien() {
    }

    public NhanVien(int employeeID, String fullName, Date dateOfBirth, String gender, String IDCardNumber, String educationalBackground, String languageSkills, String permanentResidence, String address, String ethnicity, String religion, Date dateJoinYouthUnion, Date dateJoinParty, String parents, String siblings, String maritalStatus, String children, String policyCategory, String department, String jobTitle, String avatar) {
        EmployeeID = employeeID;
        FullName = fullName;
        DateOfBirth = dateOfBirth;
        Gender = gender;
        this.IDCardNumber = IDCardNumber;
        EducationalBackground = educationalBackground;
        LanguageSkills = languageSkills;
        PermanentResidence = permanentResidence;
        Address = address;
        Ethnicity = ethnicity;
        Religion = religion;
        DateJoinYouthUnion = dateJoinYouthUnion;
        DateJoinParty = dateJoinParty;
        Parents = parents;
        Siblings = siblings;
        MaritalStatus = maritalStatus;
        Children = children;
        PolicyCategory = policyCategory;
        Department = department;
        JobTitle = jobTitle;
        Avatar = avatar;
    }
    public NhanVien(String fullName, Date dateOfBirth, String gender, String avatar, String idCardNumber,
                    String educationalBackground, String languageSkills, String permanentResidence, String address,
                    String ethnicity, String religion, Date dateJoinYouthUnion, Date dateJoinParty,
                    String parents, String siblings, String maritalStatus, String children, String policyCategory,
                    String department, String jobTitle, boolean isCheckIn) {
        FullName = fullName;
        DateOfBirth = dateOfBirth;
        Gender = gender;
        Avatar = avatar;
        IDCardNumber = idCardNumber;
        EducationalBackground = educationalBackground;
        LanguageSkills = languageSkills;
        PermanentResidence = permanentResidence;
        Address = address;
        Ethnicity = ethnicity;
        Religion = religion;
        DateJoinYouthUnion = dateJoinYouthUnion;
        DateJoinParty = dateJoinParty;
        Parents = parents;
        Siblings = siblings;
        MaritalStatus = maritalStatus;
        Children = children;
        PolicyCategory = policyCategory;
        Department = department;
        JobTitle = jobTitle;
        this.isCheckIn = isCheckIn;
    }
    public boolean isCheckIn() {
        return isCheckIn;
    }

    public boolean isStatusStaff() {
        return StatusStaff;
    }

    public void setStatusStaff(boolean statusStaff) {
        StatusStaff = statusStaff;
    }

    public void setCheckIn(boolean checkIn) {
        isCheckIn = checkIn;
    }

    public String getAvatar() {
        return Avatar;
    }

    public void setAvatar(String avatar) {
        Avatar = avatar;
    }

    public int getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(int employeeID) {
        EmployeeID = employeeID;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public Date getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getIDCardNumber() {
        return IDCardNumber;
    }

    public void setIDCardNumber(String IDCardNumber) {
        this.IDCardNumber = IDCardNumber;
    }

    public String getEducationalBackground() {
        return EducationalBackground;
    }

    public void setEducationalBackground(String educationalBackground) {
        EducationalBackground = educationalBackground;
    }

    public String getLanguageSkills() {
        return LanguageSkills;
    }

    public void setLanguageSkills(String languageSkills) {
        LanguageSkills = languageSkills;
    }

    public String getPermanentResidence() {
        return PermanentResidence;
    }

    public void setPermanentResidence(String permanentResidence) {
        PermanentResidence = permanentResidence;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getEthnicity() {
        return Ethnicity;
    }

    public void setEthnicity(String ethnicity) {
        Ethnicity = ethnicity;
    }

    public String getReligion() {
        return Religion;
    }

    public void setReligion(String religion) {
        Religion = religion;
    }

    public Date getDateJoinYouthUnion() {
        return DateJoinYouthUnion;
    }

    public void setDateJoinYouthUnion(Date dateJoinYouthUnion) {
        DateJoinYouthUnion = dateJoinYouthUnion;
    }

    public Date getDateJoinParty() {
        return DateJoinParty;
    }

    public void setDateJoinParty(Date dateJoinParty) {
        DateJoinParty = dateJoinParty;
    }

    public String getParents() {
        return Parents;
    }

    public void setParents(String parents) {
        Parents = parents;
    }

    public String getSiblings() {
        return Siblings;
    }

    public void setSiblings(String siblings) {
        Siblings = siblings;
    }

    public String getMaritalStatus() {
        return MaritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        MaritalStatus = maritalStatus;
    }

    public String getChildren() {
        return Children;
    }

    public void setChildren(String children) {
        Children = children;
    }

    public String getPolicyCategory() {
        return PolicyCategory;
    }

    public void setPolicyCategory(String policyCategory) {
        PolicyCategory = policyCategory;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }

    public String getJobTitle() {
        return JobTitle;
    }

    public void setJobTitle(String jobTitle) {
        JobTitle = jobTitle;
    }
}

