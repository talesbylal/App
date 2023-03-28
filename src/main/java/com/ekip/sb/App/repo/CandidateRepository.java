package com.ekip.sb.App.repo;

import com.ekip.sb.App.enums.CandidateStatus;
import com.ekip.sb.App.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {

    List<Candidate> findByStatus(CandidateStatus status);
}
