package vn.edu.iuh.fit.sv.Repository;

import vn.edu.iuh.fit.sv.model.Candidate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// DAO
public class CandidateRepository {
    private Connection connection;

    public CandidateRepository() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/sampledb?createDatabaseIfNotExist=true";
        connection = DriverManager.getConnection(url, "root", "sapassword");
    }

    public void insert(Candidate candidate) throws Exception {
        String sql = "insert into Candidate values(?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setLong(1, candidate.getId());
        ps.setString(2, candidate.getName());
        ps.executeUpdate();
    }

    //update
    public void update(Candidate candidate) throws Exception{
        String sql = "update Candidate set name=? where id=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, candidate.getName());
        ps.setLong(2, candidate.getId());
        ps.executeUpdate();
    }
    //Del
    public void delete(long maXoa) throws Exception{
        String sql = "delete from Candidate where id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setLong(1, maXoa);
        ps.executeUpdate();
    }

    // getByID
    public Optional<Candidate> getByID(long id) throws Exception{
        String sql  = "Select * from Candidate where id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setLong(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()){
            Candidate c = new Candidate( rs.getLong("1"), rs.getString(2));
            return Optional.of(c);
        }
        return Optional.empty();
    }

    //getALl
    public List<Candidate> getAll() throws Exception{
        String sql = "SELECT * FORM Candidate";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<Candidate> lst = new ArrayList<>();
        while (rs.next()){
            Candidate c = new Candidate(rs.getLong(1), rs.getString(2));
            lst.add(c);
        }
        return lst;
    }
}
