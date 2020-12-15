package domain;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class RegistrationInfo {
    private String city;
    private String dateFirstMeeting;
    private String lastName;
    private String firstName;
    private String phoneNumber;
    private String dateSecondMeeting;
}
