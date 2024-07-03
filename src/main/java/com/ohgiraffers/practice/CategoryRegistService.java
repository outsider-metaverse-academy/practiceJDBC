package com.ohgiraffers.practice;

import com.ohgiraffers.model.dto.CategoryDTO;

import java.sql.Connection;

import static com.ohgiraffers.common.Template.*;
import static com.ohgiraffers.common.Template.close;

public class CategoryRegistService {

    public boolean registCategory(CategoryDTO categoryDTO) {
        Connection conn = getConnection();
        CategoryDAO categoryDAO = new CategoryDAO();
        int result = categoryDAO.insertCategory(conn, categoryDTO);
        if (result > 0) {
            commit(conn);
        } else {
            rollback(conn);
        }
        close(conn);
        return result > 0;
    }
}
