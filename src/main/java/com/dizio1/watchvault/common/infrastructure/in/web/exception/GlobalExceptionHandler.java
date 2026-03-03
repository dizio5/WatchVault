package com.dizio1.watchvault.common.infrastructure.in.web.exception;

import com.dizio1.watchvault.movie.domain.exception.MovieNotFoundException;
import com.dizio1.watchvault.review.domain.exception.InvalidShowTypeException;
import com.dizio1.watchvault.series.domain.exception.SeriesNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MovieNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleMovieNotFound(MovieNotFoundException ex) {
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.name(),
                ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponseDto);
    }

    @ExceptionHandler(SeriesNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleSeriesNotFound(SeriesNotFoundException ex) {
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.name(),
                ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponseDto);
    }

    @ExceptionHandler(InvalidShowTypeException.class)
    public ResponseEntity<ErrorResponseDto> handleInvalidShowTypeException(InvalidShowTypeException ex) {
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST.name(),
                ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponseDto);
    }
}
