package com.lvt.waifuranker.repositories;

import com.lvt.waifuranker.models.Waifu;
import java.sql.*;
import java.util.*;

public class WaifuRepository {
    private Connection connection;

    public WaifuRepository() {
        try {


            System.out.println("Loading database...");
            connection = DriverManager.getConnection("jdbc:sqlite:./Database");
            System.out.println("Connection to SQLite has been established.");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Waifu> getWaifuList() {

        List<Waifu> waifus = new ArrayList<>();

        try {

            String select = "SELECT * FROM waifus";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(select);

            while (resultSet.next()) {

                waifus.add(new Waifu(resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getDouble("score"),
                        resultSet.getString("anime"),
                        resultSet.getString("imageURL"),
                        resultSet.getString("description"),
                        resultSet.getString("quote"),
                        resultSet.getLong("votesCount")));
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        waifus.sort(Comparator.comparing(Waifu::getScore).reversed());
        return waifus;

    }

    public void updateWaifuScore(Long id, double score) {
        //newAve = ((oldAve*oldNumPoints) + x)/(oldNumPoints+1)
    }

}