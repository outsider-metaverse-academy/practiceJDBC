package com.ohgiraffers.update;

import com.ohgiraffers.model.dto.CategoryDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.ohgiraffers.common.Template.close;

public class CategoryDAO {

    public int updateCategory(Connection con , CategoryDTO category) {
        PreparedStatement ps = null;
        int result = 0;
        String query = "UPDATE TBL_CATEGORY SET CATEGORY_NAME = ?, REF_CATEGORY_CODE = ? " +
                "WHERE CATEGORY_ID = ?";

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
