package com.cbo.audit.controller;

import com.cbo.audit.constants.URIs;
import com.cbo.audit.dto.ChecklistItemDTO;
import com.cbo.audit.dto.ResultWrapper;
import com.cbo.audit.service.ChecklistItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ChecklistItemController {

    @Autowired
    ChecklistItemService checklistItemService;

    @PostMapping(value = URIs.CHECKLIST_ITEM_REGISTER, consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultWrapper<ChecklistItemDTO>> checklistItemRegister(@RequestBody ChecklistItemDTO checklistItemDTO){

        ResultWrapper<ChecklistItemDTO> resultWrapper=checklistItemService.registerChecklistItem(checklistItemDTO);

        return new ResponseEntity<>(resultWrapper, HttpStatus.OK);
    }

    @GetMapping(value = URIs.CHECKLIST_ITEM_LIST_ALL,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultWrapper<List<ChecklistItemDTO>>> listAllChecklistItem(){

        ResultWrapper<List<ChecklistItemDTO>> resultWrapper=checklistItemService.getAllChecklistItem();

        return new ResponseEntity<>(resultWrapper, HttpStatus.OK);
    }

    @GetMapping(value = URIs.CHECKLIST_ITEM_BY_AAR,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultWrapper<List<ChecklistItemDTO>>> getChecklistItemByAuditableAreaId(@Param("") Long auditUniverseId){

        ResultWrapper<List<ChecklistItemDTO>> resultWrapper=checklistItemService.getChecklistItemByAuditableAreaId(auditUniverseId);

        return new ResponseEntity<>(resultWrapper, HttpStatus.OK);
    }

/*    @GetMapping(value = URIs.CHECKLIST_ITEM_BY_AOBJ,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultWrapper<List<ChecklistItemDTO>>> listAllChecklistItem(@Param("") Long objectId){

        ResultWrapper<List<ChecklistItemDTO>> resultWrapper=checklistItemService.getChecklistItemByAuditObjectId(objectId);

        return new ResponseEntity<>(resultWrapper, HttpStatus.OK);
    }*/
    @GetMapping(value = URIs.CHECKLIST_ITEM_BY_ID,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultWrapper<ChecklistItemDTO>> getChecklistItemById(@PathVariable(name = "id") Long id){

        ResultWrapper<ChecklistItemDTO> resultWrapper=checklistItemService.getChecklistItemById(id);

        return new ResponseEntity<>(resultWrapper, HttpStatus.OK);
    }

    @PostMapping(value = URIs.CHECKLIST_ITEM_UPDATE, consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultWrapper<ChecklistItemDTO>> updateChecklistItem(@RequestBody ChecklistItemDTO checklistItemDTO){

        ResultWrapper<ChecklistItemDTO> resultWrapper=checklistItemService.updateChecklistItem(checklistItemDTO);

        return new ResponseEntity<>(resultWrapper, HttpStatus.OK);
    }


}
