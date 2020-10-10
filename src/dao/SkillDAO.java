package dao;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Skill;
import utility.ConnectionManager;

public class SkillDAO {

	List<String> list = new ArrayList<String>();

	ConnectionManager cm = new ConnectionManager();

	public List<String> listAllSkills() throws IOException, ClassNotFoundException {

		String sql = "Select name from skill order by name asc";

		try {
			Statement st = cm.getConnection().createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {

				String s = rs.getString(1);
				list.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	public void setSkill(Skill s) throws SQLException, IOException, ClassNotFoundException {

		long id = s.getSkillId();
		String name = s.getSkillName();

		String sql = "Insert into skill(id,name) values (?,?)";

		PreparedStatement st = cm.getConnection().prepareStatement(sql);
		st.setLong(1, id);
		st.setString(2, name);

		st.executeUpdate();
		cm.getConnection().close();

	}
}
