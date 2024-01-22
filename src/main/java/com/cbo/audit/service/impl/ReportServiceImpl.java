package com.cbo.audit.service.impl;

import com.cbo.audit.dto.AuditScheduleDTO;
import com.cbo.audit.dto.ReportDTO;
import com.cbo.audit.mapper.ReportMapper;
import com.cbo.audit.persistence.model.*;
import com.cbo.audit.persistence.repository.*;
import com.cbo.audit.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

public class ReportServiceImpl implements ReportService
{
    @Autowired
    private ReportRepository reportRepository;
    @Autowired
    private EngagementInfoRepository engagementInfoRepository;
    @Autowired
    private AuditProgramRepository auditProgramRepository;
    @Autowired
    private FindingRepository auditProgramFindingRepository;
    @Autowired
    private AuditProgramObjectiveRepository auditProgramObjectiveRepository;

    public ReportDTO generateDefaultReport(AuditScheduleDTO auditScheduleDTO) {
        EngagementInfo engagementInfo = engagementInfoRepository.findAuditEngagementBySchedule(auditScheduleDTO.getId());
        List<AuditProgram> auditPrograms=auditProgramRepository.getAllAuditProgramByEngagementId(engagementInfo.getId());
        List<Finding> findings=new List<Finding>() {


            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<Finding> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(Finding finding) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends Finding> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, Collection<? extends Finding> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public Finding get(int index) {
                return null;
            }

            @Override
            public Finding set(int index, Finding element) {
                return null;
            }

            @Override
            public void add(int index, Finding element) {

            }

            @Override
            public Finding remove(int index) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator<Finding> listIterator() {
                return null;
            }

            @Override
            public ListIterator<Finding> listIterator(int index) {
                return null;
            }

            @Override
            public List<Finding> subList(int fromIndex, int toIndex) {
                return null;
            }
        } ;
        for(AuditProgram auditProgram:auditPrograms) {
            findings.addAll(auditProgramFindingRepository.findFindingByAuditProgramId(auditProgram.getId()));
        }
        List<AuditProgramObjective> objectives=  new List<AuditProgramObjective>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<AuditProgramObjective> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(AuditProgramObjective auditProgramObjective) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends AuditProgramObjective> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, Collection<? extends AuditProgramObjective> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public AuditProgramObjective get(int index) {
                return null;
            }

            @Override
            public AuditProgramObjective set(int index, AuditProgramObjective element) {
                return null;
            }

            @Override
            public void add(int index, AuditProgramObjective element) {

            }

            @Override
            public AuditProgramObjective remove(int index) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator<AuditProgramObjective> listIterator() {
                return null;
            }

            @Override
            public ListIterator<AuditProgramObjective> listIterator(int index) {
                return null;
            }

            @Override
            public List<AuditProgramObjective> subList(int fromIndex, int toIndex) {
                return null;
            }
        };
        for(AuditProgram auditProgram:auditPrograms){
            objectives.addAll(auditProgramObjectiveRepository.findAllObjectiveByAuditProgramId(auditProgram.getId()));
        }






        return null;

    }
}
