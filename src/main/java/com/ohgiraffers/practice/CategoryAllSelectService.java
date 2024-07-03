package com.ohgiraffers.practice;

import com.ohgiraffers.model.dto.CategoryDTO;

import java.sql.Connection;
import java.util.List;

import static com.ohgiraffers.common.Template.getConnection;

public class CategoryAllSelectService {

    public List<CategoryDTO> selectAllCategory() {
        Connection con = getConnection();

        CategoryDAO categoryDAO = new CategoryDAO();
        List<CategoryDTO> categories = categoryDAO.selectAllCategory(con);

        return categories;
    }
}
