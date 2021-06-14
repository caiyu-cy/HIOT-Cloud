package com.example.hiotclound.data.bean;

import java.io.Serializable;

/**
 * 上行开关通道对象
 */
public class UpDataStreamSwitchBean implements Serializable {

    /**
     * 下行通道id
     */
    private String upDataStreamId;
    /**
     * 操作时间
     */
    private String timing;
    /**
     * 状态
     */
    private int status;

    public String getUpDataStreamId() {
        return upDataStreamId;
    }

    public void setUpDataStreamId(String upDataStreamId) {
        this.upDataStreamId = upDataStreamId;
    }

    public String getTiming() {
        return timing;
    }

    public void setTiming(String timing) {
        this.timing = timing;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
