package priv.leap.entity.background.user;

import org.springframework.format.annotation.DateTimeFormat;

public class UserinfoEntity {

  private long uId;
  private String uName;
  private String uPassword;
  private long uAge;
  private long uSex;
  private String uPhone;
  private String interest;
  private String uIntroduce;
  private long isMember;
  @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
  private String uRegistrationTime;
//  @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
  private String uLoginTime;
  @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
  private String aCstCreate;
  @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
  private String aModified;

  public long getuId() {
    return uId;
  }

  public void setuId(long uId) {
    this.uId = uId;
  }

  public String getuName() {
    return uName;
  }

  public void setuName(String uName) {
    this.uName = uName;
  }

  public String getuPassword() {
    return uPassword;
  }

  public void setuPassword(String uPassword) {
    this.uPassword = uPassword;
  }

  public long getuAge() {
    return uAge;
  }

  public void setuAge(long uAge) {
    this.uAge = uAge;
  }

  public long getuSex() {
    return uSex;
  }

  public void setuSex(long uSex) {
    this.uSex = uSex;
  }

  public String getuPhone() {
    return uPhone;
  }

  public void setuPhone(String uPhone) {
    this.uPhone = uPhone;
  }

  public String getInterest() {
    return interest;
  }

  public void setInterest(String interest) {
    this.interest = interest;
  }

  public String getuIntroduce() {
    return uIntroduce;
  }

  public void setuIntroduce(String uIntroduce) {
    this.uIntroduce = uIntroduce;
  }

  public long getIsMember() {
    return isMember;
  }

  public void setIsMember(long isMember) {
    this.isMember = isMember;
  }

  public String getuRegistrationTime() {
    return uRegistrationTime;
  }

  public void setuRegistrationTime(String uRegistrationTime) {
    this.uRegistrationTime = uRegistrationTime;
  }

  public String getuLoginTime() {
    return uLoginTime;
  }

  public void setuLoginTime(String uLoginTime) {
    this.uLoginTime = uLoginTime;
  }

  public String getaCstCreate() {
    return aCstCreate;
  }

  public void setaCstCreate(String aCstCreate) {
    this.aCstCreate = aCstCreate;
  }

  public String getaModified() {
    return aModified;
  }

  public void setaModified(String aModified) {
    this.aModified = aModified;
  }

  @Override
  public String toString() {
    return "Userinfo{" +
            "uId=" + uId +
            ", uName='" + uName + '\'' +
            ", uPassword='" + uPassword + '\'' +
            ", uAge=" + uAge +
            ", uSex=" + uSex +
            ", uPhone='" + uPhone + '\'' +
            ", interest='" + interest + '\'' +
            ", uIntroduce='" + uIntroduce + '\'' +
            ", isMember=" + isMember +
            ", uRegistrationTime=" + uRegistrationTime +
            ", uLoginTime=" + uLoginTime +
            ", aCstCreate=" + aCstCreate +
            ", aModified=" + aModified +
            '}';
  }
}
