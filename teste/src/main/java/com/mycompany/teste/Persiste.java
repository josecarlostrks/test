package com.mycompany.teste;

import com.mycompany.entidades.Pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.annotation.Resource;
//import javax.annotation.sql.DataSourceDefinition;


import javax.ejb.Stateless;
import javax.sql.DataSource;


//@DataSourceDefinition(
//    name="java/comp/env/jdbc/teste",
//    className = "org.postgresql.ds.PGPoolingDataSource",
//    serverName="localhost",
//    portNumber=5432,
//    user = "postgres",
//    password = "trks",
//    databaseName = "segunda"       
//)


@Stateless
public class Persiste implements Persists{
    
    @Resource(name = "java:app/jdbc/docker")
    private DataSource dataSource;
    private Connection connection;
    
//    @Resource(name="java:app/jdbc/teste")
//    public void setDataSource(DataSource dataSource) throws SQLException{
//        try{
//            this.dataSource = dataSource;
//            this.connection = dataSource.getConnection();
//        }catch(SQLException e){
//            e.printStackTrace();
//        }
//    }

    public Persiste() {
    }
    
    @Override
    public Pessoa buscarPorCPF(String cpf) {
        String sql = "SELECT * FROM pessoa WHERE cpf = ?";
        try(Connection con = dataSource.getConnection()){
            PreparedStatement statment = con.prepareStatement(sql);
            statment.setString(1, cpf);
            ResultSet resultado = statment.executeQuery();
            
            if(resultado.next()){
                Pessoa pessoa = new Pessoa(
                        resultado.getString("nome"), 
                        resultado.getString("cpf")
                );
                return pessoa;
            }
                return null;
        }catch (SQLException ex) {
                return null;
        }
       
    }
    
}
