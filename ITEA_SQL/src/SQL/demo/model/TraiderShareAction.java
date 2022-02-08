package SQL.demo.model;

import java.util.Objects;

public class TraiderShareAction extends BaseModel {
    private int operation;
    private long traider_id;
    private long share_rate_id;
    private long amount;

    public TraiderShareAction() {
    }

    public TraiderShareAction(long id, int operation, long traider_id, long share_rate_id, long amount) {
        super(id);
        this.operation = operation;
        this.traider_id = traider_id;
        this.share_rate_id = share_rate_id;
        this.amount = amount;
    }

    public int getOperation() {
        return operation;
    }

    public void setOperation(int operation) {
        this.operation = operation;
    }

    public long getTraider_id() {
        return traider_id;
    }

    public void setTraider_id(long traider_id) {
        this.traider_id = traider_id;
    }

    public long getShare_rate_id() {
        return share_rate_id;
    }

    public void setShare_rate_id(long share_rate_id) {
        this.share_rate_id = share_rate_id;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TraiderShareAction that = (TraiderShareAction) o;
        return operation == that.operation && traider_id == that.traider_id && share_rate_id == that.share_rate_id && amount == that.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), operation, traider_id, share_rate_id, amount);
    }
}
