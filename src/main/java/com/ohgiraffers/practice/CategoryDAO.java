package com.ohgiraffers.practice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.ohgiraffers.common.Template.close;

public class CategoryDAO {
    public int deleteMenu(Connection con, Long id) {
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
}
