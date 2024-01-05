package com.openclassrooms.watchlist;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.openclassrooms.watchlist.service.WatchlistService;

@WebMvcTest
@RunWith(SpringRunner.class)
public class WatchlistControllerTest {

	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	WatchlistService watchlistService;
	
	@Test
	public void testShowWatchlistItemForm() throws Exception {
		
		mockMvc.perform(get("/watchlistItemForm"))
		.andExpect(status().is2xxSuccessful())
		.andExpect(view().name("watchlistItemForm"))
		.andExpect(model().size(1))
		.andExpect(model().attributeExists("WatchlistItem"));
	}
	
	@Test
	public void testSubmitWatchlistItemForm() throws Exception {
		mockMvc.perform(post("/watchlistItemForm")
				.param("title", "Top Gun")
				.param("rating", "5.5")
				.param("priority", "L"))
		.andExpect(status().is3xxRedirection())
		.andExpect(redirectedUrl("/watchlist"));
	}
}
