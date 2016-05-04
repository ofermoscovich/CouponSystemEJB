package entityDB;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 * @author Ofer
 *		=== This PK class not in use. See Income class ===
 */
@Embeddable
public class IncomePK implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private long id;
	private String name;

	/**
	 * Constructor - with init
	 * @param id long - customer or company
	 * @param name String- name of customer or company
	 */
	public IncomePK(long id, String name) {
		this.id = id;
		this.name = name;
	}

	/**
	 * Constructor - empty
	 */
	public IncomePK() {}

	@Override
	public int hashCode() {
		return (int) (name.hashCode() + id);
	}
	
	@Override
	public boolean equals (Object o) {
		if (o instanceof IncomePK)
			if (((IncomePK)o).name.equals(this.name) && 
				((IncomePK)o).id==this.id)
				return true;
			return false;
	}

	@Id
	@Column//(name="ID")
	public long getId() {return id;}
	public void setId(long id) {this.id = id;}
	
	@Id
	@Column//(name="NAME")
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	
}
