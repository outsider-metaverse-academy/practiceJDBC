package com.ohgiraffers.practice;

import com.ohgiraffers.model.dto.CategoryDTO;

import java.util.List;

public class SelectApplication {

    public static void main(String[] args) {

        CategoryAllSelectService categorySelectService = new CategoryAllSelectService();
        List<CategoryDTO> categories = categorySelectService.selectAllCategory();
        categories.forEach(System.out::println);
    }
}
