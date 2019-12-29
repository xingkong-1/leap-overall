package priv.leap.entity.background.user;


public class UserMessage {

  private long umId;
  private long uId;
  private String umContent;
  private String umReleaseTime;
  private String umCstCreate;
  private String umModified;

  public long getUmId() {
    return umId;
  }

  public void setUmId(long umId) {
    this.umId = umId;
  }

  public long getuId() {
    return uId;
  }

  public void setuId(long uId) {
    this.uId = uId;
  }

  public String getUmContent() {
    return umContent;
  }

  public void setUmContent(String umContent) {
    this.umContent = umContent;
  }

  public String getUmReleaseTime() {
    return umReleaseTime;
  }

  public void setUmReleaseTime(String umReleaseTime) {
    this.umReleaseTime = umReleaseTime;
  }

  public String getUmCstCreate() {
    return umCstCreate;
  }

  public void setUmCstCreate(String umCstCreate) {
    this.umCstCreate = umCstCreate;
  }

  public String getUmModified() {
    return umModified;
  }

  public void setUmModified(String umModified) {
    this.umModified = umModified;
  }

  @Override
  public String toString() {
    return "UserMessage{" +
            "umId=" + umId +
            ", uId=" + uId +
            ", umContent='" + umContent + '\'' +
            ", umReleaseTime='" + umReleaseTime + '\'' +
            ", umCstCreate='" + umCstCreate + '\'' +
            ", umModified='" + umModified + '\'' +
            '}';
  }
}
