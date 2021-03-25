package ajaxAndjquery.bean;

public class CityBean {
    private int id;
    private int pid;
    private String cname;

    @Override
    public String toString() {
        return "CityBean{" +
                "id=" + id +
                ", pid=" + pid +
                ", cname='" + cname + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }
}
