package org.example.controller;

import org.example.model.MedicalRecord;

import java.util.ArrayList;
import java.util.List;

public class MedicalRecordController {
    private List<MedicalRecord> medicalRecords = new ArrayList<>();

    // 진료 기록 저장
    public void addMedicalRecord(MedicalRecord record) {
        medicalRecords.add(record);
    }

    // 진료 기록 삭제
    public void removeMedicalRecord(String phoneNumber) {
        for (int i = 0; i < medicalRecords.size(); i++) {
            if (medicalRecords.get(i).getPhoneNumber().equals(phoneNumber)) {
                medicalRecords.remove(i);
                break;
            }
        }
    }

    // 진료 기록 조회
    public List<MedicalRecord> findMedicalRecords(String phoneNumber) {
        List<MedicalRecord> list = new ArrayList<>();

        for (MedicalRecord medicalRecord : medicalRecords) {
            if (medicalRecord.getPhoneNumber().equals(phoneNumber)) {
                list.add(medicalRecord);
            }
        }

        return list;
    }
}
