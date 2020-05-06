package acres.dto;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.stereotype.Indexed;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamicInsert
@DynamicUpdate
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Document(indexName = "properties")
@Indexed
public class BuildingInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@org.springframework.data.annotation.Id
	String buildingId;
	String propertyList;			//Sell, Rent
	String propertyType;			//Commercial, Residential
	
	//For all options
	String address;					//House Number and Street Name	(required)
	String city;					//								(required)
	String state;					//								(required)
	String projectName;				//								(Not required)
	String description;				//Description for building
	
	//For all options minus balconyNum for Commercial buildings
	double plotArea;				//Total measured area where property stands (Required)
	String roomNum;					//# of rooms
	String washroomNum;				//# of bathrooms
	
	String ownership;				//For commercial buildings: Freehold, leasehold, Power of Attorney, Cooperative Society
	
	String availability;			//Under Construction, Ready to Move, New Construction
	String possessionBy;			//Time til ownership
	String ageOfProperty;			//For Ready to Move: 0-1 year old, 2-3 year old etc...
	
	float expectedRent;				//For rent/lease
	float expectedPrice;			//For sell
	
	//Residential Information
	String reBuildingType;			//Apartment/Flat/BuilderFloor, Residential Land, House/Villa, Others
	String apartmentType;			//Studio, Residential, Serviced Apartments, Independent
	String houseType;				//Independent, Farm House
	
	//Commercial Information
	String comBuildingType;			//Offices, Retail, Land, Industry Storage, Hospitality, Others
	String officeType;				//Commercial, Office in IT Park, Office in Business Park, Business Center, Time Share
	String retailType;				//Commercial Shop, Commercial Showroom, Space in retail mall
	String landType;				//Commercial Land, Agricultural Land, Industrial Lands
	String storageType;				//Ware House, Cold Storage
	String hospitalityType;			//Hotel/Resorts, Guest-house/Banquet halls
	
	
	boolean multipleProperty;		//Option for all commercial options
	
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	LocalDate postedDate;
	
	@ElementCollection
	List<String> imageUrls;
	
	@ElementCollection
	List<String> amenities;
	
	@ManyToOne
	UserInfo user;
	
	public BuildingInfo(String propertyList, String propertyType, String address, String city, String state,
			String projectName, String description, String ageOfProperty, float expectedRent) {
		super();
		this.propertyList = propertyList;
		this.propertyType = propertyType;
		this.address = address;
		this.city = city;
		this.state = state;
		this.projectName = projectName;
		this.description = description;
		this.ageOfProperty = ageOfProperty;
		this.expectedRent = expectedRent;
	}
}
