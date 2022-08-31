package org.navi.dao;

import org.navi.pojo.Animal;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DB {
    //TODO: implement try with resource later
    //TODO: Transactions commit or rollback

    Connection connection;
    List<Animal> animalList = new ArrayList<>();
    //ToDo : Array list always has to fetch data from the data base

    {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "navi", "TheWeatherIsGreat22");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Animal> listOFAllAnimals() throws SQLException {
        animalList.clear();
        // generating the list of objects from the database
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * from animal");
        //printing the table
        while (resultSet.next()) {
            String name = resultSet.getString(2);
            String breed = resultSet.getString(3);
            Animal animal = new Animal(name, breed);
            animalList.add(animal);
        }
        return animalList;

    }

    public int save(String nameOfAnimal, String breedOfAnimal) throws SQLException {
        //saving new data in the database
        String saveQuery = "INSERT INTO animal (name, breed) VALUES (?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(saveQuery);
        preparedStatement.setString(1, nameOfAnimal);
        preparedStatement.setString(2, breedOfAnimal);
        return preparedStatement.executeUpdate();
    }

    public int update(String conditionForUpdate, String updateNameOfAnimal, String updateBreedOfAnimal) throws SQLException {
        //updating the values in the database

        String updateQuery = "UPDATE animal SET Name = ?, Breed = ?  WHERE Name = ?";
        PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
        updateStatement.setString(1,updateNameOfAnimal);
        updateStatement.setString(2,updateBreedOfAnimal);
        updateStatement.setString(3,conditionForUpdate);
        return updateStatement.executeUpdate();
    }

    public int delete(String animalNameToBeDeleted) throws SQLException {
        //deleting the data from the database
        String deleteQuery = "DELETE FROM animal WHERE name = ?";
        PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery);
        deleteStatement.setString(1, animalNameToBeDeleted);
        return deleteStatement.executeUpdate();
    }

}
