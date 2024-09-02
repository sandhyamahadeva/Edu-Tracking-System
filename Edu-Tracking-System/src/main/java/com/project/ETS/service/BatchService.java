package com.project.ETS.service;

import com.project.ETS.enums.BatchStatus;
import com.project.ETS.exception.BatchNotFoundByIdException;
import com.project.ETS.mapping.BatchMapping;
import com.project.ETS.model.Batch;
import com.project.ETS.repo.BatchRepo;
import com.project.ETS.requestDTO.BatchRequest;
import com.project.ETS.responseDTO.BatchResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BatchService {

    private BatchRepo batchRepository;
    private BatchMapping mapper;

    public BatchResponse saveBatch(BatchRequest request) {
        Batch batch = mapper.mapToBatchEntity(request, new Batch());
        batch.setBatchStatus(BatchStatus.CREATED);
        batch=batchRepository.save(batch);
        return mapper.mapToBatchResponse(batch);
    }

    public BatchResponse updateBatch(BatchRequest request, String batchId) {
        return batchRepository.findById(batchId).map(batch -> {
            batch = mapper.mapToBatchEntity(request, batch);
            batch= batchRepository.save(batch);
            return mapper.mapToBatchResponse(batch);
        }).orElseThrow(()-> new BatchNotFoundByIdException("failed to update the batch"));
    }

    public BatchResponse cancelBatch(String batchId) {
        return batchRepository.findById(batchId).map(batch ->{
            batch.setBatchStatus(BatchStatus.CANCELLED);
            batch = batchRepository.save(batch);
            return mapper.mapToBatchResponse(batch);
        }).orElseThrow(()->new BatchNotFoundByIdException("failed to cance batch"));
    }

    public BatchResponse closeBatch(String batchId) {
        return batchRepository.findById(batchId).map(batch->{
            batch.setBatchStatus(BatchStatus.CLOSED);
            batch = batchRepository.save(batch);
            return mapper.mapToBatchResponse(batch);
        }).orElseThrow(()-> new BatchNotFoundByIdException("failed to close Batch"));
    }

}
