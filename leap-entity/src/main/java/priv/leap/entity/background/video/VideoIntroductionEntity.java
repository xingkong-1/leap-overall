package priv.leap.entity.background.video;


public class VideoIntroductionEntity {

  private long viId;
  private Long vId;                // 视频id
  private long viNumberVisitors;      // 视频访问次数
  private double viPostage;           // 资费
  private String viCharacteristic;    // 特色
  private Integer viAge;              // 年龄
  private Integer viSex;              // 性别
  private String viIntro;             // 视频简介
  private double viGrade;             // 豆瓣评分
  private String viCstCreate;
  private String viCstModified;

  public long getViId() {
    return viId;
  }

  public void setViId(long viId) {
    this.viId = viId;
  }

  public Long getvId() {
    return vId;
  }

  public void setvId(Long vId) {
    this.vId = vId;
  }

  public long getViNumberVisitors() {
    return viNumberVisitors;
  }

  public void setViNumberVisitors(long viNumberVisitors) {
    this.viNumberVisitors = viNumberVisitors;
  }

  public double getViPostage() {
    return viPostage;
  }

  public void setViPostage(double viPostage) {
    this.viPostage = viPostage;
  }

  public String getViCharacteristic() {
    return viCharacteristic;
  }

  public void setViCharacteristic(String viCharacteristic) {
    this.viCharacteristic = viCharacteristic;
  }

  public Integer getViAge() {
    return viAge;
  }

  public void setViAge(Integer viAge) {
    this.viAge = viAge;
  }

  public Integer getViSex() {
    return viSex;
  }

  public void setViSex(Integer viSex) {
    this.viSex = viSex;
  }

  public String getViIntro() {
    return viIntro;
  }

  public void setViIntro(String viIntro) {
    this.viIntro = viIntro;
  }

  public double getViGrade() {
    return viGrade;
  }

  public void setViGrade(double viGrade) {
    this.viGrade = viGrade;
  }

  public String getViCstCreate() {
    return viCstCreate;
  }

  public void setViCstCreate(String viCstCreate) {
    this.viCstCreate = viCstCreate;
  }

  public String getViCstModified() {
    return viCstModified;
  }

  public void setViCstModified(String viCstModified) {
    this.viCstModified = viCstModified;
  }

  @Override
  public String toString() {
    return "VideoIntroduction{" +
            "viId=" + viId +
            ", viNumberVisitors=" + viNumberVisitors +
            ", viPostage=" + viPostage +
            ", viCharacteristic='" + viCharacteristic + '\'' +
            ", viAge=" + viAge +
            ", viSex=" + viSex +
            ", viIntro='" + viIntro + '\'' +
            ", viGrade=" + viGrade +
            ", viCstCreate='" + viCstCreate + '\'' +
            ", viCstModified='" + viCstModified + '\'' +
            '}';
  }
}
