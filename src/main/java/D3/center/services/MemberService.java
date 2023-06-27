package D3.center.services;
import D3.center.models.Member;
import D3.center.repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberService {

@Autowired
MemberRepository memberRepository;


    public ResponseEntity<?> createMembers(Member member){
        Optional<Member> exists = memberRepository.findById(member.getId());
        if(exists.isPresent()){
            throw new IllegalStateException("member exists");
        }
        return new ResponseEntity<>(memberRepository.save(member), HttpStatus.CREATED);
    }

    public ResponseEntity<?> getAllMembers(){
        return new ResponseEntity<>(memberRepository.findAll(), HttpStatus.OK);

    }

    public ResponseEntity<?> getMember(Integer id){
        if(memberRepository.findById(id)!=null){
            return new ResponseEntity<>(memberRepository.findById(id), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
