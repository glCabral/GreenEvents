package com.example.greenevents.dtos;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EventRequestDTO {

    @NotNull(message = "O Id não deve ser nulo")
    private Long organizerId;

    @NotBlank(message = "O nome não deve ser nulo")
    @Size(min = 3, message = "Este campo deve conter no mínimo 3 caracteres")
    private String name;

    @NotNull(message = "A data do evento é obrigatória")
    private LocalDateTime date;

    @Size(max = 500, message = "A descrição deve conter no máximo 500 caracteres")
    private String description;

}
