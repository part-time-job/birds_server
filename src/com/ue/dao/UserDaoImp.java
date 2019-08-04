package com.ue.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.ue.dao.CommentDaoImp.PageNum;
import com.ue.domain.User;
import com.ue.domain.User3;
import com.ue.utils.LogUtils;

@SuppressWarnings("unchecked")
public class UserDaoImp implements UserDao {

	private static final long serialVersionUID = 1L;

	private JdbcTemplate template;

	public static final String INSERT = "insert into User(name,sex) values(?,?)";

	public static final String DELETEBYID = "delete from User where id=?";
	public static final String DELETEBYNAME = "delete from User where name=?";

	public static final String UPDATEBYID = "update User set name=?,sex=? where id=?";
	public static final String UPDATEBYNAME = "update User set sex=? where name=?";

	public static final String SEARCHBYID = "select * from User where id=?";
	public static final String SEARCHBYNAME = "select * from User where name=?";
	public static final String GETALL = "select * from User";

	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	@Override
	public boolean insertUser(User user) {
		String sql = "insert into tb_user (" + "use_phone, " + "use_name, " + "use_password, " + "use_sex, "
				+ "use_birthday, " + "use_imageurl, " + "use_mail, " + "use_positivecount, " + "use_introduction, "
				+ "use_remark " + ") values (?,?,?,?,?,?,?,?,?,?)";
		LogUtils.sysoln(sql);
		int res = this.template.update(sql, user.getUse_phone(), user.getUse_name(), user.getUse_password(),
				user.getUse_sex(), user.getUse_birthday(), user.getUse_imageurl(), user.getUse_mail(),
				user.getUse_positivecount(), user.getUse_introduction(), user.getUse_remark());

		return res > 0;
	}

	@Override
	public boolean deleteUserById(int tagId) {
		// TODO Auto-generated method stub
		int res = this.template.update(DELETEBYID, tagId);
		System.out.println("res:" + res);
		return res > 0;
	}

	@Override
	public boolean deleteUserByName(String tagName) {
		int res = this.template.update(DELETEBYNAME, tagName);
		return res > 0;
	}

	@Override
	public boolean updateUserById(int use_id, User user) {
		String sql = "update tb_user set use_phone=?,use_name=?,use_password=?,"
				+ "use_sex=?,use_birthday=?,use_imageurl=?,use_mail=?,"
				+ "use_positivecount=?, use_introduction=?,use_remark=? "
				+ "where use_id=?";
		LogUtils.sysoln(sql);
		int res = this.template.update(sql, user.getUse_phone(), user.getUse_name(), user.getUse_password(),
				user.getUse_sex(), user.getUse_birthday(), user.getUse_imageurl(), user.getUse_mail(),
				user.getUse_positivecount(), user.getUse_introduction(), user.getUse_remark(),use_id);

		return res > 0;
	}


	@Override
	public User searchUserById(int use_id) {

		String sql = " select * from tb_user where use_id = ? ";

		List<User> list = this.template.query(sql, new Integer[] { use_id },
				new BeanPropertyRowMapper<User>(User.class));
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;

	}

	@Override
	public User searchUserByPhone(String use_phone) {
		String sql = " select * from tb_user where use_phone = ? ";
		List<User> list = this.template.query(sql, new String[] { use_phone },
				new BeanPropertyRowMapper<User>(User.class));
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public User MapToObject(Map<String, Object> map) {
		int id = Integer.parseInt(map.get("id").toString());
		User user = new User();
		return user;
	}
	
	
	@SuppressWarnings("rawtypes")
	class UserRowMapper implements RowMapper {
		public Object mapRow(ResultSet rs, int index) throws SQLException {
			User3 user = new User3();
			user.setId(rs.getInt("id"));
			user.setName(rs.getString("name"));
			user.setSex(rs.getString("sex"));
			return user;
		}
	}
	
	@Override
	public int getUserCount() {
		List<Integer> ii = this.template.query("select count(*) from tb_user", new userCount());
		if(ii == null){
			return 0;
		}
		return ii.get(0);
	}
	
	@SuppressWarnings("rawtypes")
	class userCount implements RowMapper {  
        public Object mapRow(ResultSet rs, int index) throws SQLException {
        	return rs.getInt(1);
        }  
    }

}
