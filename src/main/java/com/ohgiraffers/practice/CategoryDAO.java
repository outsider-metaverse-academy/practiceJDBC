package com.ohgiraffers.practice;

import com.ohgiraffers.model.dto.CategoryDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.ohgiraffers.common.Template.close;

public class CategoryDAO {
    public static int deleteMenu(Connection con, int id) {
        PreparedStatement ps = null;
        int result = 0;
        String query = "DELETE FROM category WHERE id = ?";

        try {
            ps = con.prepareStatement(query);
            ps.setLong(1, id);
            result = ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(ps);
        }
        return result;
    }
    
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

    public int updateCategory(Connection con , CategoryDTO category) {
        PreparedStatement ps = null;
        int result = 0;
        String query = "UPDATE TBL_CATEGORY SET CATEGORY_NAME = ?, REF_CATEGORY_CODE = ? " +
                "WHERE CATEGORY_CODE = ?";

        try {
            ps = con.prepareStatement(query);
            ps.setString(1, category.getCategoryName());
            ps.setInt(2, category.getRefCategoryCode());
            ps.setInt(3, category.getCategoryCode());
            result = ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(ps);

        }
        return result;
    }

    public List<CategoryDTO> selectAllCategory(Connection con) {
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        List<CategoryDTO> categories = null;

        try {
            String query = "SELECT CATEGORY_CODE, CATEGORY_NAME, REF_CATEGORY_CODE FROM TBL_CATEGORY";
            pstmt = con.prepareStatement(query);

            rset = pstmt.executeQuery();

            categories = new ArrayList<CategoryDTO>();

            while(rset.next()){
                CategoryDTO category = new CategoryDTO();
                category.setCategoryCode(rset.getInt("CATEGORY_CODE"));
                category.setCategoryName(rset.getString("CATEGORY_NAME"));
                category.setRefCategoryCode(rset.getInt("REF_CATEGORY_CODE"));
                categories.add(category);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(con);
            close(pstmt);
            close(rset);
        }

        return categories;
    }
}
