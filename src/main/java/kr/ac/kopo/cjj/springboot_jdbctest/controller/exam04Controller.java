package kr.ac.kopo.cjj.springboot_jdbctest.controller;


import kr.ac.kopo.cjj.springboot_jdbctest.domain.Member;
import kr.ac.kopo.cjj.springboot_jdbctest.repository.MemberRepository04;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

//Entity Manager test를 위한 컨트롤러

@Controller
@RequestMapping("/exam04")
public class exam04Controller {

    @Autowired
    MemberRepository04 Repository;


    @GetMapping
    public String viewHomepage(Model model) {
        Iterable<Member> memberList = Repository.selectMethod();
        model.addAttribute("memberList", memberList);
        return "viewPage04";
    }

    @GetMapping("/new")
    public String newMethod(Model model) {
        model.addAttribute("member", new Member());
        return "viewPage04_new";
    }

    @PostMapping("/insert")
    public String insertMethod(@ModelAttribute("member") Member member) {
        Repository.insertMethod(member);

        return "redirect:/exam04";
    }

    @GetMapping("/edit/{id}")
    public String editMethod(Model model, @PathVariable int id) {
        Member member = Repository.selectMethodById(id);
        model.addAttribute("member", member);
        return "viewPage04_edit";
    }

    @PostMapping("/update")
    public String updateMethod(@ModelAttribute("member") Member member) {
        Repository.updateMethod(member);
        return "redirect:/exam04";
    }


    @GetMapping("/delete/{id}")
    public String deleteMethod(@PathVariable int id) {
        Repository.deleteMethod(id);
        return "redirect:/exam04";
    }

}
