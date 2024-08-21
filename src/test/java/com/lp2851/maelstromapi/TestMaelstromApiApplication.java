package com.lp2851.maelstromapi;

import org.springframework.boot.SpringApplication;

public class TestMaelstromApiApplication {

	public static void main(String[] args) {
		SpringApplication.from(MaelstromApiApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
