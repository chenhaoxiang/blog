package cn.chenhaoxiang.entity;

/**
 * Created by 陈浩翔 on 2017/7/27 0027.
 */
public class BlogEntity {
    private Boolean status;
    private String error;
    private String data;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "BlogEntity{" +
                "status=" + status +
                ", error='" + error + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
