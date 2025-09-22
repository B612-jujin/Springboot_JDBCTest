package kr.ac.kopo.cjj.springboot_jdbctest.controller;

import kr.ac.kopo.cjj.springboot_jdbctest.domain.Player;
import kr.ac.kopo.cjj.springboot_jdbctest.domain.Team;
import kr.ac.kopo.cjj.springboot_jdbctest.repository.PlayerRepository;
import kr.ac.kopo.cjj.springboot_jdbctest.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/exam07")
public class Example07Controller {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private TeamRepository teamRepository;


    @GetMapping
    public String requestInsert(Model model) {
        Team team = new Team();
        team.setName("team");

        Player player = new Player();
        player.setName("김자반");
        player.setTeam(team);
        teamRepository.save(team);

        List<Player> players = playerRepository.findAll();
        List<Team> teams = teamRepository.findAll();

        model.addAttribute("playerList", players);
        model.addAttribute("teamList", teams);

        return "viewPage07";
    }

}
