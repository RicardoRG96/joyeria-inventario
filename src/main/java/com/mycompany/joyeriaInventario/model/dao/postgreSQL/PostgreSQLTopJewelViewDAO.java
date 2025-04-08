package com.mycompany.joyeriaInventario.model.dao.postgreSQL;

import com.mycompany.joyeriaInventario.exception.common.DAOException;
import com.mycompany.joyeriaInventario.model.dao.TopJewelViewDAO;
import com.mycompany.joyeriaInventario.model.views.TopJewelView;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostgreSQLTopJewelViewDAO implements TopJewelViewDAO {

    private final String GET_ALL = "SELECT * FROM top_products";
    
    private Connection conn;

    public PostgreSQLTopJewelViewDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<TopJewelView> getAll() throws DAOException {
       PreparedStatement preparedStatement = null;
       ResultSet resultSet = null;
       List<TopJewelView> TopjewelsView = new ArrayList<>();
       try {
           preparedStatement = conn.prepareStatement(GET_ALL);
           resultSet = preparedStatement.executeQuery();
           while (resultSet.next()) {
               TopjewelsView.add(convert(resultSet));
           }
       } catch (SQLException e) {
           throw new DAOException("Error al intentar obtener las joyas más vendidas", e);
       } finally {
           if (preparedStatement != null) {
               try {
                   preparedStatement.close();
               } catch (SQLException e) {
                   throw new DAOException("Error al intentar cerrar la conexion", e);
               }
           }
           if (resultSet != null) {
               try {
                   resultSet.close();
               } catch (SQLException e) {
                   throw new DAOException("Error al intentar cerrar la conexion", e);
               }
           }
       }
       return TopjewelsView;
    }
    
    private TopJewelView convert(ResultSet rs) throws SQLException {
        Long jewelId = rs.getLong("jewel_id");
        String jewelName = rs.getString("name");
        Long totalQuantitySold = rs.getLong("total_quantity_sold");
        double totalRevenue = rs.getDouble("total_revenue");
        TopJewelView topJewelView = new TopJewelView(jewelId, jewelName, totalQuantitySold, totalRevenue);
        
        return topJewelView;
    }
    
}
