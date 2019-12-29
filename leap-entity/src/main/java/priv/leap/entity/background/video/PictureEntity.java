package priv.leap.entity.background.video;


import org.springframework.format.annotation.DateTimeFormat;

/**
 * @auther: kong
 * @date: 2019/12/12 8:47
 * 图片存储类
 */
public class PictureEntity {

  private long pId;
  private long vId;
  private String pName;
  private String pPath;
  private String pSize;
  private String pStorageTime;
  private String pCstCreate;
  @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
  private String pCstModified;

  public long getpId() {
    return pId;
  }

  public void setpId(long pId) {
    this.pId = pId;
  }

  public long getvId() {
    return vId;
  }

  public void setvId(long vId) {
    this.vId = vId;
  }

  public String getpName() {
    return pName;
  }

  public void setpName(String pName) {
    this.pName = pName;
  }

  public String getpPath() {
    return pPath;
  }

  public void setpPath(String pPath) {
    this.pPath = pPath;
  }

  public String getpSize() {
    return pSize;
  }

  public void setpSize(String pSize) {
    this.pSize = pSize;
  }

  public String getpStorageTime() {
    return pStorageTime;
  }

  public void setpStorageTime(String pStorageTime) {
    this.pStorageTime = pStorageTime;
  }

  public String getpCstCreate() {
    return pCstCreate;
  }

  public void setpCstCreate(String pCstCreate) {
    this.pCstCreate = pCstCreate;
  }

  public String getpCstModified() {
    return pCstModified;
  }

  public void setpCstModified(String pCstModified) {
    this.pCstModified = pCstModified;
  }

  @Override
  public String toString() {
    return "PictureEntity{" +
            "pId=" + pId +
            ", vId=" + vId +
            ", pName='" + pName + '\'' +
            ", pPath='" + pPath + '\'' +
            ", pSize='" + pSize + '\'' +
            ", pStorageTime='" + pStorageTime + '\'' +
            ", pCstCreate='" + pCstCreate + '\'' +
            ", pCstModified='" + pCstModified + '\'' +
            '}';
  }
}
