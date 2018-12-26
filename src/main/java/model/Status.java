package model;

public class Status {
    private Integer id;
    private enum statusOfOrder { ACCEPTED, APPROVED_REPAIR_COSTS, IN_REPAIR, READY_FOR_PICKUP, RESIGNATION

    }

    public Status(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
