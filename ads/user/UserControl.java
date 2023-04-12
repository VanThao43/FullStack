package jsoft.ads.user;

import jsoft.*;
import jsoft.objects.*;
import java.util.*;
import org.javatuples.*;

public class UserControl {
	private UserModel um;

	public UserControl(ConnectionPool cp) {
		this.um = new UserModel(cp);
	}

	protected void finallize() throws Throwable {
		this.um = null;
	}

	
	
	// **************************************************************************
	public boolean addUser(UserObject item) {
		return this.um.addUser(item);
	}

	public boolean editUser(UserObject item) {
		return this.um.editUser(item);
	}

	public boolean delUser(UserObject item) {
		return this.um.delUser(item);
	}
	// ***************************************************************************
	
	
	
	// ***************************************************************************
	public UserObject getUserObject(int id) {
		return this.um.getUserObject(id);
	}
	
	public UserObject getUserObject(String username, String userpass) {
		return this.um.getUserObject(username, userpass);
	}
	
	// ***************************************************************************
	
	
	
	public Pair<String, String> viewUsers(Triplet<UserObject, Short, Byte> infos) {
		// Lấy danh sách đối tượng
		ArrayList<UserObject> items = this.um.getUserObjects(infos.getValue0(), infos.getValue1(), infos.getValue2());
		
		return UserLibrary.viewUsers(items);
	}
	
	public static void main(String[] args) {
		ConnectionPool cp = new ConnectionPoolImpl();
		
		//Tạo đối tượng thực thi chức năng mức control
		UserControl uc = new UserControl(cp);
		
		
		//Giả lập thông tin
		Triplet<UserObject, Short, Byte> infos = new Triplet<>(null, (short)1, (byte)15);
		
		
		
		//Lấy cấu trúc trình bày view
		Pair<String, String> view = uc.viewUsers(infos);
		
		
		//Hiển thị màn hình ảo
		System.out.println(view.getValue0());

	}
}
