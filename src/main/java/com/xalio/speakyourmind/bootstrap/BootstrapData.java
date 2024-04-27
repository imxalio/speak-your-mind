package com.xalio.speakyourmind.bootstrap;


import com.xalio.speakyourmind.entity.Post;
import com.xalio.speakyourmind.repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BootstrapData implements CommandLineRunner {

	private final PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {
		bootstrapData();
	}

	public void bootstrapData() {
		Post post1 = Post.builder()
		                 .title("Title 1")
		                 .description("Description 1")
		                 .build();
		Post post2 = Post.builder()
		                 .title("Title 2")
		                 .description("Description 2")
		                 .build();
		Post post3 = Post.builder()
		                 .title("Title 3")
		                 .description("Description 3")
		                 .build();
		Post post4 = Post.builder()
		                 .title("Title 4")
		                 .description("Description 4")
		                 .build();

		postRepository.save(post1);
		postRepository.save(post2);
		postRepository.save(post3);
		postRepository.save(post4);

	}
}
