package model.data.mysql;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.ModelException;
import model.Post;
import model.User;
import model.data.PostDAO;
import model.data.mysql.utils.*;

public class MySQLPostDAO implements PostDAO {

	@Override
	public void save(Post post) throws ModelException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = MySQLConnectionFactory.getConnection();
			
			String sqlIsert = " INSERT INTO posts "
					+ " VALUES (DEFAULT, ?, CURDATE(), ?); ";
			
			preparedStatement = connection.prepareStatement(sqlIsert);
			preparedStatement.setString(1, post.getContent());
			preparedStatement.setInt(2, post.getUser().getId());
			
			preparedStatement.executeUpdate();
			//int rowsAfected = preparedStatement.executeUpdate();
			
			//System.out.println(rowsAfected > 0 ? 
			//		"Post inserido com sucesso" : "Erro ao inserir post");
		} catch (SQLException sqle) {
			SQLExceptionTreatement(sqle, "Erro ao inserir post do BD.");
		} catch (ModelException me) {
			throw me;
		} finally {
			if (preparedStatement != null)
				try {
					preparedStatement.close();
				} catch (SQLException e) {
				}
			
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
				}
		}
	}

	@Override
	public void update(Post post) throws ModelException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = MySQLConnectionFactory.getConnection();
			
			String sqlUpdate = " UPDATE posts "
					+ " SET "
					+ " content = ?, "
					+ " post_date = CURDATE() "
					+ " WHERE id = ?; ";
			
			preparedStatement = connection.prepareStatement(sqlUpdate);
			preparedStatement.setString(1, post.getContent());
			preparedStatement.setInt(2, post.getId());
			
			int rowsAfected = preparedStatement.executeUpdate();
			
			System.out.println(rowsAfected > 0 ? 
					"Post atualizado com sucesso" : 
						"Erro ao atualizar post");
			
		} catch (SQLException sqle) {
			SQLExceptionTreatement(sqle, "Erro ao update post do BD.");
		} catch (ModelException me) {
			throw me;
		} finally {
			close(preparedStatement);
			close(connection);
		}
		
	}

	@Override
	public void delete(Post post) throws ModelException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			// Estabelecimento da conexão com o BD
			connection = MySQLConnectionFactory.getConnection();

			String sqlDelete = "delete from posts where id = ?;";

			preparedStatement = connection.prepareStatement(sqlDelete);
			preparedStatement.setInt(1, post.getId());
			preparedStatement.executeUpdate();
			//int rowsAfected = preparedStatement.executeUpdate();
			//String message = rowsAfected > 0 ? "Deletado com sucesso" 
			//		: "Post não existe";
		} catch (SQLException sqle) {
			SQLExceptionTreatement(sqle, "Erro ao excluir post do BD.");
		} catch (ModelException me) {
			throw me;
		} finally {
			close(preparedStatement);
			close(connection);
		}

		
	}

	@Override
	public List<Post> findAll() throws ModelException {
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		List<Post> postsList = new ArrayList<Post>();
		try {
			connection = MySQLConnectionFactory.getConnection();

			statement = connection.createStatement();
			
			String sqlSeletc = "SELECT * FROM posts;";

			rs = statement.executeQuery(sqlSeletc);
			
			while (rs.next()) {
				int postId = rs.getInt("id");
				String postContent = rs.getString("content");
				Date postDate = rs.getDate("post_date");
				int userId = rs.getInt("user_id");

				Post newPost = new Post(postId);
				newPost.setContent(postContent);
				newPost.setDate(postDate);
				
				User postUser = new User(userId);
				newPost.setUser(postUser);
				postsList.add(newPost);
			}
		} catch (SQLException sqle) {
			SQLExceptionTreatement(sqle, "Erro ao listar post do BD.");
		} catch (ModelException me) {
			throw me;
		} finally {
			close(rs);
			close(statement);
			close(connection);
		}
		return postsList;
	}
	
	private void close(AutoCloseable resource) throws ModelException {
		if(resource != null) {
			try {
				resource.close();
			}catch(Exception e) {
				throw new ModelException("Erro ao fechar recurso: "+resource);
			}
		}
	}
	
	private void SQLExceptionTreatement(SQLException sqle, String errorMessage) throws ModelException {
		if (sqle.getCause() != null)
			if (sqle.getCause().getCause() != null)
				if (sqle.getCause().getCause() 
						instanceof ConnectException) {
					throw new ModelException("Banco de dados fora do ar.", sqle.getCause().getCause());
				}
		throw new ModelException(errorMessage, sqle);
	}
	
}
