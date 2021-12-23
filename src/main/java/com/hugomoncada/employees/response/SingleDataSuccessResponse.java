package com.hugomoncada.employees.response;

import lombok.Data;

@Data
public class SingleDataSuccessResponse <T> extends SuccessResponse{
    
    private T data;

    public SingleDataSuccessResponse(String status, T data){
        super(status);
        this.data = data;
    }


}
