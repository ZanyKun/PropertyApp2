package acres.dto;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.context.annotation.Scope;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("deprecation")
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
@DynamicUpdate
@Document(indexName = "users")
@Scope("session")
public class UserInfo{

	
	@javax.persistence.Id
	@Id
	@NotEmpty(message = "Username is required")
	@Size(min = 6, message = "Username has to be at least 6 characters")
	String username;
//	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.{6,})", message = "Password must be at least 6 characters long and contain one lowercase letter, one uppercase letter and one number")
	String password1;
	@NotEmpty(message = "Name is required")
	String name;
	@Pattern(regexp = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$", 
			message = "Email must follow the following format: XXXXXXX@XXXX.com")
	String email;
	@Pattern(regexp = "[1-9]{1}[0-9]{2}-[0-9]{3}-[0-9]{4}" ,message = "Phone number cannot begin with 0 and must be provided in the following format: XXX-XXX-XXXX")
	String phoneNum;
	
	@ElementCollection(fetch = FetchType.EAGER)
	List<String> userType;
	
	@OneToMany(mappedBy = "user")
	List<BuildingInfo> buildingList;	//List of building listings
}
