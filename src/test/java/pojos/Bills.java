package pojos;

public class Bills {

    private String createdBy;
    private String createdDate;
    private int id;
    private String status;

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Bills() {
    }

    public Bills(String createdBy, String createdDate, int id, String status) {
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.id = id;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Bills{" +
                "createdBy='" + createdBy + '\'' +
                ", createdDate='" + createdDate + '\'' +
                ", id=" + id +
                ", status='" + status + '\'' +
                '}';
    }
}
