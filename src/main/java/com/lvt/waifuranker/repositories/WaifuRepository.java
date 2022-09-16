package com.lvt.waifuranker.repositories;

import com.lvt.waifuranker.models.Waifu;
import java.sql.*;
import java.util.*;

public class WaifuRepository {
    private Connection connection;

    public WaifuRepository() {
        try {


            System.out.println("Loading database...");
            connection = DriverManager.getConnection("jdbc:sqlite:./DB");
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

                waifus.add(new Waifu(
                        resultSet.getString("name"),
                        resultSet.getDouble("score"),
                        resultSet.getString("anime"),
                        resultSet.getString("description"),
                        resultSet.getString("url"),
                        resultSet.getString("quote"),
                        resultSet.getLong("votes")));
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

    public static void main(String[] args) {

        WaifuRepository wf = new WaifuRepository();

        List<Waifu> waifus = wf.getWaifuList();

        System.out.println(waifus.toString());

    }

}