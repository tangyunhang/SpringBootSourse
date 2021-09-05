package com.abc.service;

import lombok.AllArgsConstructor;

/**
 * 核心业务类型
 */
@AllArgsConstructor//全参构造器
public class SomeService {
    private String beforeStr;
    private String afterStr;

    /**
     * 核心代码
     * @param word
     * @return
     */
    public String warp(String word){
        return beforeStr+word+afterStr;
    }
}
