package org.zerock.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {

	@Setter(onMethod_ = {@Autowired} )
	private BoardMapper mapper; 
	
	@Test
	public void testGetList() {
		mapper.getList().forEach(board-> log.info(board));
	}
	
	@Test
	public void testInsert() {
		BoardVO board = new BoardVO();
		board.setTitle("New Title");
		board.setContent("New Content");
		board.setWriter("New User");
		mapper.insert(board);
		log.info(board);
	}
	@Test
	public void testInsertSelectKey() {
		
		BoardVO board = new BoardVO(); 
		board.setTitle("New Title Select Key");
		board.setContent("New Content Select Key");
		board.setWriter("New User Select Key");
		
		mapper.insertSelectkey(board);
		log.info(board);
	}
	
	@Test
	public void testRead() {
		BoardVO board = mapper.read(2L);
		log.info(board);
	}
	
	@Test
	public void testDelete() {

		log.info("Delete Count : " + mapper.delete(3L));
	
	}
	
	@Test
	public void testUpdate() {
		BoardVO board = new BoardVO();
		board.setBno(5L);
		board.setTitle("Update Title");
		board.setContent("Update Content");
		board.setWriter("Update Writer");
		int count = mapper.update(board);
		log.info("Update Count : " + count);
		
	}
}
