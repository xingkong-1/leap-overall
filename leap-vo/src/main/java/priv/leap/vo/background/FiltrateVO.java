package priv.leap.vo.background;

/**
 * @Auther: kong
 * @Date: 2019/12/26 20:17
 * @Description:
 */
public class FiltrateVO {
    private String rank;
    private String type;
    private String region;
    private String date;
    private String expenses;

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getExpenses() {
        return expenses;
    }

    public void setExpenses(String expenses) {
        this.expenses = expenses;
    }

    @Override
    public String toString() {
        return "FiltrateVO{" +
                "rank='" + rank + '\'' +
                ", type='" + type + '\'' +
                ", region='" + region + '\'' +
                ", date='" + date + '\'' +
                ", expenses='" + expenses + '\'' +
                '}';
    }
}
