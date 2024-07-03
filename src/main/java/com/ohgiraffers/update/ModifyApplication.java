package com.ohgiraffers.update;

import com.ohgiraffers.model.dto.CategoryDTO;
import com.ohgiraffers.practice.CategoryRegistService;

import java.util.Scanner;

public class ModifyApplication {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("수정할 카테고리의 카테고리 코드를 입력하세요 : ");
        int categoryCode = sc.nextInt();

        System.out.print("변경할 카테고리 이름을 입력하세요 : ");
        sc.nextLine();
        String categoryName = sc.nextLine();

        System.out.print("변경할 참조 카테고리 코드를 입력하세요 : ");
        int refCategoryCode = sc.nextInt();


        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setCategoryCode(categoryCode);
        categoryDTO.setCategoryName(categoryName);
        categoryDTO.setRefCategoryCode(refCategoryCode);

        CategoryModifyService categoryModifyService = new CategoryModifyService();

        if (categoryModifyService.updateCategory(categoryDTO)) {
            System.out.println("카테고리 수정에 성공하셨습니다.");

        } else {
            System.out.println("카테고리 수정에 실패했습니다.");
        }
    }
}
