package com.etc.bookstore.ui;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, URISyntaxException, IOException, ClassNotFoundException {
        new BkMenu().mainMenu();
    }
}
