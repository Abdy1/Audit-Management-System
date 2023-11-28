package com.cbo.audit.mapper;

import com.cbo.audit.dto.AuditStaffDTO;
import com.cbo.audit.dto.AuditTypeDTO;
import com.cbo.audit.dto.EmployeeDTO;
import com.cbo.audit.dto.TeamMemberDTO;
import com.cbo.audit.dto.UserDTO;
import com.cbo.audit.persistence.model.AuditStaff;
import com.cbo.audit.persistence.model.AuditType;
import com.cbo.audit.persistence.model.Employee;
import com.cbo.audit.persistence.model.TeamMember;
import com.cbo.audit.persistence.model.User;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-27T15:46:35+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.8 (Oracle Corporation)"
)
@Component
public class TeamMemberMapperImpl implements TeamMemberMapper {

    @Override
    public TeamMemberDTO toDTO(TeamMember teamMember) {
        if ( teamMember == null ) {
            return null;
        }

        TeamMemberDTO teamMemberDTO = new TeamMemberDTO();

        teamMemberDTO.setAuditStaffDTO( auditStaffToAuditStaffDTO( teamMember.getAuditStaff() ) );
        teamMemberDTO.setId( teamMember.getId() );
        teamMemberDTO.setCreatedUser( teamMember.getCreatedUser() );
        teamMemberDTO.setModifiedUser( teamMember.getModifiedUser() );
        teamMemberDTO.setCreatedTimestamp( teamMember.getCreatedTimestamp() );
        teamMemberDTO.setModifiedTimestamp( teamMember.getModifiedTimestamp() );
        teamMemberDTO.setStatus( teamMember.getStatus() );
        teamMemberDTO.setTeamRole( teamMember.getTeamRole() );
        teamMemberDTO.setAuditStatus( teamMember.getAuditStatus() );
        teamMemberDTO.setPerdium( teamMember.getPerdium() );

        return teamMemberDTO;
    }

    @Override
    public void copyToDTO(TeamMember teamMember, TeamMemberDTO teamMemberDTO) {
        if ( teamMember == null ) {
            return;
        }

        teamMemberDTO.setId( teamMember.getId() );
        teamMemberDTO.setCreatedUser( teamMember.getCreatedUser() );
        teamMemberDTO.setModifiedUser( teamMember.getModifiedUser() );
        teamMemberDTO.setCreatedTimestamp( teamMember.getCreatedTimestamp() );
        teamMemberDTO.setModifiedTimestamp( teamMember.getModifiedTimestamp() );
        teamMemberDTO.setStatus( teamMember.getStatus() );
        teamMemberDTO.setTeamRole( teamMember.getTeamRole() );
        teamMemberDTO.setAuditStatus( teamMember.getAuditStatus() );
        teamMemberDTO.setPerdium( teamMember.getPerdium() );
    }

    @Override
    public TeamMember toEntity(TeamMemberDTO teamMemberDTO) {
        if ( teamMemberDTO == null ) {
            return null;
        }

        TeamMember teamMember = new TeamMember();

        teamMember.setAuditStaff( auditStaffDTOToAuditStaff( teamMemberDTO.getAuditStaffDTO() ) );
        teamMember.setId( teamMemberDTO.getId() );
        teamMember.setCreatedUser( teamMemberDTO.getCreatedUser() );
        teamMember.setModifiedUser( teamMemberDTO.getModifiedUser() );
        teamMember.setCreatedTimestamp( teamMemberDTO.getCreatedTimestamp() );
        teamMember.setModifiedTimestamp( teamMemberDTO.getModifiedTimestamp() );
        teamMember.setStatus( teamMemberDTO.getStatus() );
        teamMember.setTeamRole( teamMemberDTO.getTeamRole() );
        teamMember.setAuditStatus( teamMemberDTO.getAuditStatus() );
        teamMember.setPerdium( teamMemberDTO.getPerdium() );

        return teamMember;
    }

    protected AuditTypeDTO auditTypeToAuditTypeDTO(AuditType auditType) {
        if ( auditType == null ) {
            return null;
        }

        AuditTypeDTO auditTypeDTO = new AuditTypeDTO();

        auditTypeDTO.setId( auditType.getId() );
        auditTypeDTO.setCreatedUser( auditType.getCreatedUser() );
        auditTypeDTO.setModifiedUser( auditType.getModifiedUser() );
        auditTypeDTO.setCreatedTimestamp( auditType.getCreatedTimestamp() );
        auditTypeDTO.setModifiedTimestamp( auditType.getModifiedTimestamp() );
        auditTypeDTO.setName( auditType.getName() );
        auditTypeDTO.setDescription( auditType.getDescription() );

        return auditTypeDTO;
    }

    protected EmployeeDTO employeeToEmployeeDTO(Employee employee) {
        if ( employee == null ) {
            return null;
        }

        EmployeeDTO employeeDTO = new EmployeeDTO();

        employeeDTO.setId( employee.getId() );
        employeeDTO.setEmployeeId( employee.getEmployeeId() );
        employeeDTO.setFullName( employee.getFullName() );
        employeeDTO.setJobTitle( employee.getJobTitle() );
        employeeDTO.setPhoneNumber( employee.getPhoneNumber() );
        employeeDTO.setPersonalEmail( employee.getPersonalEmail() );
        employeeDTO.setCompanyEmail( employee.getCompanyEmail() );
        employeeDTO.setGender( employee.getGender() );
        employeeDTO.setBirthDate( employee.getBirthDate() );
        employeeDTO.setEmployeeImage( employee.getEmployeeImage() );
        employeeDTO.setSignatureImage( employee.getSignatureImage() );
        employeeDTO.setActive( employee.getActive() );

        return employeeDTO;
    }

    protected UserDTO userToUserDTO(User user) {
        if ( user == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setId( user.getId() );
        userDTO.setCreatedUser( user.getCreatedUser() );
        userDTO.setModifiedUser( user.getModifiedUser() );
        userDTO.setCreatedTimestamp( user.getCreatedTimestamp() );
        userDTO.setModifiedTimestamp( user.getModifiedTimestamp() );
        userDTO.setUsername( user.getUsername() );
        userDTO.setPassword( user.getPassword() );
        userDTO.setActive( user.getActive() );
        userDTO.setEmployee( employeeToEmployeeDTO( user.getEmployee() ) );

        return userDTO;
    }

    protected AuditStaffDTO auditStaffToAuditStaffDTO(AuditStaff auditStaff) {
        if ( auditStaff == null ) {
            return null;
        }

        AuditStaffDTO auditStaffDTO = new AuditStaffDTO();

        auditStaffDTO.setId( auditStaff.getId() );
        auditStaffDTO.setCreatedUser( auditStaff.getCreatedUser() );
        auditStaffDTO.setModifiedUser( auditStaff.getModifiedUser() );
        auditStaffDTO.setCreatedTimestamp( auditStaff.getCreatedTimestamp() );
        auditStaffDTO.setModifiedTimestamp( auditStaff.getModifiedTimestamp() );
        auditStaffDTO.setAuditType( auditTypeToAuditTypeDTO( auditStaff.getAuditType() ) );
        auditStaffDTO.setUser( userToUserDTO( auditStaff.getUser() ) );
        auditStaffDTO.setStatus( auditStaff.getStatus() );

        return auditStaffDTO;
    }

    protected AuditType auditTypeDTOToAuditType(AuditTypeDTO auditTypeDTO) {
        if ( auditTypeDTO == null ) {
            return null;
        }

        AuditType auditType = new AuditType();

        auditType.setId( auditTypeDTO.getId() );
        auditType.setCreatedUser( auditTypeDTO.getCreatedUser() );
        auditType.setModifiedUser( auditTypeDTO.getModifiedUser() );
        auditType.setCreatedTimestamp( auditTypeDTO.getCreatedTimestamp() );
        auditType.setModifiedTimestamp( auditTypeDTO.getModifiedTimestamp() );
        auditType.setName( auditTypeDTO.getName() );
        auditType.setDescription( auditTypeDTO.getDescription() );

        return auditType;
    }

    protected Employee employeeDTOToEmployee(EmployeeDTO employeeDTO) {
        if ( employeeDTO == null ) {
            return null;
        }

        Employee employee = new Employee();

        employee.setId( employeeDTO.getId() );
        employee.setEmployeeId( employeeDTO.getEmployeeId() );
        employee.setFullName( employeeDTO.getFullName() );
        employee.setJobTitle( employeeDTO.getJobTitle() );
        employee.setPhoneNumber( employeeDTO.getPhoneNumber() );
        employee.setPersonalEmail( employeeDTO.getPersonalEmail() );
        employee.setCompanyEmail( employeeDTO.getCompanyEmail() );
        employee.setGender( employeeDTO.getGender() );
        employee.setBirthDate( employeeDTO.getBirthDate() );
        employee.setEmployeeImage( employeeDTO.getEmployeeImage() );
        employee.setSignatureImage( employeeDTO.getSignatureImage() );
        employee.setActive( employeeDTO.getActive() );

        return employee;
    }

    protected User userDTOToUser(UserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        User user = new User();

        user.setId( userDTO.getId() );
        user.setCreatedUser( userDTO.getCreatedUser() );
        user.setModifiedUser( userDTO.getModifiedUser() );
        user.setCreatedTimestamp( userDTO.getCreatedTimestamp() );
        user.setModifiedTimestamp( userDTO.getModifiedTimestamp() );
        user.setUsername( userDTO.getUsername() );
        user.setPassword( userDTO.getPassword() );
        user.setActive( userDTO.getActive() );
        user.setEmployee( employeeDTOToEmployee( userDTO.getEmployee() ) );

        return user;
    }

    protected AuditStaff auditStaffDTOToAuditStaff(AuditStaffDTO auditStaffDTO) {
        if ( auditStaffDTO == null ) {
            return null;
        }

        AuditStaff auditStaff = new AuditStaff();

        auditStaff.setId( auditStaffDTO.getId() );
        auditStaff.setCreatedUser( auditStaffDTO.getCreatedUser() );
        auditStaff.setModifiedUser( auditStaffDTO.getModifiedUser() );
        auditStaff.setCreatedTimestamp( auditStaffDTO.getCreatedTimestamp() );
        auditStaff.setModifiedTimestamp( auditStaffDTO.getModifiedTimestamp() );
        auditStaff.setAuditType( auditTypeDTOToAuditType( auditStaffDTO.getAuditType() ) );
        auditStaff.setUser( userDTOToUser( auditStaffDTO.getUser() ) );
        auditStaff.setStatus( auditStaffDTO.getStatus() );

        return auditStaff;
    }
}
