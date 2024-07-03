package com.ohgiraffers.practice;

import com.ohgiraffers.model.dto.CategoryDTO;

import java.util.Scanner;

public class ApplicationSelect {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("조회하실 메뉴의 코드 :");
        int categpryCpde = sc.nextInt();
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setCategoryCode(categpryCpde);
        CategorySelectService categorySelectService = new CategorySelectService();
        if((categoryDTO=categorySelectService.selectCategory(categoryDTO))!=null){
            System.out.println(categoryDTO);
        }else{
            System.out.println("실패하셨습니다.");
        }
    }
}
