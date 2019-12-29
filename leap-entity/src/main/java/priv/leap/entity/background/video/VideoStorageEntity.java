package priv.leap.entity.background.video;


/**
 * @auther: kong
 * @date: 2019/12/12 8:49
 * 视频存储类
 */
public class VideoStorageEntity {

  private long sId;
  private long vId;
  private String sSize;
  private String sPath;
  private String sStorageTime;
  private String sCstCreate;
  private String sCstModified;

  public long getsId() {
    return sId;
  }

  public void setsId(long sId) {
    this.sId = sId;
  }

  public long getvId() {
    return vId;
  }

  public void setvId(long vId) {
    this.vId = vId;
  }

  public String getsSize() {
    return sSize;
  }

  public void setsSize(String sSize) {
    this.sSize = sSize;
  }

  public String getsPath() {
    return sPath;
  }

  public void setsPath(String sPath) {
    this.sPath = sPath;
  }

  public String getsStorageTime() {
    return sStorageTime;
  }

  public void setsStorageTime(String sStorageTime) {
    this.sStorageTime = sStorageTime;
  }

  public String getsCstCreate() {
    return sCstCreate;
  }

  public void setsCstCreate(String sCstCreate) {
    this.sCstCreate = sCstCreate;
  }

  public String getsCstModified() {
    return sCstModified;
  }

  public void setsCstModified(String sCstModified) {
    this.sCstModified = sCstModified;
  }

  @Override
  public String toString() {
    return "VideoStorage{" +
            "sId=" + sId +
            ", vId=" + vId +
            ", sSize='" + sSize + '\'' +
            ", sPath='" + sPath + '\'' +
            ", sStorageTime='" + sStorageTime + '\'' +
            ", sCstCreate='" + sCstCreate + '\'' +
            ", sCstModified='" + sCstModified + '\'' +
            '}';
  }
}
