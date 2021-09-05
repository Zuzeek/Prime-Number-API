package ag.demo.api;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data 
@Table(name = "numbers")
public class NumberModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id; 
	
	@Column
	private int number;

	public NumberModel(int number) {
		this.number = number;
	} 
}
