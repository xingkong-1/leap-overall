package priv.leap.entity.background.video;

/**
 * @auther: kong
 * @date: 2019/12/12 8:52
 * 视频类型类
 */
public class VideoTypeEntity {

  private long tId;
  private String tType;
  private String tCstCreate;
  private String tCstModified;

  public long gettId() {
    return tId;
  }

  public void settId(long tId) {
    this.tId = tId;
  }

  public String gettType() {
    return tType;
  }

  public void settType(String tType) {
    this.tType = tType;
  }

  public String gettCstCreate() {
    return tCstCreate;
  }

  public void settCstCreate(String tCstCreate) {
    this.tCstCreate = tCstCreate;
  }

  public String gettCstModified() {
    return tCstModified;
  }

  public void settCstModified(String tCstModified) {
    this.tCstModified = tCstModified;
  }

  @Override
  public String toString() {
    return "VideoType{" +
            "tId=" + tId +
            ", tType='" + tType + '\'' +
            ", tCstCreate='" + tCstCreate + '\'' +
            ", tCstModified='" + tCstModified + '\'' +
            '}';
  }

}
