package flowershop.datasource.h2DB;

import flowershop.datasource.FlowerCreator;
import flowershop.datasource.FlowerProvider;
import flowershop.flower.*;
import org.w3c.dom.Element;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DbFlowerProvider extends FlowerCreator implements FlowerProvider {

    //    DB constants
    private static final String JDBC_DRIVER = "org.h2.Driver";
    private static final String DB_URL = "jdbc:h2:~/test";
    private static final String USER = "sa";
    private static final String PASSWORD = "";

    //    Table values constants
    private static final String FLOWERNAME_VALUE = "FLOWERNAME";
    private static final String FLOWERSIZE_VALUE = "FLOWERSIZE";
    private static final String FLOWERPRICE_VALUE = "FLOWERPRICE";
    private static final String COLOR_VALUE = "COLOR";
    private static final String PETAL_VALUE = "PETAL";
    private static final String DENSITY_VALUE = "DENSITY";

    private Map<String, Flower> storage = new HashMap<>();

    public DbFlowerProvider() {
        try {
            List<Flower> flowers = readDB();
            for (Flower flower : flowers) {
                storage.put(flower.getFlowerName(), flower);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private List<Flower> readDB() throws Exception {
        List<Flower> result = new ArrayList<>();

        try {
            Class.forName(JDBC_DRIVER);
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            Statement st = conn.createStatement();
            String sql = "SELECT FLOWERNAME, FLOWERSIZE, FLOWERPRICE, COLOR, PETAL, DENSITY FROM FLOWERS";
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String name = rs.getString(FLOWERNAME_VALUE);
                int size = rs.getInt(FLOWERSIZE_VALUE);
                int price = rs.getInt(FLOWERPRICE_VALUE);
                String color = rs.getString(COLOR_VALUE);
                String petal = rs.getString(PETAL_VALUE);
                String density = rs.getString(DENSITY_VALUE);
                result.add(createFlower(name, size, price, color, getIntValue(petal), getIntValue(density)));
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    @Override
    public Flower getFlowerByName(String name) {
        return storage.get(name);
    }
}