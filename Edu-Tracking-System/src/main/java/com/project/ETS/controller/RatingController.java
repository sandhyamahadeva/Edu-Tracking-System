package com.project.ETS.controller;

import com.project.ETS.requestDTO.RatingRequest;
import com.project.ETS.responseDTO.RatingResponse;
import com.project.ETS.service.RatingService;
import com.project.ETS.utility.AppResponseBuilder;
import com.project.ETS.utility.ResponseStructure;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class RatingController {

    RatingService ratingService;
    AppResponseBuilder responseBuilder;

    @Operation(description = "The API endpoint is used to update ratings",responses = {
            @ApiResponse(responseCode = "200",description = "ratings updated"),
            @ApiResponse(responseCode = "500",description = "Internal server error",
                    content = {
                            @Content(schema = @Schema(anyOf = RuntimeException.class))
                    })
    })
    @PutMapping("/ratings/{ratingId}")
    public ResponseEntity<ResponseStructure<RatingResponse>> updateRatings(@RequestBody RatingRequest request,
                                                                           @PathVariable String ratingId) {
        RatingResponse response = ratingService.updateStudentRating(request, ratingId);
        return responseBuilder.success(HttpStatus.OK, "ratings updated", response);
    }

}
