package event.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import event.model.Event;

public class EventDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3306/dasuni?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "";
	
	private static final String INSERT_EVENT_SQL = "INSERT INTO event" + " (no, name, decoration, catering, transportation, sound, light) VALUES " + " (?, ?, ?, ?, ?, ?, ?);";
	private static final String SELECT_EVENT_BY_ID = "select id, no, name, decoration, catering, transportation, sound, light from event where id = ?";
	private static final String SELECT_ALL_EVENT = "select * from event";
	private static final String DELETE_EVENT_SQL = "delete from event where id = ?;";
	private static final String UPDATE_EVENT_SQL = "update event set no = ?, name = ?, decoration = ?, catering = ?, transportation = ?, sound = ?, light = ? where id = ?;";
	
	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
			//insert event
			public void insertEvent(Event event) throws SQLException {
				System.out.println(INSERT_EVENT_SQL);
				try(Connection connection = getConnection();
						PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EVENT_SQL);){
					preparedStatement.setString(1, event.getNo());
					preparedStatement.setString(2, event.getName());
					preparedStatement.setString(3, event.getDecoration());
					preparedStatement.setString(4, event.getCatering());
					preparedStatement.setString(5, event.getTransportation());
					preparedStatement.setString(6, event.getSound());
					preparedStatement.setString(7, event.getLight());
					System.out.println(preparedStatement);
					preparedStatement.executeUpdate();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
	
			
			//update event
			public boolean updateEvent(Event event) throws SQLException {
				boolean rowUpdated;
				try (Connection connection = getConnection();
						PreparedStatement statement = connection.prepareStatement(UPDATE_EVENT_SQL);){
					statement.setString(1, event.getNo());
					statement.setString(2, event.getName());
					statement.setString(3, event.getDecoration());
					statement.setString(4, event.getCatering());
					statement.setString(5, event.getTransportation());
					statement.setString(6, event.getSound());
					statement.setString(7, event.getLight());
					statement.setInt(8, event.getId());
						
					rowUpdated = statement.executeUpdate() > 0;
				}
				return rowUpdated;
			}
			
			//select event by id
			public Event selectEvent(int id) {
				Event event = null;
					
				try (Connection connection = getConnection();
						PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EVENT_BY_ID);){
					preparedStatement.setInt(1, id);
					System.out.println(preparedStatement);
						
					ResultSet rs = preparedStatement.executeQuery();
						
					while (rs.next()) {
						String no = rs.getString("no");
						String name = rs.getString("name");
						String decoration = rs.getString("decoration");
						String catering = rs.getString("catering");
						String transportation = rs.getString("transportation");
						String sound = rs.getString("sound");
						String light = rs.getString("light");
						event = new Event(id, no, name, decoration, catering, transportation, sound, light);
					}
				}catch (SQLException e) {
					e.printStackTrace();
				}
				return event;
			}
			
			
			//select event
			public List<Event> selectAllEvent() {
				List<Event> event = new ArrayList<>();
					
				try (Connection connection = getConnection();
						PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EVENT);){
					System.out.println(preparedStatement);
						
					ResultSet rs = preparedStatement.executeQuery();
						
					while (rs.next()) {
						int id = rs.getInt("id");
						String no = rs.getString("no");
						String name = rs.getString("name");
						String decoration = rs.getString("decoration");
						String catering = rs.getString("catering");
						String transportation = rs.getString("transportation");
						String sound = rs.getString("sound");
						String light = rs.getString("light");
						event.add(new Event(id, no, name, decoration, catering, transportation, sound, light));
					}
				}catch (SQLException e) {
					e.printStackTrace();
				}
				return event;
			}
			
			
			//delete event
			public boolean deleteEvent(int id) throws SQLException {
				boolean rowDeleted;
				try (Connection connection = getConnection();
						PreparedStatement statement = connection.prepareStatement(DELETE_EVENT_SQL);){
					statement.setInt(1, id);
					rowDeleted = statement.executeUpdate() > 0;
				}
				return rowDeleted;
			}

}
