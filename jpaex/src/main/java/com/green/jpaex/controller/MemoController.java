package com.green.jpaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.green.jpaex.entity.Memo;
import com.green.jpaex.repository.MemoRepository;

@Controller
public class MemoController {
	
	@Autowired
    private MemoRepository memoRepository;

	
	//@RequestMapping("/list")
	public String testSelectAll() {
		List<Memo> list = memoRepository.findAll();
		for(Memo memo : list) {
			System.out.println(memo);
		}
		return "list";
	}
	
	@RequestMapping("/list")
	public String list(@RequestParam("pageNum") Long pageNum, Model model) {
		
		int totalCnt = (int)memoRepository.count();
		
		int pagePerboard = 10;
		
		int pageCount = 5;
		
		int start = (int)Math.floor((pageNum-1)/pageCount)*pageCount + 1;
		
		int end = start + (pageCount - 1);
		
		int realEnd = (totalCnt / 10) + 1;
		
		System.out.println("pageNum : " + pageNum);
		
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("list", memoRepository.findByMnoBetweenOrderByMnoDesc((pageNum*10)-9,pageNum*10));
		model.addAttribute("totalCnt", totalCnt);
		model.addAttribute("start", start);
		model.addAttribute("end", end);
		model.addAttribute("realEnd", realEnd);
	
		
		return "list";
	}
}
