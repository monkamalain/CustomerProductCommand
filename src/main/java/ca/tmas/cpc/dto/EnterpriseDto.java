package ca.tmas.cpc.dto;

import ca.tmas.cpc.model.Address;
import ca.tmas.cpc.model.Employee;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class EnterpriseDto {

    String refEnterprise;

    String enterpriseName;

    Address address;

    String phoneNumber;

    List<Employee> employeeList;

}
