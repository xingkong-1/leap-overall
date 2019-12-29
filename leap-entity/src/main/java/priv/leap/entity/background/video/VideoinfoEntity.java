package priv.leap.entity.background.video;

/**
 * @auther: kong
 * @date: 2019/12/12 8:47
 * 视频信息类
 */
public class VideoinfoEntity {

  private long vId;
  private String vName;         // 视频名称
  private String vType;         // 视频类型
  private String vVideoType;    // 视频种类
  private String vRegion;       // 地区
  private String vDefinition;   // 视频清晰度
  private String vLanguage;     // 语言
  private String vRemark;       // 视频备注
  private String vDateIssued;   // 视频上架时间
  private String vCstCreate;
  private String vCstModified;

  public long getvId() {
    return vId;
  }

  public void setvId(long vId) {
    this.vId = vId;
  }

  public String getvName() {
    return vName;
  }

  public void setvName(String vName) {
    this.vName = vName;
  }

  public String getvType() {
    return vType;
  }

  public void setvType(String vType) {
    this.vType = vType;
  }

  public String getvVideoType() {
    return vVideoType;
  }

  public void setvVideoType(String vVideoType) {
    this.vVideoType = vVideoType;
  }

  public String getvRegion() {
    return vRegion;
  }

  public void setvRegion(String vRegion) {
    this.vRegion = vRegion;
  }

  public String getvDefinition() {
    return vDefinition;
  }

  public void setvDefinition(String vDefinition) {
    this.vDefinition = vDefinition;
  }

  public String getvLanguage() {
    return vLanguage;
  }

  public void setvLanguage(String vLanguage) {
    this.vLanguage = vLanguage;
  }

  public String getvRemark() {
    return vRemark;
  }

  public void setvRemark(String vRemark) {
    this.vRemark = vRemark;
  }

  public String getvDateIssued() {
    return vDateIssued;
  }

  public void setvDateIssued(String vDateIssued) {
    this.vDateIssued = vDateIssued;
  }

  public String getvCstCreate() {
    return vCstCreate;
  }

  public void setvCstCreate(String vCstCreate) {
    this.vCstCreate = vCstCreate;
  }

  public String getvCstModified() {
    return vCstModified;
  }

  public void setvCstModified(String vCstModified) {
    this.vCstModified = vCstModified;
  }

  @Override
  public String toString() {
    return "Videoinfo{" +
            "vId=" + vId +
            ", vName='" + vName + '\'' +
            ", vType='" + vType + '\'' +
            ", vVideoType='" + vVideoType + '\'' +
            ", vRegion='" + vRegion + '\'' +
            ", vDefinition='" + vDefinition + '\'' +
            ", vLanguage='" + vLanguage + '\'' +
            ", vRemark='" + vRemark + '\'' +
            ", vDateIssued='" + vDateIssued + '\'' +
            ", vCstCreate='" + vCstCreate + '\'' +
            ", vCstModified='" + vCstModified + '\'' +
            '}';
  }
}
