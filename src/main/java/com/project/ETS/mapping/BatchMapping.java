package com.project.ETS.mapping;

import com.project.ETS.model.Batch;
import com.project.ETS.requestDTO.BatchRequest;
import com.project.ETS.responseDTO.BatchResponse;
import org.springframework.stereotype.Component;

@Component
public class BatchMapping {

    public Batch mapToBatchEntity(BatchRequest request, Batch batch) {
        batch.setTitle(request.getTitle());
        batch.setSubjects(request.getSubjects());
        batch.setBeginsAt(request.getBeginsAt());
        batch.setEndsAt(request.getEndsAt());
        batch.setStartingDate(request.getStartingDate());
        return batch;
    }

    public BatchResponse mapToBatchResponse(Batch batch) {
        BatchResponse response = new BatchResponse();
        response.setBatchId(batch.getBatchId());
        response.setTitle(batch.getTitle());
        response.setSubjects(batch.getSubjects());
        response.setStartingDate(batch.getStartingDate());
        response.setBeginsAt(batch.getBeginsAt());
        response.setEndsAt(batch.getEndsAt());

        return response;
    }
}
