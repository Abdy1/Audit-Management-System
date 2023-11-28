package com.cbo.audit.persistence.repository;

import com.cbo.audit.persistence.model.Finding;
import com.cbo.audit.persistence.model.FindingComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface FindingCommentRepository extends JpaRepository<FindingComment,Long> {

    List<FindingComment> findFindingCommentByFindingId(Long finding_id);
}
