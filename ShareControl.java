package jsoft;

public interface ShareControl {
	// Phương thức chia sẻ bộ quản lý kết nối giữa các Basic với nhau
	public ConnectionPool getCP();

	// Phương thức yêu cầu các đối tượng phải trả lại kết nối khi xong
	public void releaseConnection();
}
