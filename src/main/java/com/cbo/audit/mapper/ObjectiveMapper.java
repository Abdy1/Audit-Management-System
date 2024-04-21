//package com.cbo.audit.mapper;
//
//import com.cbo.audit.dto.AuditProgramDTO;
//import com.cbo.audit.dto.ObjectiveDTO;
//import com.cbo.audit.persistence.model.AuditProgram;
//import com.cbo.audit.persistence.model.Objective;
//import org.mapstruct.Mapper;
//import org.mapstruct.MappingTarget;
//import org.mapstruct.factory.Mappers;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Mapper(componentModel = "spring")
//public interface ObjectiveMapper {
//    ObjectiveMapper INSTANCE = Mappers.getMapper(ObjectiveMapper.class);
//
//    ObjectiveDTO toDTO(Objective objective);
//
//    void copyToDTO(Objective objective, @MappingTarget ObjectiveDTO objectiveDTO);
//
//    Objective toEntity(ObjectiveDTO objectiveDTO);
//
//    default List<ObjectiveDTO> objectivesToObjectiveDTOs(List<Objective> objectives) {
//        if (objectives == null) {
//            return null;
//        }
//
//        List<ObjectiveDTO> list = new ArrayList<ObjectiveDTO>(objectives.size());
//        for (Objective objective : objectives) {
//            list.add(toDTO(objective));
//        }
//
//        return list;
//    }
//}
