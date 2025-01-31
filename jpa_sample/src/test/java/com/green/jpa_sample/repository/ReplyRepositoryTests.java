package com.green.jpa_sample.repository;

import java.util.Optional;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.green.jpa_sample.entity.Board;
import com.green.jpa_sample.entity.Reply;

@SpringBootTest
public class ReplyRepositoryTests {
	@Autowired
	ReplyRepository replyRepository;

	//@Test
	public void insert() {
		IntStream.rangeClosed(1, 300).forEach(i -> {
			long bno = (long)(Math.random()*100) + 1;
			
			Board board = Board.builder().bno(bno).build();
			
			Reply reply = Reply.builder()
					.text("Reply..." + i)
					.board(board)
					.replyer("guest")
					.build();
			
			replyRepository.save(reply);
		});
	}

	
	
	@Test
	public void readReply1() {
		Optional<Reply> result = replyRepository.findById(1L);
		Reply reply = result.get();
				
		System.out.println(reply);
		System.out.println(reply.getBoard());
		
	}
}
