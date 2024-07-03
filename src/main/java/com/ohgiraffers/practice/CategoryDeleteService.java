package com.ohgiraffers.practice;

import static com.ohgiraffers.common.Template.*;


import java.sql.Connection;

public class CategoryDeleteService {

    public static boolean delete(int id){
        Connection con = getConnection();
        int result = CategoryDAO.deleteMenu(getConnection(), id);
        if (result > 0) {
            commit(con);
        } else {
            rollback(con);
        }
        close(con);
        return result > 0;
    }
}
