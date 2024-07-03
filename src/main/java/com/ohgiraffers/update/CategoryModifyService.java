package com.ohgiraffers.update;

import com.ohgiraffers.model.dto.CategoryDTO;
import com.ohgiraffers.practice.CategoryDAO;

import java.sql.Connection;

import static com.ohgiraffers.common.Template.*;

public class CategoryModifyService {

    public boolean updateCategory(CategoryDTO categoryDTO) {
        Connection conn = getConnection();
        com.ohgiraffers.practice.CategoryDAO categoryDAO = new CategoryDAO();

        int result = categoryDAO.updateCategory(conn, categoryDTO);

        if (result > 0) {
            commit(conn);
        } else {
            rollback(conn);
        }
        close(conn);
        return result > 0;
    }
}
