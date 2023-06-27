package D3.center.controllers;
import D3.center.models.Member;
import D3.center.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")


public class MemberController {
    @Autowired
    MemberService memberService;

    @GetMapping(value = "/members")
    public ResponseEntity<?> getMembers(){
        return memberService.getAllMembers();
    }

    @PostMapping(value = "/create/member")
    public ResponseEntity<?> addMember(@RequestBody Member member){
        return memberService.createMembers(member);
    }

    @GetMapping(value = "/member{id}")
    public ResponseEntity<?> getMember(@PathVariable Integer id){
        return memberService.getMember(id);
    }
}
