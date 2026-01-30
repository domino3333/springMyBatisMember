package com.zeus.controller;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zeus.domain.Member;
import com.zeus.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@MapperScan(basePackages = "com.zeus.mapper")
@RequestMapping("/member")
@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;

	@GetMapping("/insertForm")
	public String insertForm(Model model) {
		return "member/insertForm";
	}

	@PostMapping("/insert")
	public String memberInsert(Member member, Model model) {
		log.info("insert board = " + member.toString());
		try {
			int count = memberService.register(member);
			if(count>0) {
				model.addAttribute("message","%s님 등록이 완료되었습니다.".formatted(member.getName()));
				return "member/success";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("message","%s님 등록이 실패되었습니다.".formatted(member.getName()));
		return "member/failed";
	}

	@GetMapping("/memberList")
	public String memberList(Model model) {
		log.info("memberList");

		try {
			List<Member> memberList = memberService.list();
			model.addAttribute("memberList", memberList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "member/memberList";
	}

	@GetMapping("/detail")
	public String boardDetail(Member m, Model model) {
		log.info("MemberDetail member = " + m.toString());

		try {
			Member member = memberService.read(m);
			if (member == null) {
				model.addAttribute("message","%d님의 상세정보가 없습니다.".formatted(member.getName()));
				model.addAttribute("member",member);
				return "member/failed";
			}
			log.info("detail member"+ member.toString());
			model.addAttribute("member",member);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "member/detail";
	}
	
	@GetMapping("/updateForm")
	public String memberUpdateForm(Member m, Model model) {
		log.info("updateForm = " + m.toString());

		try {
			 Member member = memberService.read(m);
			if (member == null) {
				model.addAttribute("message", "%d 님의 정보가 없습니다".formatted(member.getNo()));
				return "member/failed";
			}
			model.addAttribute("member", member);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "member/updateForm";
	}
	

	@PostMapping("/update")
	public String updateBoard( Member m, Model model) {
		log.info("update Member = " + m.toString());

		try {
			int count = memberService.update(m);
			if(count >0) {
				model.addAttribute("message", "%s 님의 회원정보가 수정되었습니다.".formatted(m.getName()));
				return "member/success";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("message", "%s 님의 회원정보 수정 실패".formatted(m.getName()));
		return "member/failed";
	}
	
	@GetMapping("/delete")
	public String memberDelete(Member member, Model model) {
		log.info("member delete = " + member.toString());

		try {
			int count = memberService.delete(member);
			if(count >0) {
				model.addAttribute("message", "%s 님의 회원탈퇴".formatted(member.getName()));
				return "member/success";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("message", "%s 님의 탈퇴 실패".formatted(member.getName()));
		return "member/failed";
	}
	
	/*
	@GetMapping("/search")
	public String boardSearch(Model model, Board board) {
		log.info("searchType = " + board.toString());

		try {
			List<Board> boardList = boardService.boardSearch(board);

			model.addAttribute("boardList", boardList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "board/boardList";
	}
*/
}
