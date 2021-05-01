package model;

import org.springframework.data.annotation.Id;

public class DBSequence {

    @Id
    private String  fareId;
    private int seq;

    public String getFareId() {
        return fareId;
    }

    public void setFareId(String fareId) {
        this.fareId = fareId;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public DBSequence(String fareId, int seq) {
        this.fareId = fareId;
        this.seq = seq;
    }
}
