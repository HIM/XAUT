package medicines.domain.details;

public class inMore {
    private String purchase_id;
    private String factor_name;
    private String med_id;
    private int purchase_price;
    private int purchase_num;
    private String purchase_date;
    private String med_name;
    private int pur_sum;    //总金额


    public String getMed_name() {
        return med_name;
    }

    public void setMed_name(String med_name) {
        this.med_name = med_name;
    }

    public String getPurchase_id() {
        return purchase_id;
    }

    public void setPurchase_id(String purchase_id) {
        this.purchase_id = purchase_id;
    }

    public String getFactor_name() {
        return factor_name;
    }

    public void setFactor_name(String factor_name) {
        this.factor_name = factor_name;
    }

    public String getMed_id() {
        return med_id;
    }

    public void setMed_id(String med_id) {
        this.med_id = med_id;
    }

    public int getPurchase_price() {
        return purchase_price;
    }

    public void setPurchase_price(int purchase_price) {
        this.purchase_price = purchase_price;
    }

    public int getPurchase_num() {
        return purchase_num;
    }

    public void setPurchase_num(int purchase_num) {
        this.purchase_num = purchase_num;
    }

    public String getPurchase_date() {
        return purchase_date;
    }

    public void setPurchase_date(String purchase_date) {
        this.purchase_date = purchase_date;
    }

    public int getPur_sum() {
        return pur_sum;
    }

    public void setPur_sum(int pur_sum) {
        this.pur_sum = pur_sum;
    }

    @Override
    public String toString() {
        return "inMore{" +
                "purchase_id='" + purchase_id + '\'' +
                ", factor_name='" + factor_name + '\'' +
                ", med_id='" + med_id + '\'' +
                ", purchase_price=" + purchase_price +
                ", purchase_num=" + purchase_num +
                ", purchase_date='" + purchase_date + '\'' +
                ", med_name='" + med_name + '\'' +
                ", pur_sum=" + pur_sum +
                '}';
    }
}
