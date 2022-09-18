package Controller;

import Service.MemberService;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {
    private final MemberService memberService = new MemberService();

}
