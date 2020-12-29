package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class RegistrationInfo {
    private String city;
    private String name;
    private String phoneNumber;
}
