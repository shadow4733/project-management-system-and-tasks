package com.event_module.model;

import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserVerifiedEvent implements Serializable {
    private UUID userId;
    private String username;
}
