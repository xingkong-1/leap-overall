package priv.leap.entity.user;

/**
 * @Auther: kong
 * @Date: 2019/12/5 20:14
 * @Description:
 */
public class VideoNavigationVO {
    private long vId;
    private String vName;         // 视频名称
    private String vVideoType;    // 视频种类
    private String vType;         // 视频类型
    private String vRegion;       // 地区
    private String vDefinition;   // 视频清晰度
    private String vRemark;       // 视频备注
    private String viIntro;       // 视频简介
    private Integer viAge;        // 年龄
    private Integer viSex;        // 性别
    private String viGrade;       // 豆瓣评分
    private long pId;
    private String pName;         // 图片名
    private String pPath;         // 图片路径
    private long sId;
    private String sSize;         // 视频大小
    private String sPath;         // 视频路径
    private String vDateIssued;   // 视频上架时间


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

    public String getvType() {
        return vType;
    }

    public void setvType(String vType) {
        this.vType = vType;
    }

    public String getvDefinition() {
        return vDefinition;
    }

    public void setvDefinition(String vDefinition) {
        this.vDefinition = vDefinition;
    }

    public String getvRemark() {
        return vRemark;
    }

    public void setvRemark(String vRemark) {
        this.vRemark = vRemark;
    }

    public String getViIntro() {
        return viIntro;
    }

    public void setViIntro(String viIntro) {
        this.viIntro = viIntro;
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

    public String getViGrade() {
        return viGrade;
    }

    public void setViGrade(String viGrade) {
        this.viGrade = viGrade;
    }

    public long getpId() {
        return pId;
    }

    public void setpId(long pId) {
        this.pId = pId;
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

    public long getsId() {
        return sId;
    }

    public void setsId(long sId) {
        this.sId = sId;
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

    public String getvDateIssued() {
        return vDateIssued;
    }

    public void setvDateIssued(String vDateIssued) {
        this.vDateIssued = vDateIssued;
    }

    @Override
    public String toString() {
        return "VideoNavigationVO{" +
                "vId=" + vId +
                ", vName='" + vName + '\'' +
                ", vVideoType='" + vVideoType + '\'' +
                ", vType='" + vType + '\'' +
                ", vRegion='" + vRegion + '\'' +
                ", vDefinition='" + vDefinition + '\'' +
                ", vRemark='" + vRemark + '\'' +
                ", viIntro='" + viIntro + '\'' +
                ", viAge=" + viAge +
                ", viSex=" + viSex +
                ", viGrade='" + viGrade + '\'' +
                ", pId=" + pId +
                ", pName='" + pName + '\'' +
                ", pPath='" + pPath + '\'' +
                ", sId=" + sId +
                ", sSize='" + sSize + '\'' +
                ", sPath='" + sPath + '\'' +
                ", vDateIssued='" + vDateIssued + '\'' +
                '}';
    }
}

