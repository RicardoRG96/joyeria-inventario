package com.mycompany.joyeriaInventario;

import com.mycompany.joyeriaInventario.view.Home;
import java.sql.SQLException;

public class JewelryInventory {

    public static void main(String[] args) throws SQLException {
        Home home = new Home();
        home.setVisible(true);
    }
}
