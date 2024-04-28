package com.xalio.speakyourmind.bootstrap;


import com.xalio.speakyourmind.post.Post;
import com.xalio.speakyourmind.post.PostRepository;
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
		                 .username("xalio")
		                 .title("Unraveling the Mysteries of Ancient Civilizations")
		                 .description("Embark on a captivating journey through time as we explore the ruins of lost civilizations. From the towering pyramids of Egypt to the enigmatic statues of Easter Island, join me in uncovering the secrets of our ancestors.")
		                 .upVote(1)
		                 .build();

		Post post2 = Post.builder()
		                 .username("xalio")
		                 .title("Capturing the Essence of Urban Landscapes")
		                 .description("Step into the bustling streets and vibrant alleys of modern metropolises as we delve into the heart of urban life. From towering skyscrapers to hidden street art, let's discover the beauty and chaos of city living.")
		                 .upVote(1)
		                 .build();

		Post post3 = Post.builder()
		                 .username("xalio")
		                 .title("Embracing the Serenity of Nature's Symphony")
		                 .description("Escape the hustle and bustle of daily life and immerse yourself in the tranquil embrace of nature's symphony. From the gentle rustle of leaves to the melodic chirping of birds, join me in finding peace amidst the wilderness.")
		                 .upVote(1)
		                 .build();

		Post post4 = Post.builder()
		                 .username("xalio")
		                 .title("Unlocking the Secrets of the Cosmos")
		                 .description("Embark on a celestial journey through the vast expanse of the cosmos as we unravel the mysteries of the universe. From distant galaxies to elusive black holes, join me in exploring the wonders of outer space.Embark on a celestial journey through the vast expanse of the cosmos as we unravel the mysteries of the universe. From distant galaxies to elusive black holes, join me in exploring the wonders of outer space.Embark on a celestial journey through the vast expanse of the cosmos as we unravel the mysteries of the universe. From distant galaxies to elusive black holes, join me in exploring the wonders of outer space.")
		                 .upVote(1)
		                 .build();


		postRepository.save(post1);
		postRepository.save(post2);
		postRepository.save(post3);
		postRepository.save(post4);

	}
}
