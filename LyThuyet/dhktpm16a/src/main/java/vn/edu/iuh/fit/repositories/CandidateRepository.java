package vn.edu.iuh.fit.repositories;

import vn.edu.iuh.fit.models.Candidate;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CandidateRepository {

    private Connection connection;

    public CandidateRepository() throws Exception{
        Class.forName("org.mariadb.jdbc.Driver");
        String url = "jdbc:mariadb://localhost:3306/sampledb?createDatabaseIfNotExist=true";
        connection = DriverManager.getConnection(url, "root", "password");
    }

    public void insert(Candidate candidate)throws Exception{
        String sql="insert into Candidate values(?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setLong(1,candidate.getId());
        ps.setString(2,candidate.getName());
        ps.executeUpdate();
    }
    public void update(Candidate candidate)throws Exception{
        String sql="update Candidate set name=? where id=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1,candidate.getName());
        ps.setLong(2,candidate.getId());
        ps.executeUpdate();
    }
    public void delete(long id)throws Exception{
        String sql="delete from Candidate where id=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setLong(1,id);
        ps.executeUpdate();
    }

    public Optional<Candidate> getByID(long id)throws Exception{
        String sql="select * from Candidate where id=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setLong(1,id);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            Candidate c = new Candidate(rs.getLong(1), rs.getString(2));
            return Optional.of(c);
        }
        return Optional.empty();
    }

    public List<Candidate> getAll()throws Exception{
        String sql="select * from Candidate ";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<Candidate>lst=new ArrayList<>();
        while(rs.next()){
            Candidate c = new Candidate(rs.getLong(1), rs.getString(2));
            lst.add(c);
        }
        return lst;
    }
}
