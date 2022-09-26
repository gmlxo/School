package vo;

public class BookVO {
	private int bookNo;
	String title;
	String author;
	String company;
	int price;
	String rentaled;

	public BookVO() {
		super();
	}

	public int getBookNo() {
		return bookNo;
	}

	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getRentaled() {
		return rentaled;
	}

	public void setRentaled(String rentaled) {
		this.rentaled = rentaled;
	}
}
