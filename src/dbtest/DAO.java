package dbtest;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;

public class DAO {
	
	private Connection connection = null;
	
	// Database variables 
	public static final String DATABASE = "jabuti";
	public static final String IP = "localhost";
	public static final String USER_NAME = "pedro";
	public static final String PASSWORD = "123456";
	
	public DAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			connection = DriverManager.getConnection(
					"jdbc:mysql://" + IP + "/" + DATABASE, USER_NAME, PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void adiciona(Pessoas pessoa) {
		String sql = "INSERT INTO Pessoas" + 
				"(nome, nascimento, altura) values (?, ?, ?)";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, pessoa.getNome());
			stmt.setDate(2, new Date(
					pessoa.getNascimento().getTimeInMillis()));
			stmt.setDouble(3, pessoa.getAltura());
			stmt.execute();
			stmt.close();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
	
	public List<Pessoas> getLista() {
		List<Pessoas> pessoas = new ArrayList<Pessoas>();
		try {
			PreparedStatement stmt = connection.prepareStatement(
					"SELECT * FROM Pessoas");
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Pessoas pessoa = new Pessoas();
				Calendar data = Calendar.getInstance();
				pessoa.setId(rs.getInt("id"));
				pessoa.setNome(rs.getString("nome"));
				data.setTime(rs.getDate("nascimento"));
				pessoa.setNascimento(data);
				pessoa.setAltura(rs.getDouble("altura"));
				pessoas.add(pessoa);
				rs.close();
				stmt.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pessoas;
	}
		
	
	public void altera(Pessoas pessoa) {
		String sql = "UPDATE Pessoas SET" +
					"nome=?, nascimento=?, altura=? WHERE id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1,  pessoa.getNome());
			stmt.setDate(2,  new Date(
					pessoa.getNascimento().getTimeInMillis()));
			stmt.setDouble(3, pessoa.getAltura());
			stmt.setInt(4, pessoa.getId());			
			stmt.execute();
			stmt.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void remove(Integer id) {
		try {
			PreparedStatement stmt = connection.prepareStatement(
					"DELETE FROM Pessoas WHERE id=?");
			stmt.setLong(1, id);
			stmt.execute();
			stmt.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void close() {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
