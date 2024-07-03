package com.ohgiraffers.select;

import com.ohgiraffers.model.dto.CategoryDTO;

import java.sql.Connection;

import static com.ohgiraffers.common.Template.*;

//Service
// 주 역할 : 트랜잭션 담당
// 하나의 트랜잭션은 하나의 Connection을 가진다.
public class CategorySelectService {
    public CategoryDTO selectCategory(CategoryDTO categoryDTO){
        Connection con = getConnection();

        CategoryDAO categoryDAO = new CategoryDAO();
        categoryDTO = categoryDAO.selectCategory(con, categoryDTO);

        if(categoryDTO!=null){
            commit(con);
        }else{
            rollback(con);
        }

        close(con);

        return categoryDTO;
    }
}
