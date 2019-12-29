package priv.leap.entity.background.video;


/**
 * @auther: kong
 * @date: 2019/12/12 8:56
 * 演员类
 */

public class PerformerEntity {

  private long pId;
  private long vId;
  private String pDirector;
  private String pToStar;
  private String pCstCreate;
  private String pModified;

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

  public String getpDirector() {
    return pDirector;
  }

  public void setpDirector(String pDirector) {
    this.pDirector = pDirector;
  }

  public String getpToStar() {
    return pToStar;
  }

  public void setpToStar(String pToStar) {
    this.pToStar = pToStar;
  }

  public String getpCstCreate() {
    return pCstCreate;
  }

  public void setpCstCreate(String pCstCreate) {
    this.pCstCreate = pCstCreate;
  }

  public String getpModified() {
    return pModified;
  }

  public void setpModified(String pModified) {
    this.pModified = pModified;
  }

  @Override
  public String toString() {
    return "Performer{" +
            "pId=" + pId +
            ", vId=" + vId +
            ", pDirector='" + pDirector + '\'' +
            ", pToStar='" + pToStar + '\'' +
            ", pCstCreate='" + pCstCreate + '\'' +
            ", pModified='" + pModified + '\'' +
            '}';
  }
}

