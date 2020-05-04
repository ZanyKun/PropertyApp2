package acres.dto;

import javax.persistence.Entity;

import org.hibernate.annotations.DynamicInsert;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@DynamicInsert
public class ReBuildingType extends BuildingInfo{
	String reBuildingType;			//Apartment/Flat/BuilderFloor, Residential Land, House/Villa, Others
	
	String apartmentType;			//Studio, Residential, Serviced Apartments, Independent
	String houseType;				//Independent, Farm House
}
