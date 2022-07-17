package dev.shuktika.pensionerdetail.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pensioner {
    @Id
    @Size(min = 12, max = 12, message = "Pleas put 12 digits valid aadhar number")
    private Long aadharNumber;

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Date of birth is required")
    private Date dateOfBirth;

    @NotBlank(message = "Pan is required")
    @Pattern(regexp = "[A-Z]{5}[0-9]{4}[A-z]{1}", flags = Pattern.Flag.UNICODE_CASE, message = "Pleas put valid pan")
    private String pan;

    @NotBlank(message = "Last earned monthly salary is required")
    private Integer salaryEarned;

    @NotBlank(message = "allowances is required")
    private Integer allowances;

    @NotBlank(message = "Pension type(self/family) is required")
    private String pensionType;

    @Embedded
    private BankDetails bankDetails;
}

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
class BankDetails {
    @NotBlank(message = "Bank name is required")
    private String bankName;

    @NotBlank(message = "accountNumber is required")
    private Long accountNumber;

    @NotBlank(message = "Bank type(public/private) is required")
    private String bankType;
}
