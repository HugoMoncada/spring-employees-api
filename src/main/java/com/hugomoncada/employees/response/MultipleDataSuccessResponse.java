package com.hugomoncada.employees.response;

import java.util.List;

import lombok.Data;

@Data
public class MultipleDataSuccessResponse <T> extends SuccessResponse{
    private int results;
    private List<T> data;

    public MultipleDataSuccessResponse(String status, int results, List<T> data){
        super(status);
        this.results = results;
        this.data = data;
    }
}
