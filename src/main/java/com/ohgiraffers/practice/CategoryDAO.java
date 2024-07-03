package com.ohgiraffers.practice;

import com.ohgiraffers.model.dto.CategoryDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.ohgiraffers.common.Template.close;

public class CategoryDAO {

    public int insertCategory(Connection con , CategoryDTO category) {
        PreparedStatement ps = null;
        int result = 0;
        String query = "INSERT INTO TBL_CATEGORY(CATEGORY_CODE, CATEGORY_NAME, REF_CATEGORY_CODE) "
                + "VALUES (?, ?, ?)";

        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, category.getCategoryCode());
            ps.setString(2, category.getCategoryName());
            ps.setInt(3, category.getRefCategoryCode());
            result = ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(ps);

        }
        return result;
    }
}
