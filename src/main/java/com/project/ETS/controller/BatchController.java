package com.project.ETS.controller;

import com.project.ETS.requestDTO.BatchRequest;
import com.project.ETS.responseDTO.BatchResponse;
import com.project.ETS.service.BatchService;
import com.project.ETS.utility.AppResponseBuilder;
import com.project.ETS.utility.ResponseStructure;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class BatchController {

    private BatchService batchService;
    private AppResponseBuilder responseBuilder;

    @Operation(description = "The API endpoint is used to add the batches",responses = {
            @ApiResponse(responseCode = "201",description = "batch is create"),
            @ApiResponse(responseCode = "500",description = "Internal server Error",
                    content = {
                            @Content(schema = @Schema(anyOf = RuntimeException.class))
                    })
    })
    @PostMapping("/batches")
    public ResponseEntity<ResponseStructure<BatchResponse>> saveBatch(@RequestBody BatchRequest request){
        BatchResponse response = batchService.saveBatch(request);
        return responseBuilder.success(HttpStatus.CREATED, "batch created successfully", response);
    }

    @Operation(description = "The API endpoint is used to update the batch",responses = {
            @ApiResponse(responseCode = "200",description = "batch is updated"),
            @ApiResponse(responseCode = "500",description = "Internal server Error",
                    content = {
                            @Content(schema = @Schema(anyOf = RuntimeException.class))
                    })
    })
    @PutMapping("/batches/{batchId}")
    public ResponseEntity<ResponseStructure<BatchResponse>> updateBatch(@RequestBody BatchRequest request,@PathVariable String batchId){
        BatchResponse response = batchService.updateBatch(request, batchId);
        return responseBuilder.success(HttpStatus.OK, "batch updated successfully", response);
    }
    @Operation(description = "The API endpoint is used to cancel the batch",responses = {
            @ApiResponse(responseCode = "200",description = "batch is cancelled"),
            @ApiResponse(responseCode = "500",description = "Internal server Error",
                    content = {
                            @Content(schema = @Schema(anyOf = RuntimeException.class))
                    })
    })
    @PatchMapping("/batches/{batchId}/cancel")
    public ResponseEntity<ResponseStructure<BatchResponse>> cancelBatch(@PathVariable String batchId){
        BatchResponse response = batchService.cancelBatch(batchId);
        return responseBuilder.success(HttpStatus.OK, "batch canceled succefully", response);
    }

    @Operation(description = "The API endpoint is used to close the batch",responses = {
            @ApiResponse(responseCode = "200",description = "batch is closed"),
            @ApiResponse(responseCode = "500",description = "Internal server Error",
                    content = {
                            @Content(schema = @Schema(anyOf = RuntimeException.class))
                    })
    })
    @PatchMapping("/batches/{batchId}/close")
    public ResponseEntity<ResponseStructure<BatchResponse>> closeBatch(@PathVariable String batchId){
        BatchResponse response = batchService.closeBatch(batchId);
        return responseBuilder.success(HttpStatus.OK, "batch closed successfully", response);
    }


}
