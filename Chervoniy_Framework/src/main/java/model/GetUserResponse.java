package model;

import java.util.Objects;

public class GetUserResponse {
    User data;
    Object support;

    public User getData() {
        return data;
    }

    public void setData(User data) {
        this.data = data;
    }

    public Object getSupport() {
        return support;
    }

    public void setSupport(Object support) {
        this.support = support;
    }

    @Override
    public String toString() {
        return "GetUserResponse{" +
                "data=" + data +
                ", support=" + support +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetUserResponse that = (GetUserResponse) o;
        return Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }
}
