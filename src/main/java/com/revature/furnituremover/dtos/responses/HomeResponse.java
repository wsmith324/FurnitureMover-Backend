package com.revature.furnituremover.dtos.responses;

public class HomeResponse {
    private String name;
    private int size;

    public HomeResponse() {}

    public HomeResponse(String name, int size) {
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
        return "HomeResponse{" +
                "name='" + name + '\'' +
                ", size=" + size +
                '}';
    }
}
