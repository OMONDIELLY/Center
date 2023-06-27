package D3.center.models;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString


@Entity
@Table(name = "member_details")
public class Member {

    @Id
    public int id;
    public String firstname;
    public String lastname;
    public String phoneNo;
    public String email;
    public String location;




}
