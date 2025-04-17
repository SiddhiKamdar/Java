/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librarymanagmentsystem;
import java.util.*;
import java.sql.*;
/**
 *
 * @author HP
 */
public class Author {
    private Connection connection;
    
    public Author(Connection connection){
        this.connection = connection;
    }
    
    public void addAuthor(String name){
        try{
            String sql = "INSERT INTO authors (name) VALUES (?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    public void updateAuthor(int id, String newName){
        try{
            String sql = "UPDATE authors SET name = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, newName);
            statement.setInt(2, id);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    public void deleteAuthor(int id){
        try{
            String sql = "DELETE FROM authors WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    public List<String> getAllAuthors(){
        List<String> authors = new ArrayList<>();
        try{
            String sql = "SELECT * FROM authors";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                authors.add("Author ID: " + id + ", Name: "+ name);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return authors;
    }
}
