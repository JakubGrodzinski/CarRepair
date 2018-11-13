package pl.coderslab.model;

public class Status
{

    private Long id;
    private String stat;

    public Status(Long id, String stat)
    {
        this.id = id;
        this.stat = stat;
    }

    public Status () {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }
}
