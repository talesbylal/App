package com.ekip.sb.App.service;

import com.ekip.sb.App.enums.CandidateStatus;
import com.ekip.sb.App.exceptions.ResourceNotFoundException;
import com.ekip.sb.App.model.Candidate;
import com.ekip.sb.App.repo.CandidateRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CandidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    public List<Candidate> getAllCandidates() {
        return candidateRepository.findAll();
    }

    public Candidate getCandidateById(Long id) {
        return candidateRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id.toString()));
    }

    public Candidate createCandidate(Candidate candidate) {
        return candidateRepository.save(candidate);
    }

    public Candidate updateCandidate(Long id, Candidate candidate) {
        Candidate existingCandidate = candidateRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id.toString()));
        existingCandidate.setFullName(candidate.getFullName());
        existingCandidate.setEmail(candidate.getEmail());
        existingCandidate.setStatus(candidate.getStatus());
        return candidateRepository.save(existingCandidate);
    }

    public void deleteCandidate(Long id) {
        Candidate candidate = candidateRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id.toString()));
        candidateRepository.delete(candidate);
    }

    public Candidate changeCandidateStatus(Long id, String newStatus) {
        Candidate candidate = candidateRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id.toString()));
        candidate.setStatus(CandidateStatus.valueOf(newStatus.toUpperCase()));
        return candidateRepository.save(candidate);
    }

    @PostConstruct
    public void init() {
        Candidate candidate1 = new Candidate();
        candidate1.setFullName("John Doe");
        candidate1.setEmail("johndoe@example.com");
        candidate1.setStatus(CandidateStatus.APPLIED);

        Candidate candidate2 = new Candidate();
        candidate2.setFullName("Jane Smith");
        candidate2.setEmail("janesmith@example.com");
        candidate2.setStatus(CandidateStatus.INTERVIEW);

        Candidate candidate3 = new Candidate();
        candidate3.setFullName("Alice Johnson");
        candidate3.setEmail("alicejohnson@example.com");
        candidate3.setStatus(CandidateStatus.REJECTED);

        candidateRepository.saveAll(Arrays.asList(candidate1, candidate2, candidate3));
    }
}
