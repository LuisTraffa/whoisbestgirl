package com.lvt.waifuranker.repositories;

import com.lvt.waifuranker.models.UserScore;
import com.lvt.waifuranker.models.Waifu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MyWaifuListRepository {

    private Connection connection;

    public MyWaifuListRepository() {
        try {


            System.out.println("Loading database...");
            connection = DriverManager.getConnection("jdbc:sqlite:./Database");
            System.out.println("Connection to SQLite has been established.");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Long getUserId (String username){

        try {

            String selectId = "SELECT id FROM users WHERE username = '" + username + "'";
            Statement statementSelectId = connection.createStatement();
            ResultSet resultSet = statementSelectId.executeQuery(selectId);

            return resultSet.getLong("id");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return -1L;

    }

    public List<UserScore> getUserScores(String username) {

        List<UserScore> userScores = new ArrayList<>();

        try {

            Long userId = getUserId(username);
            String selectUserScores = "SELECT * FROM waifulist" + userId;
            Statement statementSelectUserScores = connection.createStatement();
            ResultSet resultSet = statementSelectUserScores.executeQuery(selectUserScores);

            while (resultSet.next()) {
                userScores.add(new UserScore(resultSet.getString("name"), resultSet.getLong("score")));
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        return userScores;
    }

    public List<Waifu> getWaifuList(String username) {

        List<Waifu> waifus = new ArrayList<>();

        try {

            List<UserScore> userScores = getUserScores(username);

            List<String> waifuNames = new ArrayList<>();

            for (UserScore userScore : userScores) {
                waifuNames.add(userScore.getName());
            }

            for (String name : waifuNames) {

                String select = "SELECT * FROM waifus WHERE name = " + name;
                Statement statementSelect = connection.createStatement();
                ResultSet resultSetSelect = statementSelect.executeQuery(select);

                while (resultSetSelect.next()) {

                    waifus.add(new Waifu(
                            resultSetSelect.getString("name"),
                            resultSetSelect.getDouble("score"),
                            resultSetSelect.getString("anime"),
                            resultSetSelect.getString("url"),
                            resultSetSelect.getString("description"),
                            resultSetSelect.getString("quote"),
                            resultSetSelect.getLong("votes")));
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        waifus.sort(Comparator.comparing(Waifu::getScore).reversed());
        return waifus;

    }

}
