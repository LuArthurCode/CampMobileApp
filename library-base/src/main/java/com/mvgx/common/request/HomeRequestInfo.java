package com.mvgx.common.request;

import java.io.Serializable;

/**
 * @Author Arthur
 * @Date 2023/03/29 14:06
 */
public class HomeRequestInfo implements Serializable {


    /**
     * participantId : 0
     * trId : 0
     * userId : 0
     */

    private int participantId;
    private int trId;
    private int userId;

    public int getParticipantId() {
        return participantId;
    }

    public void setParticipantId(int participantId) {
        this.participantId = participantId;
    }

    public int getTrId() {
        return trId;
    }

    public void setTrId(int trId) {
        this.trId = trId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
