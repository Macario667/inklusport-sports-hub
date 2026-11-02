package com.inklusport.external.dto;

/**
 * record representa de manera sencilla un objeto de datos inmutable.
 * ExternalPostResponse
 * @param userId
 * @param id
 * @param title
 * @param body
 */
public record ExternalPostResponse(
        Long userId,
        Long id,
        String title,
        String body
) {
}