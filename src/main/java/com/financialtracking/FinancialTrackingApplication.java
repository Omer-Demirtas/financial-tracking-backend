package com.financialtracking;

import com.financialtracking.Repository.AccountRepository;
import com.financialtracking.Repository.OrganizationRepository;
import com.financialtracking.Repository.UserRepository;
import com.financialtracking.domain.Account;
import com.financialtracking.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
@RequiredArgsConstructor
public class FinancialTrackingApplication implements CommandLineRunner
{
	private final UserRepository userRepository;
	private final OrganizationRepository organizationRepository;
	private final AccountRepository accountRepository;

	public static void main(String[] args) {
		SpringApplication.run(FinancialTrackingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception
	{
		/*
		Account account = Account.builder()
				.title("ACCOUNT")
				.description("DESCRIPTION")
				.user(User.builder().id(562L).build())
				.build();

		accountRepository.save(account);
		*/

		/*
		Organization organization = organizationRepository.save(
				Organization.builder()
						.title("GENERIC")
						//.users(Arrays.asList(user))
						.build()
		);

		User user = userRepository.save(
				User.builder()
						.username("Ömer")
						.password("Halil")
						.emil("omer@test.com")
						.organizations(
								Arrays.asList(organization))
						.build()
		);
		*/

		/*
		organizationRepository.save(
				Organization.builder()
						.title("GENERIC")
						.users(Arrays.asList(user))
						.build()
		);
		*/

		/*
		for (int i = 250; i < 400; i++)
		{
			exampleRepository.save(Example.builder()
					.name("EMAİL"+i)
					.exampleId(ExampleId.builder()
							.code("c"+i)
							.id((long) i)
							.build())
					.build());
		}
		*/
		/*
		for (int i = 50; i < 250; i++)
		{
			userRepository.save(User.builder()
					.emil("EMAİL"+i)
					.password("password" + i )
					.username("username" +i )
					.build());
		}

		 */
	}
}
