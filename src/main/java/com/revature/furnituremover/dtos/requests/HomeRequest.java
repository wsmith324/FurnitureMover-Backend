package com.revature.furnituremover.dtos.requests;

public class HomeRequest {
    private String name;
    private int size;

    public HomeRequest() {}

    public HomeRequest(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "HomeRequest{" +
                "name='" + name + '\'' +
                ", size=" + size +
                '}';
    }
}
