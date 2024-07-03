package com.ohgiraffers.practice;

import com.ohgiraffers.model.dto.CategoryDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.ohgiraffers.common.Template.close;

public class CategoryDAO {
    public CategoryDTO selectCategory(Connection con, CategoryDTO categoryDTO){
        PreparedStatement pstmt =null;
        ResultSet rs=null;
        CategoryDTO dto=null;
        String query = "SELECT CATEGORY_CODE,CATEGORY_NAME,REF_CATEGORY_CODE FROM TBL_CATEGORY WHERE CATEGORY_CODE=?";

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, categoryDTO.getCategoryCode());

            rs = pstmt.executeQuery();
            while(rs.next()){
                dto = new CategoryDTO();
                dto.setCategoryCode(rs.getInt("CATEGORY_CODE"));
                dto.setCategoryName(rs.getString("CATEGORY_NAME"));
                dto.setRefCategoryCode(rs.getInt("REF_CATEGORY_CODE"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(pstmt);
        }
        return dto;
    }

}
