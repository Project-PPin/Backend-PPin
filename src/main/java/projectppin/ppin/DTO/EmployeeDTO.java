package projectppin.ppin.DTO;

import lombok.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@ToString(exclude = {"empPw", "resiNum"})
public class EmployeeDTO extends User {

    private Long enb;
    private String empID;
    private String empPw;
    private String name;
    private String resiNum;
    private String phoneNum;
    private String email;
    private int loginErrCount;
    private boolean del_flag;

    private Long companyId;

    private String customFourDigits;

    private List<String> roleNames = new ArrayList<>();

    // DTO 생성자
    public EmployeeDTO(Long enb, String empID, String empPw, String name, String resiNum, String phoneNum, String email, int loginErrCount, boolean del_flag, Long companyId, List<String> roleNames) {
        super(
                empID,
                empPw,
                roleNames.stream().map(str -> new SimpleGrantedAuthority("ROLE_"+str)).collect(Collectors.toList()));

        this.enb = enb;
        this.empID = empID;
        this.empPw = empPw;
        this.name = name;
        this.resiNum = resiNum;
        this.phoneNum = phoneNum;
        this.email = email;
        this.loginErrCount = loginErrCount;
        this.del_flag = del_flag;
        this.companyId = companyId;
        this.roleNames = roleNames;
    }
}
