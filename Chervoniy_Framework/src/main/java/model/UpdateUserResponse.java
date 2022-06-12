package model;

import java.util.Date;
import java.util.Objects;

public class UpdateUserResponse {
    private String name;
    private String job;
    private Date updatedAt;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }


    @Override
    public String toString() {
        return "CreateUserResponse{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                '}';
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UpdateUserResponse that = (UpdateUserResponse) o;
        return Objects.equals(name, that.name) && Objects.equals(job, that.job);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, job);
    }
}
