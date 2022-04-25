package pojos;

public class BillsPojo {
    private int id;
    private String ssn;
    private double totalCost;
    private String paymentMethod;
    private Bills appointment;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Bills getAppointment() {
        return appointment;
    }

    public void setAppointment(Bills appointment) {
        this.appointment = appointment;
    }

    public BillsPojo() {
    }

    public BillsPojo(int id, String ssn, double totalCost, String paymentMethod, Bills appointment) {
        this.id = id;
        this.ssn = ssn;
        this.totalCost = totalCost;
        this.paymentMethod = paymentMethod;
        this.appointment = appointment;
    }

    @Override
    public String toString() {
        return "BillsPojo{" +
                "id=" + id +
                ", ssn='" + ssn + '\'' +
                ", totalCost=" + totalCost +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", appointment=" + appointment +
                '}';
    }
}
