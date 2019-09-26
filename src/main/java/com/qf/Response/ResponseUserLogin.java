package com.qf.Response;

import lombok.Data;

import java.util.List;

/**
 * Created by 54110 on 2019-09-25.
 */
@Data
public class ResponseUserLogin<T> {

    private List<T> list;

    private Long total;
}
