package com.exam01.Service;

import com.exam01.Entity.Doctor;
import com.exam01.Repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {
    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public Doctor addDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
    }

    public Doctor updateDoctor(Long id, Doctor doctor) {
        Doctor existing = doctorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));

        existing.setDoctorCode(doctor.getDoctorCode());
        existing.setFullName(doctor.getFullName());
        existing.setSpecialization(doctor.getSpecialization());
        existing.setExperienceYears(doctor.getExperienceYears());

        return doctorRepository.save(existing);
    }

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }
}
