import java.util.Comparator;
import java.util.TreeSet;

public class LibraryRecords implements Comparable<Boook> {
	int book_id;
	String title, author;
	
	public Boook(int book_id, String title, String author){
		this.book_id=book_id;
		this.author=author;
		this.title=title;
	}
	
	void setData(int book_id, String title, String author){
		this.book_id=book_id;
		this.author=author;
		this.title=title;
	}
	
	public String getTitle(){
		return title;
	}
	
	public int getId(){
		return book_id;
	}
	
	public String getAuthor(){
		return author;
	}
	
	public int compareTo(Boook b){
		if(this.book_id >b.book_id)
			return 1;
		else if(this.book_id<b.book_id)
			return -1;
		else
			return 0;
	}
	
	public void display(){
		System.out.println("BOOK ID: " + book_id + "\tTITLE: "+title+"\tAUTHOR: "+author);
	}
	
	public static void main(String[] args) {
		Boook b1 = new Boook(20846, "The Theory of Relativity", "Albert Eintsien");
		Boook b2 = new Boook(65626, "The Lean Startups", "Eric Ries");
		Boook b3 = new Boook(20999, "Leadership Wisdom", "Robin Sharma");
		
		TreeSet<Boook> t1 = new TreeSet<>();
		t1.add(b1);
		t1.add(b3);
		t1.add(b2);
		System.out.println("Sorting on ID:");
		for(Boook b:t1)
			b.display();
		System.out.println();
		TreeSet<Boook> t2 = new TreeSet<>(new TitleComparator());
		t2.add(b2);
		t2.add(b1);
		t2.add(b3);
		System.out.println("Sorting on Title:");
		for(Boook b:t2)
			b.display();
		System.out.println();
		TreeSet<Boook> t3 = new TreeSet<>(new AuthorLastNameComparator());
		t3.add(b3);
		t3.add(b2);
		t3.add(b1);
		System.out.println("Sorting on last name of Author:");
		for(Boook b:t3)
			b.display();
	}
}

class TitleComparator implements Comparator<Boook> {
	public int compare(Boook b1, Boook b2) {
		return (b1.title.compareTo(b2.title));
	}
}

class AuthorLastNameComparator implements Comparator<Boook> {
	public int compare(Boook b1, Boook b2) {
			if (b1.author.substring(b1.author.lastIndexOf(" ")).equals(b2.author.substring(b2.author.lastIndexOf(" ")))) {
					if(b1.author.equals(b2.author))
						return(b1.title.compareTo(b2.title));
					else
						return(b1.author.compareTo(b2.author));
			}
			else
				return (b1.author.substring(b1.author.lastIndexOf(" ")).compareTo(b2.author.substring(b2.author.lastIndexOf(" "))));
		}
	}
