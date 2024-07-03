package com.ohgiraffers.practice;

import com.ohgiraffers.model.dto.CategoryDTO;

import java.util.Scanner;

public class RegistApplication {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("카테고리 이름을 입력하세요");
        String categoryName = sc.nextLine();
        System.out.println("카테고리 코드를 입력하세요");
        int categoryCode = sc.nextInt();
        System.out.println("참조 카테고리 코드를 입력하세요");
        int refCategoryCode = sc.nextInt();
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setCategoryCode(categoryCode);
        categoryDTO.setRefCategoryCode(refCategoryCode);
        categoryDTO.setCategoryCode(categoryCode);
        categoryDTO.setCategoryName(categoryName);
        CategoryRegistService categoryRegistService = new CategoryRegistService();
        if (categoryRegistService.registCategory(categoryDTO)) {
            System.out.println("카테고리 등록에 성공하셨습니다.");

        } else {
            System.out.println("카테고리 등록에 실패했습니다.");
        }
    }
}
