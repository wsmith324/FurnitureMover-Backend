package com.revature.furnituremover.dtos.responses;

public class FurnitureResponse {
    private String name;
    private int size;

    public FurnitureResponse() {}

    public FurnitureResponse(String name, int size) {
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
        return "FurnitureResponse{" +
                "name='" + name + '\'' +
                ", size=" + size +
                '}';
    }
}
