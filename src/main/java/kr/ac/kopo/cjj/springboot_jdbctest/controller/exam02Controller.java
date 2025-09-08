package kr.ac.kopo.cjj.springboot_jdbctest.controller;

import kr.ac.kopo.cjj.springboot_jdbctest.domain.Member;
import kr.ac.kopo.cjj.springboot_jdbctest.repository.MemberRepository02;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/exam02")
public class exam02Controller {

    @Autowired
    MemberRepository02 repository;


    @GetMapping
    public String viewHomePage(Model model) {
        Iterable<Member> memberList = repository.findAll(); //select * from member
        model.addAttribute("memberList", memberList);
        return "viewPage02";
    }

    @GetMapping("/new")
    public String newMethod(Model model) {
        Member member = new Member();
        model.addAttribute("member", member);

        return "viewPage02_new";
    }

    @PostMapping("/insert")
    public String insertMethod(@ModelAttribute("member") Member member) {

        repository.save(member); //insert into member values(?,?,?)

        return "redirect:/exam02";
    }

    @GetMapping("/edit/{id}")
    public String editMethod(@ModelAttribute("id") int id, Model model) {
        Optional<Member> member = repository.findById(id); //select * from member where id=?
        model.addAttribute("member", member);

        return "viewPage02_edit";
    }

    @PostMapping("/update")
    public String updateMethod(@ModelAttribute("member") Member member) {
        repository.save(member); //update member set name=?, tel=? where id=?

        return "redirect:/exam02";
    }

    @GetMapping("/delete/{id}")
    public String deleteMethod(@ModelAttribute("id") int id) {
        repository.deleteById(id); //delete from member where id=?

        return "redirect:/exam02";
    }
}
