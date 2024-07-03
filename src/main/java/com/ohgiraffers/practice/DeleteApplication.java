package com.ohgiraffers.practice;

import com.ohgiraffers.model.dto.CategoryDTO;

import java.util.Scanner;

public class DeleteApplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print(" 제거할 카테고리 번호를 입력하세요");
        int categoryId = sc.nextInt();
        if (CategoryDeleteService.delete(categoryId)) {
            System.out.println("메뉴 등록에 성공하셨습니다.");

        } else {
            System.out.println("메뉴 등록에 실패했습니다.");
        }
    }
}
